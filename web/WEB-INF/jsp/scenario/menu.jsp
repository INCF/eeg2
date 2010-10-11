<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth/" %>

<ul class="commonButtonMenu">
  <li><a href="<c:url value='/scenarios/list.html'/>"><fmt:message key="menuItem.listOfScenarios"/></a></li>
  <li><a href="<c:url value='/scenarios/my-scenarios.html'/>"><fmt:message key="menuItem.myScenarios"/></a></li>
</ul>

<ul class="commonButtonMenu">
  <li><a href="<c:url value='/scenario/search.html'/>"><fmt:message key="menuItem.searchScenario"/></a></li>
</ul>

<auth:experimenter>
  <ul class="commonButtonMenu">
    <li><a href="<c:url value='/scenarios/add-scenario.html'/>"><fmt:message key="menuItem.addScenario"/></a></li>
  </ul>
</auth:experimenter>