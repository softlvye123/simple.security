package org.simple.security.api.impl;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.simple.security.api.Constants;

/**
 * 基于X509规范的RSA公钥验签实现类
 * 
 * @author qibaoguang at 2014年9月1日 上午11:21:04
 * @see com.iapppay.security.api.impl.BaseVerify
 */
public class RSAX509Verify extends BaseVerify {

    private PublicKey pubKey;

    /**
     * 创建基于X509 + RSA的公钥鉴权对象
     * 
     * @param rsaPublicKey
     *            base64编码的rsa公钥
     * @throws Exception
     */
    public RSAX509Verify(String rsaPublicKey) throws Exception {
        this(Base64.decodeBase64(rsaPublicKey));
    }

    public RSAX509Verify(byte[] bytes) throws Exception {
        pubKey = getKey(bytes);
        signature = createSignature();
    }

    private PublicKey getKey(byte[] bytes) throws Exception {
        // 构造X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bytes);
        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory
                .getInstance(Constants.RSA_KEY_ALGORITHM);
        // 取公钥匙对象
        return keyFactory.generatePublic(keySpec);
    }

    @Override
    protected Signature createSignature() throws Exception {
        // 用公钥对象校验签名
        Signature signature = Signature
                .getInstance(Constants.RSA_SIGNATURE_ALGORITHM);
        signature.initVerify(pubKey);
        return signature;
    }

}
