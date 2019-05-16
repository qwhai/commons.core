package org.commons.cabinet;

import org.commons.cabinet.containers.ArrayUtils;
import org.commons.cabinet.encrypt.*;
import org.commons.cabinet.encrypt.interf.Decoder;
import org.commons.cabinet.encrypt.interf.Decrypt;
import org.commons.cabinet.encrypt.interf.Encoder;
import org.commons.cabinet.encrypt.interf.Encrypt;
import org.junit.Test;

/**
 * TODO
 *
 * Create Time: 2019/05/16 13:35
 * Last Modify: 2019/05/16
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class EncryptTest extends Testable {

    @Test
    public void test1() {
        Encoder encoder = new Base64();
        logger.info(encoder.encode("Hello world"));
    }

    @Test
    public void test2() {
        Encoder encoder = new Base64();
        logger.info(encoder.encode("你好，世界"));
    }

    @Test
    public void test3() {
        Encoder encoder = new Base64();
        logger.info(encoder.encode("你好，世界".getBytes()));
    }

    @Test
    public void test4() {
        Decoder decoder = new Base64();
        logger.info(decoder.decode("SGVsbG8gd29ybGQ=".getBytes()));
    }

    @Test
    public void test5() {
        Decoder decoder = new Base64();
        logger.info(decoder.decode("5L2g5aW977yM5LiW55WM".getBytes()));
    }

    @Test
    public void test6() {
        Decoder decoder = new Base64();
        logger.info(decoder.decode("5L2g5aW977yM5LiW55WM"));
    }

    @Test
    public void test7() {
        Encoder encoder = new MD5();
        logger.info(encoder.encode("Hello world"));
    }

    @Test
    public void test8() {
        Encoder encoder = new MD5();
        logger.info(encoder.encode("你好，世界"));
    }

    @Test
    public void test9() {
        Encoder encoder = new SHA1();
        logger.info(encoder.encode("Hello world"));
    }

    @Test
    public void test10() {
        Encoder encoder = new SHA1();
        logger.info(encoder.encode("你好，世界"));
    }

    @Test
    public void test11() {
        String plaintext = "Hello world";
        byte[] key = new byte[] {
                0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,
                0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f, 0x10
        };

        Encrypt encrypt = new SMS4();
        ((SMS4) encrypt).setKey(key);

        byte[] cipher = encrypt.encrypt(plaintext.getBytes());
        if (null == cipher) return;
        logger.info(ArrayUtils.output(cipher));
    }

    @Test
    public void test12() {
        String plaintext = "你好，世界";
        byte[] key = new byte[] {
                0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,
                0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f, 0x10
        };

        Encrypt encrypt = new SMS4();
        ((SMS4) encrypt).setKey(key);

        byte[] cipher = encrypt.encrypt(plaintext.getBytes());
        if (null == cipher) return;
        logger.info(ArrayUtils.output(cipher));
    }

    @Test
    public void test13() {
        byte[] cipher = new byte[] {
                -43, -115, -7, -92, 111, 82, 63, -69, 20, -32, 10, 62, -109, -35, 101, -55
        };
        byte[] key = new byte[]{
                0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,
                0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f, 0x10
        };

        Decrypt decrypt = new SMS4();
        ((SMS4) decrypt).setKey(key);

        byte[] data = decrypt.decrypt(cipher);
        if (null == data) return;
        logger.info(new String(data).trim());
    }

    @Test
    public void test14() {
        byte[] cipher = new byte[] {
                96, -87, -49, 31, -125, 29, -62, -74, -96, 1, 127, -8, -52, 107, -82, 8
        };
        byte[] key = new byte[]{
                0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,
                0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f, 0x10
        };

        Decrypt decrypt = new SMS4();
        ((SMS4) decrypt).setKey(key);

        byte[] data = decrypt.decrypt(cipher);
        if (null == data) return;
        logger.info(new String(data).trim());
    }

    @Test
    public void test15() {
        Encoder encoder = new SHA256();
        logger.info(encoder.encode("你好，世界".getBytes()));
    }

    @Test
    public void test16() {
        Encoder encoder = new SHA256();
        logger.info(encoder.encode("你好，世界"));
    }

    @Test
    public void test17() {
        byte[] key = new byte[]{
                0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,
                0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f, 0x10
        };

        Encrypt encrypt = new AES();
        ((AES) encrypt).setKey(key);

        byte[] cipher = encrypt.encrypt("你好，世界".getBytes());
        logger.info(ArrayUtils.output(cipher));
    }

    @Test
    public void test18() {
        byte[] cipher = new byte[] {
                66, -49, -31, 51, 92, 103, -31, 104, -83, -57, 113, 40, 18, -116, -47, -58
        };
        byte[] key = new byte[]{
                0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,
                0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f, 0x10
        };

        Decrypt decrypt = new AES();
        ((AES) decrypt).setKey(key);

        byte[] plain = decrypt.decrypt(cipher);
        logger.info(ArrayUtils.output(plain));
        logger.info(new String(plain));
    }
}