package org.simple.security.api;

/**
 * 支持的解密类型
 * 
 * @author qibaoguang at 2014年9月2日 下午1:20:30
 *
 */
public enum DecryptType {
    /**
     * 基于PKCS1规范的RSA私钥解密
     */
    RSA_PKCS1_PRIVATE,

    /**
     * 基于X509规范的RSA公钥解密
     */
    RSA_X509_PUBLIC,

    /**
     * 基于PKCS5规范的AES解密
     */
    AES_PKCS5,

    /**
     * DES解密
     */
    DES
}
