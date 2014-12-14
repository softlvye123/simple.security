package org.simple.security.api.impl;

import java.security.KeyFactory;
import java.security.PrivateKey;

import javax.crypto.Cipher;

import net.oauth.signature.pem.PKCS1EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.simple.security.api.Constants;

/**
 * 基于PKCS1规范的RSA私钥解密实现
 * 
 * @author qibaoguang at 2014年9月1日 上午10:40:22
 * @see com.iapppay.security.api.impl.BaseDecrypt
 */
public class RSAPKCS1PrivateKeyDecrypt extends BaseDecrypt {

    private PrivateKey privateKey;

    /**
     * 构造PKCS1+RSA私钥解密对象
     * 
     * @param rsaPrivateKey
     *            base64编码的rsa私钥
     * @throws Exception
     */
    public RSAPKCS1PrivateKeyDecrypt(String rsaPrivateKey) throws Exception {
        this(Base64.decodeBase64(rsaPrivateKey));
    }

    public RSAPKCS1PrivateKeyDecrypt(byte[] bytes) throws Exception {
        this.privateKey = getKey(bytes);
        this.cipher = createCipher();
    }

    private PrivateKey getKey(byte[] bytes) throws Exception {
        // 生成基于PKCS1的私钥编码对象
        PKCS1EncodedKeySpec privateKeyPKCS1 = new PKCS1EncodedKeySpec(bytes);
        KeyFactory keyFactory = KeyFactory
                .getInstance(Constants.RSA_KEY_ALGORITHM);
        // 提取私钥
        return keyFactory.generatePrivate(privateKeyPKCS1.getKeySpec());
    }

    @Override
    protected Cipher createCipher() throws Exception {
        Cipher cipher = Cipher.getInstance(Constants.RSA_PKCS1_KEY);
        // 初始化cipher
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher;
    }

}
