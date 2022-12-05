/**
 * Copyright (c) 2022 aoshiguchen
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package fun.asgc.neutrino.proxy.server.base.rest.config;

import fun.asgc.neutrino.core.annotation.Configuration;
import fun.asgc.neutrino.core.annotation.NonIntercept;
import fun.asgc.neutrino.core.annotation.Value;
import fun.asgc.neutrino.proxy.server.constant.DbTypeEnum;
import lombok.Data;

/**
 * sqlite数据库配置
 * @author: aoshiguchen
 * @date: 2022/7/31
 */
@Data
@NonIntercept
@Configuration(prefix = "neutrino.data.db")
public class DbConfig {
	/**
	 * 数据库类型
	 * {@link DbTypeEnum}
	 */
	@Value("type")
	private String type;
	/**
	 * 连接url
	 */
	@Value("url")
	private String url;
	/**
	 * 驱动类
	 */
	@Value("driver-class")
	private String driverClass;

	/**
	 * 用户名
	 */
	@Value("username")
	private String username;

	/**
	 * 密码
	 */
	@Value("password")
	private String password;
}
