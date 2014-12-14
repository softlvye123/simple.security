package org.simple.security.api.test;

import org.apache.commons.codec.binary.Base64;

public interface Constants {
    String source = "asdfafdsadfasdf"; // 被加密数据
    String charset = "UTF-8";

    String secretyKey = "12345677899safadgahghsfdgh";
    byte[] secretyKeyBytes = secretyKey.getBytes();

    String rsaPrivateKey = "MIICXQIBAAKBgQCmpIVZxolaMuPQwsgFCZhLBEzK0+S/TysP8fuOqWl7mo4KmN7ovcnP8jHAFZhEDJvHhiKKsoWPdK1Mweo8jny8dWPFWYmuVOaUMeKEn5mwNj1xpzHsptFAJJ71IOzXczraXLtHmsfJcnYfCjoDrn9WCp1kDqrg/AYuzBflKNVHSwIDAQABAoGAUiXaQuZXQWrC2V+b4LfZJmnpPTd1lUV+se6VFr+26yLGkLzJbixY9zSqh8lddXZNuO8Lyhm1M4HOCH+za8TGAgmkTSTKZ9X716soLS5taJjsqUZIPEP8osOTkDZKN+FveduwqkoRH1bTGCzqwe3lzHmx0hSyRv51KXI6iP+4rcECQQDSWtE2aEYtpxbn47egilVdV0Z6huqgQo2YOnvhyFrwuxWjNQcqMFGdg6ixnr9sApzgCEUJajryf6xYd9ytSqjrAkEAys2AckddnIBt3nXQ9iIGCMYTMGVqSZ5rrLY4FLznGxqsCELHeXaYoS0jrNbE3l6wP3nG/SrQAzuInQk22ABDIQJAbEXsq+mOPc9kfeV7TfoGKG5Uy5qISAcZpMJto3CiRoi1gXU5A+EtETuEaDCC7RCHONVo24i/YLSQvFSt1NC6EwJBALgXJvuVcJI5uoHvbImghN29/3k09fBxz8fteKbKevaNlY/CHpRRZWcZNIMWSYqZZV+ZSVpSXJQynGYAETqtskECQQC1tA8ID33Oi+r7LtLo5IKHECeIAi1vCMaVnTbXmV/yX8K1BjM92eMS0SJS2jYYTHtklF3iQSRTjaTz5jMnOerD";
    String rsaPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCmpIVZxolaMuPQwsgFCZhLBEzK0+S/TysP8fuOqWl7mo4KmN7ovcnP8jHAFZhEDJvHhiKKsoWPdK1Mweo8jny8dWPFWYmuVOaUMeKEn5mwNj1xpzHsptFAJJ71IOzXczraXLtHmsfJcnYfCjoDrn9WCp1kDqrg/AYuzBflKNVHSwIDAQAB";

    byte[] rsaPrivateKeyBytes = Base64.decodeBase64(rsaPrivateKey);
    byte[] rsaPublicKeyBytes = Base64.decodeBase64(rsaPublicKey);
}
