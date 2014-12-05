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

    // des密钥
    private String secretKey;

    public DESEncrypt(String secretKey) throws Exception {
        this.secretKey = secretKey;
        this.cipher = createCipher();
    }

    @Override
    protected Cipher createCipher() throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(
                secretKey.getBytes(Constants.DEFAULT_CHARSET));
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory
                .getInstance(Constants.DES_KEY_ALGORITHM);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(Constants.DES_KEY_ALGORITHM);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        return cipher;

    }

}
