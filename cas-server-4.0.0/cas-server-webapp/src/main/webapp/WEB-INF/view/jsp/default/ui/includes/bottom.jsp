<%--

    Licensed to Jasig under one or more contributor license
    agreements. See the NOTICE file distributed with this work
    for additional information regarding copyright ownership.
    Jasig licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file
    except in compliance with the License.  You may obtain a
    copy of the License at the following location:

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.

--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page session="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

      </div> <!-- END #content -->
      
    <!--  <footer>
        <div id="copyright">
          <p><spring:message code="copyright" /></p>
          <p>Powered by <a href="http://www.jasig.org/cas">Jasig Central Authentication Service <%=org.jasig.cas.CasVersion.getVersion()%></a></p>
        </div>
      </footer> -->
	<div id="footer" class="fl-panel fl-note fl-bevel-white fl-font-size-80">
        <a id="jasig" href="http://www.jasig.org" title="go to Jasig home page"></a>
            <div id="copyright">
                <p>Copyright © 2016 - 2017 tgb, CHN. All rights reserved.</p>
                <!-- <p>Powered by <a href="">廊坊师范学院 信息技术提高班 第11期 ITOO_5.0</a></p>  -->
				<p>Powered by <a href="http://baike.baidu.com/link?url=UrN74H--uY4bXP6RmAk9lk3TAiyVG-FKjGemwU-zfkmeyBzbmTwp-9pF6qZUBTVD8OvSCQ2_pIEkbelXxCGE-_">廊坊师范学院 信息技术提高班 第11期 ITOO_5.0</a></p>
            </div>
    </div>

    </div> <!-- END #container -->
    
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
    
    <%-- 
        JavaScript Debug: A simple wrapper for console.log 
        See this link for more info: http://benalman.com/projects/javascript-debug-console-log/
    --%>
    <script type="text/javascript" src="https://github.com/cowboy/javascript-debug/raw/master/ba-debug.min.js"></script>
    
    <spring:theme code="cas.javascript.file" var="casJavascriptFile" text="" />
    <script type="text/javascript" src="<c:url value="${casJavascriptFile}" />"></script>
  </body>
</html>

