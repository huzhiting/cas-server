/*
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.cas.web.flow;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jasig.cas.authentication.principal.Service;
import org.jasig.cas.util.Items;
import org.jasig.cas.web.support.ArgumentExtractor;
import org.jasig.cas.web.support.CookieRetrievingCookieGenerator;
import org.jasig.cas.web.support.WebUtils;
import org.springframework.util.StringUtils;
import org.springframework.webflow.action.AbstractAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

/**
 * Class to automatically set the paths for the CookieGenerators.
 * <p>
 * Note: This is technically not threadsafe, but because its overriding with a
 * constant value it doesn't matter.
 * <p>
 * Note: As of CAS 3.1, this is a required class that retrieves and exposes the
 * values in the two cookies for subclasses to use.
 *
 * @author Scott Battaglia
 * @since 3.1
 */
public final class InitialFlowSetupAction extends AbstractAction {

    /** CookieGenerator for the Warnings. */
    @NotNull
    private CookieRetrievingCookieGenerator warnCookieGenerator;

    /** CookieGenerator for the TicketGrantingTickets. */
    @NotNull
    private CookieRetrievingCookieGenerator ticketGrantingTicketCookieGenerator;

    /** Extractors for finding the service. */
    @NotNull
    @Size(min=1)
    private List<ArgumentExtractor> argumentExtractors;

    /** Boolean to note whether we've set the values on the generators or not. */
    private boolean pathPopulated = false;

    @Override
    protected Event doExecute(final RequestContext context) throws Exception {
        final HttpServletRequest request = WebUtils.getHttpServletRequest(context);
        if (!this.pathPopulated) {
            final String contextPath = context.getExternalContext().getContextPath();
            final String cookiePath = StringUtils.hasText(contextPath) ? contextPath + "/" : "/";
            logger.info("Setting path for cookies to: "
                + cookiePath);
            this.warnCookieGenerator.setCookiePath(cookiePath);
            this.ticketGrantingTicketCookieGenerator.setCookiePath(cookiePath);
            this.pathPopulated = true;
        }

        context.getFlowScope().put(
            "ticketGrantingTicketId", this.ticketGrantingTicketCookieGenerator.retrieveCookieValue(request));
        context.getFlowScope().put(
            "warnCookieValue",
            Boolean.valueOf(this.warnCookieGenerator.retrieveCookieValue(request)));

        final Service service = WebUtils.getService(this.argumentExtractors,
            context);

        if (service != null && logger.isDebugEnabled()) {
            logger.debug("Placing service in FlowScope: " + service.getId());
        }

        context.getFlowScope().put("service", service);
        
        return result("success");
    }

    public void setTicketGrantingTicketCookieGenerator(
        final CookieRetrievingCookieGenerator ticketGrantingTicketCookieGenerator) {
        this.ticketGrantingTicketCookieGenerator = ticketGrantingTicketCookieGenerator;
    }

    public void setWarnCookieGenerator(final CookieRetrievingCookieGenerator warnCookieGenerator) {
        this.warnCookieGenerator = warnCookieGenerator;
    }

    public void setArgumentExtractors(
        final List<ArgumentExtractor> argumentExtractors) {
        this.argumentExtractors = argumentExtractors;
    }
    
    public String queryAllCompany(RequestContext context){
//		List companyList=this.queryAllCompanyService.queryAllCompany();
//		JSONUtil jsonutil=new JSONUtil();
//		if(companyList!=null && !companyList.isEmpty()){	
//			return jsonutil.toJSONString(companyList);
//		}else{
//			return "";
//		}	
		//调用service查找 数据库，查询商品列表，这里使用静态数据模拟
		List<Items> itemsList = new ArrayList<Items>();
		//向list中填充静态数据

		Items items_1 = new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");

		itemsList.add(items_1);
		itemsList.add(items_2);
		
		context.getFlashScope().put("itemsList", itemsList);
		return "success";
    }

}
