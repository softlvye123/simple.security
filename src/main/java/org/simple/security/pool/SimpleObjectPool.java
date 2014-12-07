package org.simple.security.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 简单的对象池实现，基于<code>java.util.concurrent.BlockingQueue</code>
 * 
 * @author qibaoguang at 2014年8月31日 下午5:50:46
 * @param <T>
 * @see java.util.concurrent.BlockingQueue
 */
public class SimpleObjectPool<T> implements ObjectPool<T> {
    // 默认容量
    private static int DEFAULT_CAPACITY = 16;
    private final BlockingQueue<T> queue;
    private final ObjectFactory<T> factory;

    /**
     * 创建对象池，默认大小为10
     * 
     * @param factory
     *            创建对象的工厂
     * @throws Exception
     */
    public SimpleObjectPool(ObjectFactory<T> factory) throws Exception {
        this(factory, DEFAULT_CAPACITY);
    }

    /**
     * 创建指定大小的对象池
     * 
     * @param factory
     *            创建对象的工厂
     * @param capacity
     *            对象池容量
     * @throws Exception
     */
    public SimpleObjectPool(ObjectFactory<T> factory, int capacity)
            throws Exception {
        if (factory == null) {
            throw new IllegalArgumentException(
                    "ObjectFactory must not be null!");
        }
        if (capacity <= 0 || capacity > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(
                    "capacity must in (0,Integer.MAX_VALUE]!");
        }
        this.queue = new ArrayBlockingQueue<T>(capacity);
        this.factory = factory;
        for (int i = 0; i < capacity; i++) {
            addObject(factory.create());
        }
    }

    public T borrowObject() throws Exception {
        T obj = queue.poll();
        if (obj == null) {
            obj = factory.create();
        }
        return obj;
    }

    public boolean returnObject(T obj) throws Exception {
        if (obj == null) {
            return false;
        }
        return queue.offer(obj);
    }

    public boolean addObject(T obj) throws Exception {
        if (obj == null) {
            return false;
        }
        return queue.offer(obj);
    }

    @Override
    public String toString() {
        return "SimpleObjectPool [queue=" + queue + ", factory=" + factory
                + "]";
    }
}
