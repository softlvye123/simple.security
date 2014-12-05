package org.simple.security.api.impl;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.simple.security.api.Constants;

/**
 * 基于X509规范的RSA公钥解密实现
 * 
 * @author qibaoguang at 2014年9月1日 上午11:39:14
 * @see com.iapppay.security.api.impl.BaseDecrypt
 */
public class RSAX509PublicKeyDecrypt extends BaseDecrypt {

    private String rsaPublicKey;

    /**
     * 创建基于X509 + RSA的公钥解密对象
     * 
     * @param rsaPublicKey
     *            base64编码的rsa公钥
     * @throws Exception
     */
    public RSAX509PublicKeyDecrypt(String rsaPublicKey) throws Exception {
        this.rsaPublicKey = rsaPublicKey;
        this.cipher = createCipher();
    }

    @Override
    protected Cipher createCipher() throws Exception {
        X509EncodedKeySpec publicKeyX509 = new X509EncodedKeySpec(
                Base64.decodeBase64(rsaPublicKey));
        KeyFactory keyFactory = KeyFactory
                .getInstance(Constants.RSA_KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(publicKeyX509);
        Cipher cipher = Cipher.getInstance(Constants.RSA_PKCS1_KEY);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher;
    }

}
