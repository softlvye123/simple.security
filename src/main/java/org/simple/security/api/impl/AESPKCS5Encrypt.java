package org.simple.security.api.impl;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.simple.security.api.Constants;

/**
 * 基于PKCS5规范的AES加密实现
 * 
 * @author qibaoguang at 2014年9月1日 下午5:19:28
 * @see com.iapppay.security.api.impl.BaseEncrypt
 */
public class AESPKCS5Encrypt extends BaseEncrypt {

    // 明文密码（至少16字节）
    private String password;

    public AESPKCS5Encrypt(String password) throws Exception {
        this.password = password;
        this.cipher = createCipher();
    }

    @Override
    protected Cipher createCipher() throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(
                password.getBytes(Constants.DEFAULT_CHARSET), 0, 16,
                Constants.AES_KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(Constants.AES_PKCS5_KEY);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher;
    }
}
