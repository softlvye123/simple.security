package org.simple.security.api;

/**
 * 加密接口
 * 
 * @author qibaoguang at 2014年8月29日 下午1:30:02
 *
 */
public interface Encrypt {

    /**
     * 数据加密
     * 
     * @param src
     *            原始数据
     * @return 加密后的base64编码数据
     * @throws Exception
     */
    public String encrypt(byte[] src) throws Exception;

    /**
     * 数据加密
     * 
     * @param src
     *            原始数据
     * @param charset
     *            原始数据的字符编码
     * @return 加密后的base64编码数据
     * @throws Exception
     */
    public String encrypt(String src, String charset) throws Exception;

}
