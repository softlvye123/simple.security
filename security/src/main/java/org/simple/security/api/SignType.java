package org.simple.security.api;

/**
 * 支持的签名类型
 * 
 * @author qibaoguang at 2014年9月2日 下午1:20:42
 *
 */
public enum SignType {
    /**
     * 基于MD5的签名
     */
    MD5,

    /**
     * 基于PKCS1的RSA签名
     */
    RSA_PKCS1_PRIVATE
}
