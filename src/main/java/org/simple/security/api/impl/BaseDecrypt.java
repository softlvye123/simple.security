package org.simple.security.api.impl;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.simple.security.api.Constants;
import org.simple.security.api.Decrypt;

/**
 * 解密接口抽象实现类（非线程安全）
 * 
 * @author qibaoguang at 2014年9月1日 上午10:29:51
 * @see com.iapppay.security.api.Decrypt
 */
public abstract class BaseDecrypt implements Decrypt {

    protected Cipher cipher;

    public byte[] decrypt(String encryptStr) throws Exception {
        try {
            return this.cipher.doFinal(Base64.decodeBase64(encryptStr));
        } catch (Exception e) {
            this.cipher = createCipher();
            throw e;
        }
    }

    public String decrypt(String encryptStr, String charset) throws Exception {
        byte[] bytes = decrypt(encryptStr);
        if (bytes == null || bytes.length == 0) {
            return "";
        } else {
            if (charset == null) {
                charset = Constants.DEFAULT_CHARSET;
            }
            return new String(bytes, charset);
        }
    }

    /**
     * 创建对应的加密解密Cipher
     */
    protected abstract Cipher createCipher() throws Exception;

}
