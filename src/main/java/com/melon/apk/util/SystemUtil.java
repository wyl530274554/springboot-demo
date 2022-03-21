package com.melon.apk.util;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

/**
 * @author luckhwb
 */
public class SystemUtil {

    private static OperatingSystemMXBean operatingSystemMXBean;

    static {
        operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    }

    /**
     * 获取cpu使用率
     *
     * @return 小数如0.19xxx，代表19%
     */
    public static double getSystemCpuLoad() {
        return operatingSystemMXBean.getSystemCpuLoad();
    }

    /**
     * 获取内存使用率
     *
     * @return 小数如0.19xxx，代表19%
     */
    public static int getMemoryLoad() {
        long totalPhysicalMemorySize = operatingSystemMXBean.getTotalPhysicalMemorySize();
        long freePhysicalMemorySize = operatingSystemMXBean.getFreePhysicalMemorySize();
        return (int) ((double) (totalPhysicalMemorySize - freePhysicalMemorySize) / totalPhysicalMemorySize * 100);
    }

    /**
     * 获取cpu数量
     *
     * @return 数量
     */
    public static int getSystemCpuCount() {
        return Runtime.getRuntime().availableProcessors();
    }
}

