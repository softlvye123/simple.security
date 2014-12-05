package org.simple.security.api;

public interface Constants {

    /**
     * RAS算法key
     */
    String RSA_KEY_ALGORITHM = "RSA";

    /**
     * RSA签名算法:MD5+RSA
     */
    String RSA_SIGNATURE_ALGORITHM = "MD5withRSA";

    /**
     * RSA PKCS1加密解密算法key
     */
    String RSA_PKCS1_KEY = "RSA/ECB/PKCS1Padding";

    /**
     * AES PKCS5加密解密算法key
     */
    String AES_PKCS5_KEY = "AES/ECB/PKCS5Padding";

    /**
     * AES算法key
     */
    String AES_KEY_ALGORITHM = "AES";

    /**
     * DES算法key
     */
    String DES_KEY_ALGORITHM = "DES";

    /**
     * 默认编码
     */
    String DEFAULT_CHARSET = "UTF-8";
}
