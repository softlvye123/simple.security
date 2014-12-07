package org.simple.security.api.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.simple.security.api.Decrypt;
import org.simple.security.api.Encrypt;
import org.simple.security.api.Sign;
import org.simple.security.api.Verify;
import org.simple.security.api.impl.RSAPKCS1PrivateKeyDecrypt;
import org.simple.security.api.impl.RSAPKCS1PrivateKeyEncrypt;
import org.simple.security.api.impl.RSAPKCS1Sign;
import org.simple.security.api.impl.RSAX509PublicKeyDecrypt;
import org.simple.security.api.impl.RSAX509PublicKeyEncrypt;
import org.simple.security.api.impl.RSAX509Verify;

public class RSATest {
    private Encrypt privateKeyEncrypt; // 私钥加密
    private Decrypt publicKeyDecrypt; // 公钥解密
    private Encrypt publicKeyEncrypt; // 公钥加密
    private Decrypt privateKeyDecrypt; // 私钥解密
    private Sign privateKeySign;// 私钥签名
    private Verify publicKeyVerify;// 公钥验签

    @Before
    public void setUp() throws Exception {
        privateKeyEncrypt = new RSAPKCS1PrivateKeyEncrypt(
                Constants.rsaPrivateKey);
        publicKeyDecrypt = new RSAX509PublicKeyDecrypt(Constants.rsaPublicKey);
        publicKeyEncrypt = new RSAX509PublicKeyEncrypt(Constants.rsaPublicKey);
        privateKeyDecrypt = new RSAPKCS1PrivateKeyDecrypt(
                Constants.rsaPrivateKey);
        privateKeySign = new RSAPKCS1Sign(Constants.rsaPrivateKey);
        publicKeyVerify = new RSAX509Verify(Constants.rsaPublicKey);
    }

    @Test
    public void privateKeyEncryptAndPublicKeyDecrypt() throws Exception {
        System.out.println("私钥加密 - 公钥解密");
        String encryptStr = privateKeyEncrypt.encrypt(Constants.source,
                Constants.charset);
        System.out.println("加密后:" + encryptStr);
        String source = publicKeyDecrypt.decrypt(encryptStr, Constants.charset);
        System.out.println("解密后:" + source);
        Assert.assertEquals(Constants.source, source);
    }

    @Test
    public void publicKeyEncryptAndPrivateKeyDecrypt() throws Exception {
        System.out.println("公钥加密 - 私钥解密");
        String encryptStr = publicKeyEncrypt.encrypt(Constants.source,
                Constants.charset);
        System.out.println("加密后:" + encryptStr);
        String source = privateKeyDecrypt
                .decrypt(encryptStr, Constants.charset);
        System.out.println("解密后:" + source);
        Assert.assertEquals(Constants.source, source);
    }

    @Test
    public void sign() throws Exception {
        String signStr = privateKeySign.sign(Constants.source,
                Constants.charset);
        Assert.assertNotNull(signStr);
        System.out.println("签名:" + signStr);
    }

    @Test
    public void verify() throws Exception {
        String signStr = privateKeySign.sign(Constants.source,
                Constants.charset);
        System.out.println("签名:" + signStr);
        boolean verifyFlag = publicKeyVerify.verify(Constants.source,
                Constants.charset, signStr);
        System.out.println("验签结果:" + verifyFlag);
        Assert.assertEquals(true, verifyFlag);
    }

}
