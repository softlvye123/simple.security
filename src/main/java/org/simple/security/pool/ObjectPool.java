package org.simple.security.pool;

/**
 * 对象池接口，定义对象池的基本操作
 * 
 * @author qibaoguang at 2014年9月1日 下午1:47:14
 *
 * @param <T>
 */
public interface ObjectPool<T> {

    /**
     * 用于向对象池中添加对象
     * 
     * @param obj
     *            待添加的对象
     * @return 操作结果：成功为true，失败为false
     * @throws Exception
     */
    boolean addObject(T obj) throws Exception;

    /**
     * 从对象池中借出对象，需要在finally中使用<code>returnObject(T obj)</code>放回
     * 
     * @return 借出的对象，如果池中为空则新创建一个
     * @throws Exception
     */
    T borrowObject() throws Exception;

    /**
     * 将对象放回到对象池中
     * 
     * @param obj
     *            待放回的对象
     * @return 操作结果：成功为true，失败为false
     * @throws Exception
     */
    boolean returnObject(T obj) throws Exception;

}
