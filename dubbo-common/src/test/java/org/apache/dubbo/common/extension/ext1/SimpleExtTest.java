package org.apache.dubbo.common.extension.ext1;/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * 描述作用
 *
 * @author lingfeng.xu
 * @date 2020/3/29
 */
public class SimpleExtTest {
    public static void main(String[] args) {
        ExtensionLoader<SimpleExt> loader = ExtensionLoader.getExtensionLoader(SimpleExt.class);
        SimpleExt impl = loader.getAdaptiveExtension();
        System.out.println(impl.echo(URL.valueOf("222"), "666"));
        System.out.println(impl.yell(URL.valueOf("dubbo://sss?key1=impl2"), "666"));
    }
}
