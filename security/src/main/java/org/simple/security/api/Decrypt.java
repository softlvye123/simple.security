package org.simple.security.api;

/**
 * 解密接口
 * 
 * @author qibaoguang at 2014年8月29日 下午1:32:30
 *
 */
public interface Decrypt {

    /**
     * 数据解密
     * 
     * @param encryptStr
     *            待解密的base64编码的数据
     * @return 解密后的数据
     * @throws Exception
     */
    public byte[] decrypt(String encryptStr) throws Exception;

    /**
     * 数据解密
     * 
     * @param encryptStr
     *            待解密的base64编码的数据
     * @param charset
     *            字符编码，charset为<code>null</code>时默认设值为"UTF-8"
     * @return 解密后的数据
     * @throws Exception
     */
    public String decrypt(String encryptStr, String charset) throws Exception;

}
