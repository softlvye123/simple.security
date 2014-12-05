package org.simple.security.pool;

/**
 * 对象工厂接口，用于创建对象池管理的对象
 * 
 * @author qibaoguang at 2014年9月1日 下午1:46:30
 *
 * @param <T>
 */
public interface ObjectFactory<T> {
    /**
     * 创建对象
     * 
     * @return 创建好的对象
     * @throws Exception
     */
    T create() throws Exception;
}
