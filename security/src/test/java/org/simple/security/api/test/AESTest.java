package org.simple.security.api.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.simple.security.api.Decrypt;
import org.simple.security.api.Encrypt;
import org.simple.security.api.impl.AESPKCS5Decrypt;
import org.simple.security.api.impl.AESPKCS5Encrypt;

public class AESTest {

    private Encrypt encrypt;
    private Decrypt decrypt;
    private String source = "1234566asdf";
    private String password = "123456admin123455667";
    private String charset = "UTF-8";

    @Before
    public void setUp() throws Exception {
        encrypt = new AESPKCS5Encrypt(password);
        decrypt = new AESPKCS5Decrypt(password);
    }

    @Test
    public void encrypt() throws Exception {
        String encryptStr = encrypt.encrypt(source, charset);
        Assert.assertNotNull(encryptStr);
        System.out.println("加密后:" + encryptStr);
    }

    @Test
    public void decrypt() throws Exception {
        String encryptStr = encrypt.encrypt(source, charset);
        System.out.println("加密后:" + encryptStr);
        String actual = decrypt.decrypt(encryptStr, charset);
        Assert.assertNotNull(actual);
        System.out.println("解密后:" + actual);
        Assert.assertEquals(source, actual);
    }
}
