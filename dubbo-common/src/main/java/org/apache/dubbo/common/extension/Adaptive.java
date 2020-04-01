/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.common.extension;

import org.apache.dubbo.common.URL;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Provide helpful information for {@link ExtensionLoader} to inject dependency extension instance.
 *
 * @see ExtensionLoader
 * @see URL
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Adaptive {
    /**
     * 确定要注入的目标扩展。目标扩展名由传递的参数决定URL中的参数，参数名称由该方法指定。
     *      如果在{@link URL}中找不到指定的参数，则默认扩展名将用于
     *      依赖项注入（在其接口的{@link SPI}中指定）。
     *      例如，给定<code> String [] {“ key1”，“ key2”} </ code>：
     *       <li>在URL中查找参数'key1'，将其值用作扩展名</ li>
     *       <li>如果在URL中找不到“ key1”（或其值为空），请尝试使用“ key2”作为扩展名。</ li>
     *       <li>如果'key2'也不存在，请使用默认扩展名</ li>
     *       <li>否则，抛出{@link IllegalStateException} </ li>
     *      如果参数名称为空，则从接口的类名的规则：将类名与大写字母分成几部分，并用
     *     点“。”，例如，对于{@code org.apache.dubbo.xxx.YyyInvokerWrapper}，
     * 生成的名称为yyy.invoker.wrapper
     */
    String[] value() default {};
}