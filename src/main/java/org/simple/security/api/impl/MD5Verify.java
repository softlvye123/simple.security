package org.simple.security.api.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.simple.security.api.Verify;

/**
 * 基于MD5的验签实现（线程安全）:<br/>
 * 计算Md5签名采用的<code>org.apache.commons.codec.digest.DigestUtils</code>的
 * <code>md5Hex</code>实现<br/>
 * 
 * @see org.apache.commons.codec.digest.DigestUtils
 * @author qibaoguang at 2014年8月29日 下午3:15:49
 *
 */
public class MD5Verify implements Verify {

    public boolean verify(final byte[] data, final String sign)
            throws Exception {
        String md5 = DigestUtils.md5Hex(data);
        return sign.equals(md5);
    }

    public boolean verify(String data, String charset, String sign)
            throws Exception {
        return verify(data.getBytes(charset), sign);
    }
}
