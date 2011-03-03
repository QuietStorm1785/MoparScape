/*
 * Copyright (C) 2011  moparisthebest
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Official forums are http://www.moparscape.org/smf/
 * Email me at admin@moparisthebest.com , I read it but don't usually respond.
 */

package org.moparscape.res;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * This class is meant to retrieve resources from a variety of URLs, including all supported by Java in addition to
 * magnet links, and torrent files both locally and at http and https URLs.
 * <p/>
 * Torrent support is provided through the native java_client powered by libtorrent-rasterbar, the correct executable
 * for your platform is automatically checked for validity and downloaded via HTTP if need be.
 * <p/>
 * This class will refuse to download or extract files of certain extensions, currently including:
 * (exe|bat|cmd|com|sh|bash)
 * This is for security reasons.  The only exception to this rule is it will download java_client.exe for internal
 * purposes, but will only run it if the CRC is correct.
 * <p/>
 * This class is currently NOT thread-safe, so if you try and use it in a multi-threaded environment it will almost
 * certainly break in unexpected and bad ways.  Synchronize around it if you must.
 *
 * @author moparisthebest
 */
public class ResourceGrabber {

    private static final String javaClientLocation = "/tmp/";
    private static final String javaClientURL = "http://www.moparscape.org/libs/";

    public static void main(String[] args) throws IOException {
          extractFile("/home/mopar/tests/extest/client.zip.gz", "/home/mopar/tests/extest/");
    }

    /**
     * Downloads resource specified by url to savePath.
     *
     * @param url      This can be any URL Java can natively handle, in addition to magnet links, and torrent files both locally and at http and https URLs.
     * @param savePath Directory to save the URL to.
     * @throws IOException Passed from calls this method makes.
     */
    public static void download(String url, String savePath) throws IOException {

    }

    /**
     * Downloads resource specified by url to savePath, then extracts the downloaded file. Current supported types are .zip.gz, .zip, and .gz.
     *
     * @param url      This can be any URL Java can natively handle, in addition to magnet links, and torrent files both locally and at http and https URLs.
     * @param savePath Directory to save the URL to, and extract the supported files to.
     * @throws IOException Passed from calls this method makes.
     */
    public static void downloadExtract(String url, String savePath) throws IOException {

    }

    private static void writeStream(InputStream in, OutputStream out) throws IOException {
        writeStream(in, out, null);
    }

    private static void writeStream(InputStream in, OutputStream out, JProgressBar pB) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) >= 0) {
            out.write(buffer, 0, len);
            if (pB != null)
                pB.setValue(pB.getValue() + len);
        }
        // if its a ZipInputStream we don't want to close it
        if(!(in instanceof ZipInputStream))
            in.close();
        out.close();
    }

    /**
     * Currently supports .zip, .gz, and .zip.gz
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    private static void extractFile(String fileName, String savePath) throws IOException {
        boolean checkProgress = true;
        FileInputStream fis = new FileInputStream(fileName);
        InputStream is = null;

        if(fileName.endsWith(".zip.gz"))
            is = new GZIPInputStream(fis);
        else if(fileName.endsWith(".gz")){
            // strip .gz off the end
            fileName = new File(fileName).getName();
            fileName = fileName.substring(0, fileName.length()-3);
            if(badExtension(fileName))
                return;
            if (checkProgress)
                    System.out.println("Extracting File: " + fileName);
            writeStream(new GZIPInputStream(fis), new FileOutputStream(savePath + fileName));
            return;
        }else if(fileName.endsWith(".zip")){
                is = fis;
        }else{
            // otherwise this file can't be extracted, so just return for now
            return;
        }
        ZipInputStream zin = new ZipInputStream(is);
        ZipEntry entry;
        while ((entry = zin.getNextEntry()) != null) {
            if (entry.isDirectory()){ // Checks if the entry is a directory.
                File folder = new File(savePath + entry.getName());
                deleteDirectory(folder);
                if (checkProgress)
                    System.out.println("Creating Directory: " + entry.getName());
                folder.mkdir();
            }else{// If the entry isn't a directory, then it should be a file?
                if(badExtension(entry.getName()))
                    continue;
                if (checkProgress)
                    System.out.println("Extracting File: " + entry.getName());
                writeStream(zin, new FileOutputStream(savePath + entry.getName()));
            }
        }
        zin.close();
    }

    private static boolean downloadFile(String url, String savePath) throws IOException {
        boolean checkProgress = true;
        URLConnection jarUC = new URL(url).openConnection();
        String userAgent = System.getProperty("http.agent");
        if (userAgent == null)
            userAgent = "Mozilla/5.0";
        jarUC.setRequestProperty("User-Agent", userAgent);
        long length = jarUC.getContentLength();
        InputStream in = jarUC.getInputStream();
        JFrame dlFrame = null;
        JProgressBar progressBar = null;
        if (checkProgress) {
            dlFrame = new JFrame("Download Progress");
            dlFrame.setLayout(new BorderLayout());
            progressBar = new JProgressBar(0, (int) length);
            progressBar.setValue(0);
            progressBar.setStringPainted(true);
            dlFrame.getContentPane().add(new JLabel("Downloading " + url), BorderLayout.NORTH);
            dlFrame.getContentPane().add(progressBar, BorderLayout.CENTER);
            dlFrame.getContentPane().add(new JLabel("as " + savePath + "..."), BorderLayout.SOUTH);
            //dlFrame.setContentPane(progressBar);
            dlFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            dlFrame.setResizable(false);
            dlFrame.pack();
            // sets the frame to appear in the middle of the screen
            // when called after pack()
            dlFrame.setLocationRelativeTo(null);
            dlFrame.setVisible(true);

            System.out.println("Downloading " + savePath + "...");
        }

        writeStream(in, new FileOutputStream(savePath), progressBar);

        if (dlFrame != null)
            dlFrame.dispose();
        //File file = new File(saveAs);
        //System.out.println("length: "+length+" file.length(): "+file.length());
        //if (length != file.length())
        //    return false;
        if (checkProgress)
            System.out.println(savePath + " downloaded...");
        return true;
    }

    public static boolean deleteDirectory(File path) {
        if (path.exists()) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    deleteDirectory(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        return (path.delete());
    }

    private static boolean badExtension(String file) {
        String[] badExts = new String[]{".exe", ".bat", ".cmd", ".com", ".sh", ".bash"};
        for(String badExt : badExts)
            if(file.endsWith(badExt))
                return true;
        return false;
    }

    /**
     * Reports whether a url describes a torrent or not.
     *
     * @param url URL to resource.
     * @return true if this is a torrent, false otherwise.
     */
    private static boolean isTorrent(String url) {
        return url.startsWith("magnet:") || url.endsWith(".torrent");
    }
}