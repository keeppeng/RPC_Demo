package com.keeppeng.demo;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器
 */
public class Registry {
    public static ConcurrentHashMap<String,Class> map = new ConcurrentHashMap<>();
}
