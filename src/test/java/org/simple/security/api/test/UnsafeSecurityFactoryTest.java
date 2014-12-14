package org.simple.security.api.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.simple.security.api.Decrypt;
import org.simple.security.api.DecryptType;
import org.simple.security.api.Encrypt;
import org.simple.security.api.EncryptType;
import org.simple.security.api.Sign;
import org.simple.security.api.SignType;
import org.simple.security.api.UnsafeSecurityFactory;
import org.simple.security.api.Verify;
import org.simple.security.api.VerifyType;

public class UnsafeSecurityFactoryTest {
    // RSA
    private Encrypt privateKeyEncrypt; // 私钥加密
    private Decrypt publicKeyDecrypt; // 公钥解密
    private Encrypt publicKeyEncrypt; // 公钥加密
    private Decrypt privateKeyDecrypt; // 私钥解密
    private Sign privateKeySign;// 私钥签名
    private Verify publicKeyVerify;// 公钥验签

    // AES
    private Encrypt aesEncrypt;
    private Decrypt aesDecrypt;

    // MD5
    private Sign md5Sign;
    private Verify md5Verify;

    @Before
    public void setUp() throws Exception {

        privateKeyEncrypt = UnsafeSecurityFactory.getEncryptInstance(
                EncryptType.RSA_PKCS1_PRIVATE, Constants.rsaPrivateKey);

        publicKeyDecrypt = UnsafeSecurityFactory.getDecryptInstance(
                DecryptType.RSA_X509_PUBLIC, Constants.rsaPublicKey);

        publicKeyEncrypt = UnsafeSecurityFactory.getEncryptInstance(
                EncryptType.RSA_X509_PUBLIC, Constants.rsaPublicKey);

        privateKeyDecrypt = UnsafeSecurityFactory.getDecryptInstance(
                DecryptType.RSA_PKCS1_PRIVATE, Constants.rsaPrivateKey);

        privateKeySign = UnsafeSecurityFactory.getSignInstance(
                SignType.RSA_PKCS1_PRIVATE, Constants.rsaPrivateKey);

        publicKeyVerify = UnsafeSecurityFactory.getVerifyInstance(
                VerifyType.RSA_X509_PUBLIC, Constants.rsaPublicKey);

        aesEncrypt = UnsafeSecurityFactory.getEncryptInstance(
                EncryptType.AES_PKCS5, Constants.secretyKey);

        aesDecrypt = UnsafeSecurityFactory.getDecryptInstance(
                DecryptType.AES_PKCS5, Constants.secretyKey);

        md5Sign = UnsafeSecurityFactory.getSignInstance(SignType.MD5, null);

        md5Verify = UnsafeSecurityFactory.getVerifyInstance(VerifyType.MD5,
                null);
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

    @Test
    public void aesEncryptAndDecrypt() throws Exception {
        System.out.println("AES加密 - AES解密");
        String encryptStr = aesEncrypt.encrypt(Constants.source,
                Constants.charset);
        System.out.println("加密后:" + encryptStr);
        String source = aesDecrypt.decrypt(encryptStr, Constants.charset);
        System.out.println("解密后:" + source);
        Assert.assertEquals(Constants.source, source);
    }

    @Test
    public void md5SignAndVerify() throws Exception {
        String signStr = md5Sign.sign(Constants.source, Constants.charset);
        System.out.println("签名:" + signStr);
        boolean verifyFlag = md5Verify.verify(Constants.source,
                Constants.charset, signStr);
        System.out.println("验签结果:" + verifyFlag);
        Assert.assertEquals(true, verifyFlag);
    }
}
