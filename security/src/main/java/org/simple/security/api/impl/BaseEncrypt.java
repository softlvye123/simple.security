package org.simple.security.api.impl;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.simple.security.api.Encrypt;

/**
 * 加密接口抽象实现类（非线程安全）
 * 
 * @author qibaoguang at 2014年9月1日 上午10:48:47
 * @see com.iapppay.security.api.Encrypt
 */
public abstract class BaseEncrypt implements Encrypt {

    protected Cipher cipher;

    public String encrypt(byte[] src) throws Exception {
        try {
            return Base64.encodeBase64String(cipher.doFinal(src));
        } catch (Exception e) {
            this.cipher = createCipher();
            throw e;
        }
    }

    public String encrypt(String src, String charset) throws Exception {
        return encrypt(src.getBytes(charset));
    }

    /**
     * 创建对应的加密解密Cipher
     */
    protected abstract Cipher createCipher() throws Exception;
}
