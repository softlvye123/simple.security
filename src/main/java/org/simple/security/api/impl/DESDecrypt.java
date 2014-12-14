package org.simple.security.api.impl;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.simple.security.api.Constants;

/**
 * DES解密实现
 * 
 * @author qibaoguang at 2014年11月6日 上午11:37:09
 * @see com.iapppay.security.api.impl.BaseDecrypt
 */
public class DESDecrypt extends BaseDecrypt {

    private SecretKey secretkey;

    public DESDecrypt(String secretKey) throws Exception {
        this(secretKey.getBytes(Constants.DEFAULT_CHARSET));
    }

    public DESDecrypt(byte[] bytes) throws Exception {
        secretkey = getSecretKey(bytes);
        cipher = createCipher();
    }

    private SecretKey getSecretKey(byte[] bytes) throws Exception {
        DESKeySpec dks = new DESKeySpec(bytes);
        SecretKeyFactory keyFactory = SecretKeyFactory
                .getInstance(Constants.DES_KEY_ALGORITHM);
        return keyFactory.generateSecret(dks);
    }

    @Override
    protected Cipher createCipher() throws Exception {
        SecureRandom sr = new SecureRandom();
        Cipher cipher = Cipher.getInstance(Constants.DES_KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretkey, sr);
        return cipher;
    }
}
