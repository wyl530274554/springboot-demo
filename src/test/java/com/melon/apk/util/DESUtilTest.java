package com.melon.apk.util;

import org.junit.jupiter.api.Test;

class DESUtilTest {

    @Test
    void encrypt() {
        String encrypt = DESUtil.encrypt("密码是一种用来混淆的技术，它希望将正常的（可识别的）信息转变为无法识别的信息");
        System.out.println("encrypt: " + encrypt);
        String decrypt = DESUtil.decrypt(encrypt);
        System.out.println("decrypt: " + decrypt);
    }

    @Test
    void decrypt() {
    }
}