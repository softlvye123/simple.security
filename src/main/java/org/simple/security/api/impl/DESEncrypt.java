package org.simple.security.api.impl;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.simple.security.api.Constants;

/**
 * DES加密实现
 * 
 * @author qibaoguang at 2014年11月6日 上午11:37:34
 * @see com.iapppay.security.api.impl.BaseEncrypt
 */
public class DESEncrypt extends BaseEncrypt {

    private SecretKey secretyKey;

    public DESEncrypt(String secretKey) throws Exception {
        this(secretKey.getBytes(Constants.DEFAULT_CHARSET));
    }

    public DESEncrypt(byte[] bytes) throws Exception {
        this.secretyKey = getSecretyKey(bytes);
        this.cipher = createCipher();
    }

    private SecretKey getSecretyKey(byte[] bytes) throws Exception {
        DESKeySpec dks = new DESKeySpec(bytes);
        SecretKeyFactory keyFactory = SecretKeyFactory
                .getInstance(Constants.DES_KEY_ALGORITHM);
        return keyFactory.generateSecret(dks);
    }

    @Override
    protected Cipher createCipher() throws Exception {
        SecureRandom sr = new SecureRandom();
        Cipher cipher = Cipher.getInstance(Constants.DES_KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretyKey, sr);
        return cipher;
    }

}
