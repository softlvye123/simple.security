package org.simple.security.api;

/**
 * 支持的加密类型
 * 
 * @author qibaoguang at 2014年9月2日 下午1:20:20
 *
 */
public enum EncryptType {
    /**
     * 基于PKCS1规范的RSA私钥加密
     */
    RSA_PKCS1_PRIVATE,

    /**
     * 基于X509规范的RSA公钥加密
     */
    RSA_X509_PUBLIC,

    /**
     * 基于PKCS5规范的AES加密
     */
    AES_PKCS5,

    /**
     * DES加密
     */
    DES
}
