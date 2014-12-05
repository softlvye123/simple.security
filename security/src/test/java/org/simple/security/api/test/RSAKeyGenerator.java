package org.simple.security.api.test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.apache.commons.codec.binary.Base64;
import org.simple.security.api.Constants;

public class RSAKeyGenerator {

    public static void main(String[] args) throws Exception {
        // 生成密钥对
        KeyPairGenerator keyGen = KeyPairGenerator
                .getInstance(Constants.RSA_KEY_ALGORITHM);
        keyGen.initialize(1024);
        KeyPair key = keyGen.generateKeyPair();

        RSAPrivateKey rsaPrivate = (RSAPrivateKey) key.getPrivate();
        RSAPublicKey rsaPublic = (RSAPublicKey) key.getPublic();

        System.out.println("私钥："
                + Base64.encodeBase64String(rsaPrivate.getEncoded()));
        System.out.println("公钥："
                + Base64.encodeBase64String(rsaPublic.getEncoded()));
    }
}
