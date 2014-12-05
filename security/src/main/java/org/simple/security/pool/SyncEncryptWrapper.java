package org.simple.security.pool;

import org.simple.security.api.Encrypt;

/**
 * 加入对象池功能的加密实现包装类（线程安全）
 * 
 * @author qibaoguang at 2014年9月1日 下午2:36:26
 *
 * @param <T>
 */
public class SyncEncryptWrapper<T extends Encrypt> implements Encrypt {

    private ObjectPool<T> pool;

    public SyncEncryptWrapper(ObjectFactory<T> factory) throws Exception {
        this.pool = new SimpleObjectPool<T>(factory);
    }

    public String encrypt(byte[] src) throws Exception {
        T obj = null;
        try {
            obj = pool.borrowObject();
            return obj.encrypt(src);
        } finally {
            pool.returnObject(obj);
        }
    }

    public String encrypt(String src, String charset) throws Exception {
        T obj = null;
        try {
            obj = pool.borrowObject();
            return obj.encrypt(src, charset);
        } finally {
            pool.returnObject(obj);
        }
    }
}
