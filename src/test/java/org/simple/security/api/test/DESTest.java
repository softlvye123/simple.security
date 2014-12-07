package org.simple.security.api.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.simple.security.api.Decrypt;
import org.simple.security.api.DecryptType;
import org.simple.security.api.Encrypt;
import org.simple.security.api.EncryptType;
import org.simple.security.api.SecurityFactory;

public class DESTest {

    private Decrypt decrypt;
    private Encrypt encrypt;
    private String secretKey = "asdfa!asafg!#@1";

    final String CHARSET = "UTF-8";
    final String content = "asdfafdafdZzvxszxb";

    @Before
    public void setUp() throws Exception {
        // decrypt = UnsafeSecurityFactory.getDecryptInstance(DecryptType.DES,
        // secretKey);
        // encrypt = UnsafeSecurityFactory.getEncryptInstance(EncryptType.DES,
        // secretKey);
        decrypt = SecurityFactory
                .getDecryptInstance(DecryptType.DES, secretKey);
        encrypt = SecurityFactory
                .getEncryptInstance(EncryptType.DES, secretKey);
    }

    @Test
    public void decrypt() throws Exception {
        String encryptStr = encrypt.encrypt(content, CHARSET);
        System.out.println(encryptStr);
        String decryptStr = decrypt.decrypt(encryptStr, CHARSET);
        System.out.println(decryptStr);
        Assert.assertEquals(decryptStr, content);
    }
}
