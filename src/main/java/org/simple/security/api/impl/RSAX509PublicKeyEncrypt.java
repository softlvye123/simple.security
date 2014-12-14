package org.simple.security.api.impl;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.simple.security.api.Constants;

/**
 * 基于X509规范的RSA公钥加密
 * 
 * @author qibaoguang at 2014年9月1日 上午10:47:28
 * @see com.iapppay.security.api.impl.BaseEncrypt
 */
public class RSAX509PublicKeyEncrypt extends BaseEncrypt {

    private PublicKey publicKey;

    /**
     * 构造X509+RSA公钥加密对象
     * 
     * @param rsaPublicKey
     *            base64编码的ras公钥
     * @throws Exception
     */
    public RSAX509PublicKeyEncrypt(String rsaPublicKey) throws Exception {
        this(Base64.decodeBase64(rsaPublicKey));
    }

    public RSAX509PublicKeyEncrypt(byte[] bytes) throws Exception {
        publicKey = getKey(bytes);
        cipher = createCipher();
    }

    private PublicKey getKey(byte[] bytes) throws Exception {
        X509EncodedKeySpec publicKeyX509 = new X509EncodedKeySpec(bytes);
        KeyFactory keyFactory = KeyFactory
                .getInstance(Constants.RSA_KEY_ALGORITHM);
        return keyFactory.generatePublic(publicKeyX509);
    }

    @Override
    protected Cipher createCipher() throws Exception {
        Cipher cipher = Cipher.getInstance(Constants.RSA_PKCS1_KEY);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher;
    }

}
