package com.melon.apk.util;

import org.junit.jupiter.api.Test;

class DESUtilTest {
    @Test
    void encrypt() {
        String encrypt = DESUtil.encrypt("所以针对保密级别特别高的数据推荐使用非对称加密算法。");
        System.out.println("encrypt: " + encrypt);
        String decrypt = DESUtil.decrypt(encrypt);
        System.out.println("decrypt: " + decrypt);
    }

    @Test
    void decrypt() {
    }
}