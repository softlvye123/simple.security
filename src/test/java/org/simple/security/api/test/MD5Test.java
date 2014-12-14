package org.simple.security.api.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.simple.security.api.Sign;
import org.simple.security.api.Verify;
import org.simple.security.api.impl.MD5Sign;
import org.simple.security.api.impl.MD5Verify;

public class MD5Test {

    private final String source = " wqeqewqweqww";
    private Sign sign;
    private Verify verify;

    @Before
    public void setUp() {
        sign = new MD5Sign();
        verify = new MD5Verify();
    }

    @Test
    public void sign() throws Exception {
        String md5 = sign.sign(source.getBytes());
        Assert.assertNotNull(md5);
        System.out.println(md5);
        System.out.println(md5.length());
    }

    @Test
    public void verify() throws Exception {
        String md5 = sign.sign(source.getBytes());
        boolean verifyFlag = verify.verify(source.getBytes(), md5);
        Assert.assertEquals(true, verifyFlag);
    }

}
