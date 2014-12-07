package org.simple.security.api.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.simple.security.api.Sign;

/**
 * 基于MD5的签名实现(线程安全)：<br/>
 * 采用的org.apache.commons.codec.digest.DigestUtils的md5Hex实现<br/>
 * 
 * @see org.apache.commons.codec.digest.DigestUtils
 * @author qibaoguang at 2014年8月29日 下午3:04:23
 */
public class MD5Sign implements Sign {

    public String sign(final byte[] data) throws Exception {
        return DigestUtils.md5Hex(data);
    }

    public String sign(String data, String charset) throws Exception {
        return sign(data.getBytes(charset));
    }
}
