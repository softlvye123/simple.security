package org.simple.security.pool;

import org.simple.security.api.Decrypt;

/**
 * 加入对象池功能的解密实现包装类（线程安全）
 * 
 * @author qibaoguang at 2014年9月1日 下午2:33:52
 *
 * @param <T>
 */
public class SyncDecryptWrapper<T extends Decrypt> implements Decrypt {

    private ObjectPool<T> pool;

    public SyncDecryptWrapper(ObjectFactory<T> factory) throws Exception {
        this.pool = new SimpleObjectPool<T>(factory);
    }

    public byte[] decrypt(String encryptStr) throws Exception {
        T obj = null;
        try {
            obj = pool.borrowObject();
            return obj.decrypt(encryptStr);
        } finally {
            pool.returnObject(obj);
        }
    }

    public String decrypt(String encryptStr, String charset) throws Exception {
        T obj = null;
        try {
            obj = pool.borrowObject();
            return obj.decrypt(encryptStr, charset);
        } finally {
            pool.returnObject(obj);
        }
    }
}
