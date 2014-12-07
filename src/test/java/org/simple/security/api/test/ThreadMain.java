package org.simple.security.api.test;

import org.junit.Assert;
import org.simple.security.api.Decrypt;
import org.simple.security.api.Encrypt;
import org.simple.security.api.impl.RSAPKCS1PrivateKeyEncrypt;
import org.simple.security.api.impl.RSAX509PublicKeyDecrypt;
import org.simple.security.pool.ObjectFactory;
import org.simple.security.pool.SyncDecryptWrapper;
import org.simple.security.pool.SyncEncryptWrapper;

public class ThreadMain {
    static Encrypt privateKeyEncrypt = null;
    static Decrypt publicKeyDecrypt = null;
    static {
        try {
            privateKeyEncrypt = new SyncEncryptWrapper<Encrypt>(
                    new ObjectFactory<Encrypt>() {
                        public Encrypt create() throws Exception {
                            return new RSAPKCS1PrivateKeyEncrypt(
                                    Constants.rsaPrivateKey);
                        }
                    });

            publicKeyDecrypt = new SyncDecryptWrapper<Decrypt>(
                    new ObjectFactory<Decrypt>() {
                        public Decrypt create() throws Exception {
                            return new RSAX509PublicKeyDecrypt(
                                    Constants.rsaPublicKey);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        } // 私钥加密
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName()
                            + " : 私钥加密 - 公钥解密");
                    try {
                        String encryptStr = privateKeyEncrypt.encrypt(
                                Constants.source, Constants.charset);
                        System.out.println(Thread.currentThread().getName()
                                + " 加密后:" + encryptStr);
                        String source = publicKeyDecrypt.decrypt(encryptStr,
                                Constants.charset);
                        System.out.println(Thread.currentThread().getName()
                                + " 解密后:" + source);
                        Assert.assertEquals(Constants.source, source);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "Thread-" + i).start();
        }
    }
}
