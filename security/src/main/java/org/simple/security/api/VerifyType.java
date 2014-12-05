package org.simple.security.api;

/**
 * 支持的验签类型
 * 
 * @author qibaoguang at 2014年9月2日 下午1:23:40
 *
 */
public enum VerifyType {
    /**
     * 基于MD5的验签
     */
    MD5,

    /**
     * 基于X509的RSA验签
     */
    RSA_X509_PUBLIC
}
