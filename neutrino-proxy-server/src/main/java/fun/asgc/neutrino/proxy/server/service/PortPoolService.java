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
package fun.asgc.neutrino.proxy.server.service;

import fun.asgc.neutrino.core.annotation.Autowired;
import fun.asgc.neutrino.core.annotation.Component;
import fun.asgc.neutrino.core.db.page.Page;
import fun.asgc.neutrino.core.db.page.PageQuery;
import fun.asgc.neutrino.proxy.server.base.rest.constant.EnableStatusEnum;
import fun.asgc.neutrino.proxy.server.controller.req.PortPoolCreateReq;
import fun.asgc.neutrino.proxy.server.controller.req.PortPoolListReq;
import fun.asgc.neutrino.proxy.server.controller.req.PortPoolUpdateEnableStatusReq;
import fun.asgc.neutrino.proxy.server.controller.res.LicenseListRes;
import fun.asgc.neutrino.proxy.server.controller.res.PortPoolCreateRes;
import fun.asgc.neutrino.proxy.server.controller.res.PortPoolListRes;
import fun.asgc.neutrino.proxy.server.controller.res.PortPoolUpdateEnableStatusRes;
import fun.asgc.neutrino.proxy.server.dal.PortPoolMapper;
import fun.asgc.neutrino.proxy.server.dal.entity.PortPoolDO;

import java.util.Date;

/**
 *
 * @author: aoshiguchen
 * @date: 2022/8/7
 */
@Component
public class PortPoolService {

	@Autowired
	private PortPoolMapper portPoolMapper;

	public Page<PortPoolListRes> page(PageQuery pageQuery, PortPoolListReq req) {
		Page<PortPoolListRes> page = Page.create(pageQuery);
		portPoolMapper.page(page, req);
		return page;
	}

	public PortPoolCreateRes create(PortPoolCreateReq req) {
		Date now = new Date();

		portPoolMapper.add(new PortPoolDO()
			.setPort(req.getPort())
			.setEnable(EnableStatusEnum.ENABLE.getStatus())
			.setCreateTime(now)
			.setUpdateTime(now)
		);

		return new PortPoolCreateRes();
	}

	public PortPoolUpdateEnableStatusRes updateEnableStatus(PortPoolUpdateEnableStatusReq req) {

		portPoolMapper.updateEnableStatus(req.getId(), req.getEnable());

		return new PortPoolUpdateEnableStatusRes();
	}

	public void delete(Integer id) {
		portPoolMapper.delete(id);
	}

}