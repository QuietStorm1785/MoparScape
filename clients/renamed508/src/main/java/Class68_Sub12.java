/* Class68_Sub12 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

final class Class68_Sub12 extends Node
{
    byte[] aByteArray2918;
    NodeCache aClass113_2919;

    static final Class68_Sub12 method686(Class21 class21, int i, int i_0_)
    {
        byte[] is = class21.method338(i_0_, 0, i);
        if (is == null)
            return null;
        return new Class68_Sub12(new Stream(is));
    }

    private Class68_Sub12(Stream class68_sub14)
    {
        ((Stream) class68_sub14).position = ((Stream) class68_sub14).buffer.length - 3;
        int i = class68_sub14.readUByte();
        int i_1_ = class68_sub14.readUShort();
        int i_2_ = i * 10 + 14;
        ((Stream) class68_sub14).position = 0;
        int i_3_ = 0;
        int i_4_ = 0;
        int i_5_ = 0;
        int i_6_ = 0;
        int i_7_ = 0;
        int i_8_ = 0;
        int i_9_ = 0;
        int i_10_ = 0;
        while_82_: for (int i_11_ = 0; i_11_ < i; i_11_++)
        {
            int i_12_ = -1;
            for (;;)
            {
                int i_13_ = class68_sub14.readUByte();
                if (i_13_ != i_12_)
                    i_2_++;
                i_12_ = i_13_ & 0xf;
                if (i_13_ == 7)
                    continue while_82_;
                if (i_13_ == 23)
                    i_3_++;
                else if (i_12_ == 0)
                    i_5_++;
                else if (i_12_ == 1)
                    i_6_++;
                else if (i_12_ == 2)
                    i_4_++;
                else if (i_12_ == 3)
                    i_7_++;
                else if (i_12_ == 4)
                    i_8_++;
                else if (i_12_ == 5)
                    i_9_++;
                else
                {
                    if (i_12_ != 6)
                        break;
                    i_10_++;
                }
            }
            throw new RuntimeException();
        }
        i_2_ += 5 * i_3_;
        i_2_ += 2 * (i_5_ + i_6_ + i_4_ + i_7_ + i_9_);
        i_2_ += i_8_ + i_10_;
        int i_14_ = ((Stream) class68_sub14).position;
        int i_15_ = i + i_3_ + i_4_ + i_5_ + i_6_ + i_7_ + i_8_ + i_9_ + i_10_;
        for (int i_16_ = 0; i_16_ < i_15_; i_16_++)
            class68_sub14.method927();
        i_2_ += ((Stream) class68_sub14).position - i_14_;
        int i_17_ = ((Stream) class68_sub14).position;
        int i_18_ = 0;
        int i_19_ = 0;
        int i_20_ = 0;
        int i_21_ = 0;
        int i_22_ = 0;
        int i_23_ = 0;
        int i_24_ = 0;
        int i_25_ = 0;
        int i_26_ = 0;
        int i_27_ = 0;
        int i_28_ = 0;
        int i_29_ = 0;
        int i_30_ = 0;
        for (int i_31_ = 0; i_31_ < i_4_; i_31_++)
        {
            i_30_ = i_30_ + class68_sub14.readUByte() & 0x7f;
            if (i_30_ == 0 || i_30_ == 32)
                i_10_++;
            else if (i_30_ == 1)
                i_18_++;
            else if (i_30_ == 33)
                i_19_++;
            else if (i_30_ == 7)
                i_20_++;
            else if (i_30_ == 39)
                i_21_++;
            else if (i_30_ == 10)
                i_22_++;
            else if (i_30_ == 42)
                i_23_++;
            else if (i_30_ == 99)
                i_24_++;
            else if (i_30_ == 98)
                i_25_++;
            else if (i_30_ == 101)
                i_26_++;
            else if (i_30_ == 100)
                i_27_++;
            else if (i_30_ == 64 || i_30_ == 65 || i_30_ == 120 || i_30_ == 121 || i_30_ == 123)
                i_28_++;
            else
                i_29_++;
        }
        int i_32_ = 0;
        int i_33_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_28_;
        int i_34_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_9_;
        int i_35_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_8_;
        int i_36_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_7_;
        int i_37_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_18_;
        int i_38_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_20_;
        int i_39_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_22_;
        int i_40_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_5_ + i_6_ + i_9_;
        int i_41_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_5_;
        int i_42_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_29_;
        int i_43_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_6_;
        int i_44_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_19_;
        int i_45_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_21_;
        int i_46_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_23_;
        int i_47_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_10_;
        int i_48_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_7_;
        int i_49_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_24_;
        int i_50_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_25_;
        int i_51_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_26_;
        int i_52_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_27_;
        int i_53_ = ((Stream) class68_sub14).position;
        ((Stream) class68_sub14).position += i_3_ * 3;
        ((Class68_Sub12) this).aByteArray2918 = new byte[i_2_];
        Stream class68_sub14_54_ = new Stream(((Class68_Sub12) this).aByteArray2918);
        class68_sub14_54_.writeDWord(1297377380);
        class68_sub14_54_.writeDWord(6);
        class68_sub14_54_.writeShort(i > 1 ? 1 : 0);
        class68_sub14_54_.writeShort(i);
        class68_sub14_54_.writeShort(i_1_);
        ((Stream) class68_sub14).position = i_14_;
        int i_55_ = 0;
        int i_56_ = 0;
        int i_57_ = 0;
        int i_58_ = 0;
        int i_59_ = 0;
        int i_60_ = 0;
        int i_61_ = 0;
        int[] is = new int[128];
        i_30_ = 0;
        for (int i_62_ = 0; i_62_ < i; i_62_++)
        {
            class68_sub14_54_.writeDWord(1297379947);
            ((Stream) class68_sub14_54_).position += 4;
            int i_63_ = ((Stream) class68_sub14_54_).position;
            int i_64_ = -1;
            while_83_: do
            {
                for (;;)
                {
                    int i_65_ = class68_sub14.method927();
                    class68_sub14_54_.method936(i_65_, 9684);
                    int i_66_ = ((((Stream) class68_sub14).buffer[i_32_++]) & 0xff);
                    boolean bool = i_66_ != i_64_;
                    i_64_ = i_66_ & 0xf;
                    if (i_66_ == 7)
                    {
                        if (bool)
                            class68_sub14_54_.writeByte(255);
                        class68_sub14_54_.writeByte(47);
                        class68_sub14_54_.writeByte(0);
                        break while_83_;
                    }
                    if (i_66_ == 23)
                    {
                        if (bool)
                            class68_sub14_54_.writeByte(255);
                        class68_sub14_54_.writeByte(81);
                        class68_sub14_54_.writeByte(3);
                        class68_sub14_54_.writeByte((((Stream) class68_sub14).buffer[i_53_++]));
                        class68_sub14_54_.writeByte((((Stream) class68_sub14).buffer[i_53_++]));
                        class68_sub14_54_.writeByte((((Stream) class68_sub14).buffer[i_53_++]));
                    } else
                    {
                        i_55_ ^= i_66_ >> 4;
                        if (i_64_ == 0)
                        {
                            if (bool)
                                class68_sub14_54_.writeByte(i_55_ + 144);
                            i_56_ += (((Stream) class68_sub14).buffer[i_40_++]);
                            i_57_ += (((Stream) class68_sub14).buffer[i_41_++]);
                            class68_sub14_54_.writeByte(i_56_ & 0x7f);
                            class68_sub14_54_.writeByte(i_57_ & 0x7f);
                        } else if (i_64_ == 1)
                        {
                            if (bool)
                                class68_sub14_54_.writeByte(i_55_ + 128);
                            i_56_ += (((Stream) class68_sub14).buffer[i_40_++]);
                            i_58_ += (((Stream) class68_sub14).buffer[i_43_++]);
                            class68_sub14_54_.writeByte(i_56_ & 0x7f);
                            class68_sub14_54_.writeByte(i_58_ & 0x7f);
                        } else if (i_64_ == 2)
                        {
                            if (bool)
                                class68_sub14_54_.writeByte(i_55_ + 176);
                            i_30_ = i_30_ + (((Stream) class68_sub14).buffer[i_17_++]) & 0x7f;
                            class68_sub14_54_.writeByte(i_30_);
                            int i_67_;
                            if (i_30_ == 0 || i_30_ == 32)
                                i_67_ = (((Stream) class68_sub14).buffer[i_47_++]);
                            else if (i_30_ == 1)
                                i_67_ = (((Stream) class68_sub14).buffer[i_37_++]);
                            else if (i_30_ == 33)
                                i_67_ = (((Stream) class68_sub14).buffer[i_44_++]);
                            else if (i_30_ == 7)
                                i_67_ = (((Stream) class68_sub14).buffer[i_38_++]);
                            else if (i_30_ == 39)
                                i_67_ = (((Stream) class68_sub14).buffer[i_45_++]);
                            else if (i_30_ == 10)
                                i_67_ = (((Stream) class68_sub14).buffer[i_39_++]);
                            else if (i_30_ == 42)
                                i_67_ = (((Stream) class68_sub14).buffer[i_46_++]);
                            else if (i_30_ == 99)
                                i_67_ = (((Stream) class68_sub14).buffer[i_49_++]);
                            else if (i_30_ == 98)
                                i_67_ = (((Stream) class68_sub14).buffer[i_50_++]);
                            else if (i_30_ == 101)
                                i_67_ = (((Stream) class68_sub14).buffer[i_51_++]);
                            else if (i_30_ == 100)
                                i_67_ = (((Stream) class68_sub14).buffer[i_52_++]);
                            else if (i_30_ == 64 || i_30_ == 65 || i_30_ == 120 || i_30_ == 121 || i_30_ == 123)
                                i_67_ = (((Stream) class68_sub14).buffer[i_33_++]);
                            else
                                i_67_ = (((Stream) class68_sub14).buffer[i_42_++]);
                            i_67_ += is[i_30_];
                            is[i_30_] = i_67_;
                            class68_sub14_54_.writeByte(i_67_ & 0x7f);
                        } else if (i_64_ == 3)
                        {
                            if (bool)
                                class68_sub14_54_.writeByte(i_55_ + 224);
                            i_59_ += (((Stream) class68_sub14).buffer[i_48_++]);
                            i_59_ += (((Stream) class68_sub14).buffer[i_36_++]) << 7;
                            class68_sub14_54_.writeByte(i_59_ & 0x7f);
                            class68_sub14_54_.writeByte(i_59_ >> 7 & 0x7f);
                        } else if (i_64_ == 4)
                        {
                            if (bool)
                                class68_sub14_54_.writeByte(i_55_ + 208);
                            i_60_ += (((Stream) class68_sub14).buffer[i_35_++]);
                            class68_sub14_54_.writeByte(i_60_ & 0x7f);
                        } else if (i_64_ == 5)
                        {
                            if (bool)
                                class68_sub14_54_.writeByte(i_55_ + 160);
                            i_56_ += (((Stream) class68_sub14).buffer[i_40_++]);
                            i_61_ += (((Stream) class68_sub14).buffer[i_34_++]);
                            class68_sub14_54_.writeByte(i_56_ & 0x7f);
                            class68_sub14_54_.writeByte(i_61_ & 0x7f);
                        } else
                        {
                            if (i_64_ != 6)
                                break;
                            if (bool)
                                class68_sub14_54_.writeByte(i_55_ + 192);
                            class68_sub14_54_.writeByte((((Stream) class68_sub14).buffer[i_47_++]));
                        }
                    }
                }
                throw new RuntimeException();
            } while (false);
            class68_sub14_54_.writeSizeInteger((((Stream) class68_sub14_54_).position) - i_63_);
        }
    }

    final void method687()
    {
        ((Class68_Sub12) this).aClass113_2919 = null;
    }

    final void method688()
    {
        if (((Class68_Sub12) this).aClass113_2919 == null)
        {
            ((Class68_Sub12) this).aClass113_2919 = new NodeCache(16);
            int[] is = new int[16];
            int[] is_68_ = new int[16];
            is[9] = is_68_[9] = 128;
            Class10 class10 = new Class10(((Class68_Sub12) this).aByteArray2918);
            int i = class10.method216();
            for (int i_69_ = 0; i_69_ < i; i_69_++)
            {
                class10.method215(i_69_);
                class10.method222(i_69_);
                class10.method225(i_69_);
            }
            while_84_: for (;;)
            {
                int i_70_ = class10.method214();
                int i_71_ = ((Class10) class10).anIntArray182[i_70_];
                while (((Class10) class10).anIntArray182[i_70_] == i_71_)
                {
                    class10.method215(i_70_);
                    int i_72_ = class10.method226(i_70_);
                    if (i_72_ == 1)
                    {
                        class10.method224();
                        class10.method225(i_70_);
                        if (!class10.method228())
                            break;
                        break while_84_;
                    }
                    int i_73_ = i_72_ & 0xf0;
                    if (i_73_ == 176)
                    {
                        int i_74_ = i_72_ & 0xf;
                        int i_75_ = i_72_ >> 8 & 0x7f;
                        int i_76_ = i_72_ >> 16 & 0x7f;
                        if (i_75_ == 0)
                            is[i_74_] = (is[i_74_] & ~0x1fc000) + (i_76_ << 14);
                        if (i_75_ == 32)
                            is[i_74_] = (is[i_74_] & ~0x3f80) + (i_76_ << 7);
                    }
                    if (i_73_ == 192)
                    {
                        int i_77_ = i_72_ & 0xf;
                        int i_78_ = i_72_ >> 8 & 0x7f;
                        is_68_[i_77_] = is[i_77_] + i_78_;
                    }
                    if (i_73_ == 144)
                    {
                        int i_79_ = i_72_ & 0xf;
                        int i_80_ = i_72_ >> 8 & 0x7f;
                        int i_81_ = i_72_ >> 16 & 0x7f;
                        if (i_81_ > 0)
                        {
                            int i_82_ = is_68_[i_79_];
                            Class68_Sub16 class68_sub16 = ((Class68_Sub16) ((Class68_Sub12) this).aClass113_2919.method1684((long) i_82_, 75));
                            if (class68_sub16 == null)
                            {
                                class68_sub16 = new Class68_Sub16(new byte[128]);
                                ((Class68_Sub12) this).aClass113_2919.method1683((byte) -19, class68_sub16, (long) i_82_);
                            }
                            ((Class68_Sub16) class68_sub16).aByteArray3023[i_80_] = (byte) 1;
                        }
                    }
                    class10.method222(i_70_);
                    class10.method225(i_70_);
                }
            }
        }
    }
}