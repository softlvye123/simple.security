package org.simple.security.pool;

import org.simple.security.api.Verify;

/**
 * 加入对象池功能的验签实现包装类（线程安全）
 * 
 * @author qibaoguang at 2014年9月1日 下午2:37:47
 *
 * @param <T>
 */
public class SyncVerifyWrapper<T extends Verify> implements Verify {

    private ObjectPool<T> pool;

    public SyncVerifyWrapper(ObjectFactory<T> factory) throws Exception {
        this.pool = new SimpleObjectPool<T>(factory);
    }

    public boolean verify(byte[] data, String sign) throws Exception {
        T obj = null;
        try {
            obj = pool.borrowObject();
            return obj.verify(data, sign);
        } finally {
            pool.returnObject(obj);
        }
    }

    public boolean verify(String data, String charset, String sign)
            throws Exception {
        T obj = null;
        try {
            obj = pool.borrowObject();
            return obj.verify(data, charset, sign);
        } finally {
            pool.returnObject(obj);
        }
    }
}
