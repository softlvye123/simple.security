package org.simple.security.api.impl;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.simple.security.api.Constants;

/**
 * 基于PKCS5规范的AES解密实现
 * 
 * @author qibaoguang at 2014年9月1日 下午5:08:32
 * @see com.iapppay.security.api.impl.BaseDecrypt
 */
public class AESPKCS5Decrypt extends BaseDecrypt {

    private SecretKeySpec key;

    public AESPKCS5Decrypt(String password) throws Exception {
        this(password.getBytes(Constants.DEFAULT_CHARSET));
    }

    public AESPKCS5Decrypt(byte[] bytes) throws Exception {
        key = getKey(bytes);
        this.cipher = createCipher();
    }

    public SecretKeySpec getKey(byte[] bytes) {
        return new SecretKeySpec(bytes, 0, 16, Constants.AES_KEY_ALGORITHM);
    }

    @Override
    protected Cipher createCipher() throws Exception {
        Cipher cipher = Cipher.getInstance(Constants.AES_PKCS5_KEY);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher;
    }
}
