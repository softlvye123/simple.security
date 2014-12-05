package org.simple.security.pool;

import org.simple.security.api.Sign;

/**
 * 加入对象池功能的签名实现包装类（线程安全）
 * 
 * @author qibaoguang at 2014年9月1日 下午2:38:15
 *
 * @param <T>
 */
public class SyncSignWrapper<T extends Sign> implements Sign {

    private ObjectPool<T> pool;

    public SyncSignWrapper(ObjectFactory<T> factory) throws Exception {
        this.pool = new SimpleObjectPool<T>(factory);
    }

    public String sign(byte[] data) throws Exception {
        T obj = null;
        try {
            obj = pool.borrowObject();
            return obj.sign(data);
        } finally {
            pool.returnObject(obj);
        }
    }

    public String sign(String data, String charset) throws Exception {
        T obj = null;
        try {
            obj = pool.borrowObject();
            return obj.sign(data, charset);
        } finally {
            pool.returnObject(obj);
        }
    }
}
