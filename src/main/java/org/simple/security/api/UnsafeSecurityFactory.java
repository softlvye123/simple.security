package org.simple.security.api;

import org.simple.security.api.impl.AESPKCS5Decrypt;
import org.simple.security.api.impl.AESPKCS5Encrypt;
import org.simple.security.api.impl.DESDecrypt;
import org.simple.security.api.impl.DESEncrypt;
import org.simple.security.api.impl.MD5Sign;
import org.simple.security.api.impl.MD5Verify;
import org.simple.security.api.impl.RSAPKCS1PrivateKeyDecrypt;
import org.simple.security.api.impl.RSAPKCS1PrivateKeyEncrypt;
import org.simple.security.api.impl.RSAPKCS1Sign;
import org.simple.security.api.impl.RSAX509PublicKeyDecrypt;
import org.simple.security.api.impl.RSAX509PublicKeyEncrypt;
import org.simple.security.api.impl.RSAX509Verify;

/**
 * 加密，解密，验签，签名工厂类。不保证具体实现类的线程安全性
 * 
 * @author qibaoguang at 2014年9月2日 上午9:43:05
 *
 */
public class UnsafeSecurityFactory {

    /**
     * 根据加密类型获取加密实现
     * 
     * @param encryptType
     *            加密类型
     * @param secretKey
     *            密钥
     * @return 加密实现
     * @throws Exception
     */
    public static Encrypt getEncryptInstance(EncryptType encryptType,
            final String secretKey) throws Exception {
        switch (encryptType) {
        case RSA_PKCS1_PRIVATE:
            return new RSAPKCS1PrivateKeyEncrypt(secretKey);
        case RSA_X509_PUBLIC:
            return new RSAX509PublicKeyEncrypt(secretKey);
        case AES_PKCS5:
            return new AESPKCS5Encrypt(secretKey);
        case DES:
            return new DESEncrypt(secretKey);
        default:
            throw new IllegalArgumentException("the encrypt type ["
                    + encryptType + "] does't support!");
        }
    }

    /**
     * 根据解密类型获取对应的解密实现
     * 
     * @param decryptType
     *            解密类型
     * @param secretKey
     *            密钥
     * @return 解密实现
     * @throws Exception
     */
    public static Decrypt getDecryptInstance(DecryptType decryptType,
            final String secretKey) throws Exception {
        switch (decryptType) {
        case RSA_PKCS1_PRIVATE:
            return new RSAPKCS1PrivateKeyDecrypt(secretKey);
        case RSA_X509_PUBLIC:
            return new RSAX509PublicKeyDecrypt(secretKey);
        case AES_PKCS5:
            return new AESPKCS5Decrypt(secretKey);
        case DES:
            return new DESDecrypt(secretKey);
        default:
            throw new IllegalArgumentException("the decrypt type ["
                    + decryptType + "] does't support!");
        }
    }

    /**
     * 根据签名类型获取对应的签名实现
     * 
     * @param signType
     *            签名类型
     * @param secretKey
     *            密钥
     * @return 签名实现
     * @throws Exception
     */
    public static Sign getSignInstance(SignType signType, final String secretKey)
            throws Exception {
        switch (signType) {
        case MD5:
            return new MD5Sign();
        case RSA_PKCS1_PRIVATE:
            return new RSAPKCS1Sign(secretKey);
        default:
            throw new IllegalArgumentException("the sign type [" + signType
                    + "] does't support!");
        }
    }

    /**
     * 根据验签类型获取对应的验签实现
     * 
     * @return
     * @throws Exception
     */
    public static Verify getVerifyInstance(VerifyType verifyType,
            final String secretKey) throws Exception {
        switch (verifyType) {
        case MD5:
            return new MD5Verify();
        case RSA_X509_PUBLIC:
            return new RSAX509Verify(secretKey);
        default:
            throw new IllegalArgumentException("the verify type [" + verifyType
                    + "] does't support!");
        }
    }
}
