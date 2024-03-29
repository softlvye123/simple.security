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
import org.simple.security.pool.ObjectFactory;
import org.simple.security.pool.SyncDecryptWrapper;
import org.simple.security.pool.SyncEncryptWrapper;
import org.simple.security.pool.SyncSignWrapper;
import org.simple.security.pool.SyncVerifyWrapper;

/**
 * 加密，解密，验签，签名工厂类
 * 
 * @author qibaoguang at 2014年9月2日 上午9:43:05
 *
 */
public class SecurityFactory {

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
            return new SyncEncryptWrapper<Encrypt>(
                    new ObjectFactory<Encrypt>() {
                        @Override
                        public Encrypt create() throws Exception {
                            return new RSAPKCS1PrivateKeyEncrypt(secretKey);
                        }
                    });
        case RSA_X509_PUBLIC:
            return new SyncEncryptWrapper<Encrypt>(
                    new ObjectFactory<Encrypt>() {
                        @Override
                        public Encrypt create() throws Exception {
                            return new RSAX509PublicKeyEncrypt(secretKey);
                        }
                    });
        case AES_PKCS5:
            return new SyncEncryptWrapper<Encrypt>(
                    new ObjectFactory<Encrypt>() {
                        @Override
                        public Encrypt create() throws Exception {
                            return new AESPKCS5Encrypt(secretKey);
                        }
                    });
        case DES:
            return new SyncEncryptWrapper<Encrypt>(
                    new ObjectFactory<Encrypt>() {
                        @Override
                        public Encrypt create() throws Exception {
                            return new DESEncrypt(secretKey);
                        }
                    });
        default:
            throw new IllegalArgumentException("the encrypt type ["
                    + encryptType + "] does't support!");
        }
    }

    /**
     * 根据加密类型获取加密实现
     * 
     * @param encryptType
     *            加密类型
     * @param bytes
     *            密钥byte数组
     * @return 加密实现
     * @throws Exception
     */
    public static Encrypt getEncryptInstanceByBytes(EncryptType encryptType,
            final byte[] bytes) throws Exception {
        switch (encryptType) {
        case RSA_PKCS1_PRIVATE:
            return new SyncEncryptWrapper<Encrypt>(
                    new ObjectFactory<Encrypt>() {
                        @Override
                        public Encrypt create() throws Exception {
                            return new RSAPKCS1PrivateKeyEncrypt(bytes);
                        }
                    });
        case RSA_X509_PUBLIC:
            return new SyncEncryptWrapper<Encrypt>(
                    new ObjectFactory<Encrypt>() {
                        @Override
                        public Encrypt create() throws Exception {
                            return new RSAX509PublicKeyEncrypt(bytes);
                        }
                    });
        case AES_PKCS5:
            return new SyncEncryptWrapper<Encrypt>(
                    new ObjectFactory<Encrypt>() {
                        @Override
                        public Encrypt create() throws Exception {
                            return new AESPKCS5Encrypt(bytes);
                        }
                    });
        case DES:
            return new SyncEncryptWrapper<Encrypt>(
                    new ObjectFactory<Encrypt>() {
                        @Override
                        public Encrypt create() throws Exception {
                            return new DESEncrypt(bytes);
                        }
                    });
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
            return new SyncDecryptWrapper<Decrypt>(
                    new ObjectFactory<Decrypt>() {
                        @Override
                        public Decrypt create() throws Exception {
                            return new RSAPKCS1PrivateKeyDecrypt(secretKey);
                        }
                    });
        case RSA_X509_PUBLIC:
            return new SyncDecryptWrapper<Decrypt>(
                    new ObjectFactory<Decrypt>() {
                        @Override
                        public Decrypt create() throws Exception {
                            return new RSAX509PublicKeyDecrypt(secretKey);
                        }
                    });
        case AES_PKCS5:
            return new SyncDecryptWrapper<Decrypt>(
                    new ObjectFactory<Decrypt>() {
                        @Override
                        public Decrypt create() throws Exception {
                            return new AESPKCS5Decrypt(secretKey);
                        }
                    });
        case DES:
            return new SyncDecryptWrapper<Decrypt>(
                    new ObjectFactory<Decrypt>() {
                        @Override
                        public Decrypt create() throws Exception {
                            return new DESDecrypt(secretKey);
                        }
                    });
        default:
            throw new IllegalArgumentException("the decrypt type ["
                    + decryptType + "] does't support!");
        }
    }

    /**
     * 根据解密类型获取对应的解密实现
     * 
     * @param decryptType
     *            解密类型
     * @param byte[] 密钥byte数组
     * @return 解密实现
     * @throws Exception
     */
    public static Decrypt getDecryptInstanceByBytes(DecryptType decryptType,
            final byte[] bytes) throws Exception {
        switch (decryptType) {
        case RSA_PKCS1_PRIVATE:
            return new SyncDecryptWrapper<Decrypt>(
                    new ObjectFactory<Decrypt>() {
                        @Override
                        public Decrypt create() throws Exception {
                            return new RSAPKCS1PrivateKeyDecrypt(bytes);
                        }
                    });
        case RSA_X509_PUBLIC:
            return new SyncDecryptWrapper<Decrypt>(
                    new ObjectFactory<Decrypt>() {
                        @Override
                        public Decrypt create() throws Exception {
                            return new RSAX509PublicKeyDecrypt(bytes);
                        }
                    });
        case AES_PKCS5:
            return new SyncDecryptWrapper<Decrypt>(
                    new ObjectFactory<Decrypt>() {
                        @Override
                        public Decrypt create() throws Exception {
                            return new AESPKCS5Decrypt(bytes);
                        }
                    });
        case DES:
            return new SyncDecryptWrapper<Decrypt>(
                    new ObjectFactory<Decrypt>() {
                        @Override
                        public Decrypt create() throws Exception {
                            return new DESDecrypt(bytes);
                        }
                    });
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
            return new SyncSignWrapper<Sign>(new ObjectFactory<Sign>() {
                @Override
                public Sign create() throws Exception {
                    return new RSAPKCS1Sign(secretKey);
                }
            });
        default:
            throw new IllegalArgumentException("the sign type [" + signType
                    + "] does't support!");
        }
    }

    /**
     * 根据签名类型获取对应的签名实现
     * 
     * @param signType
     *            签名类型
     * @param byte[] 密钥byte数组
     * @return 签名实现
     * @throws Exception
     */
    public static Sign getSignInstanceByBytes(SignType signType,
            final byte[] bytes) throws Exception {
        switch (signType) {
        case MD5:
            return new MD5Sign();
        case RSA_PKCS1_PRIVATE:
            return new SyncSignWrapper<Sign>(new ObjectFactory<Sign>() {
                @Override
                public Sign create() throws Exception {
                    return new RSAPKCS1Sign(bytes);
                }
            });
        default:
            throw new IllegalArgumentException("the sign type [" + signType
                    + "] does't support!");
        }
    }

    /**
     * 根据验签类型获取对应的验签实现
     * 
     * @param verifyType
     *            验签算法类型
     * @param secretKey
     *            密钥
     * @return 验签实现
     * @throws Exception
     */
    public static Verify getVerifyInstance(VerifyType verifyType,
            final String secretKey) throws Exception {
        switch (verifyType) {
        case MD5:
            return new MD5Verify();
        case RSA_X509_PUBLIC:
            return new SyncVerifyWrapper<Verify>(new ObjectFactory<Verify>() {
                @Override
                public Verify create() throws Exception {
                    return new RSAX509Verify(secretKey);
                }
            });
        default:
            throw new IllegalArgumentException("the verify type [" + verifyType
                    + "] does't support!");
        }
    }

    /**
     * 根据验签类型获取对应的验签实现
     * 
     * @param verifyType
     *            验签算法类型
     * @param bytes
     *            密钥byte数组
     * @return 验签实例
     * @throws Exception
     */
    public static Verify getVerifyInstanceByBytes(VerifyType verifyType,
            final byte[] bytes) throws Exception {
        switch (verifyType) {
        case MD5:
            return new MD5Verify();
        case RSA_X509_PUBLIC:
            return new SyncVerifyWrapper<Verify>(new ObjectFactory<Verify>() {
                @Override
                public Verify create() throws Exception {
                    return new RSAX509Verify(bytes);
                }
            });
        default:
            throw new IllegalArgumentException("the verify type [" + verifyType
                    + "] does't support!");
        }
    }
}
