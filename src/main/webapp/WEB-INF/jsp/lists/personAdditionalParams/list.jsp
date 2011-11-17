<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/" %>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth/" %>

<ui:listsTemplate pageTitle="pageTitle.personOptionalParameterList">
    <h1><fmt:message key="pageTitle.personOptionalParameterList"/></h1>

    <table class="dataTable">
        <thead>
        <tr>
            <th style="width: 50px;"><fmt:message key="dataTable.heading.id"/></th>
            <th style="width: 150px;"><fmt:message key="dataTable.heading.personAdditionalParamsName"/></th>
            <th><fmt:message key="dataTable.heading.personAdditionalParamsDataType"/></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${personAdditionalParamsList}" var="personAdditionalParam">
            <tr>
                <td><c:out value="${personAdditionalParam.personOptParamDefId}" /></td>
                <td><c:out value="${personAdditionalParam.paramName}" /></td>
                <td><c:out value="${personAdditionalParam.paramDataType}" /></td>
                <td>
                    <a href="<c:url value='/lists/person-optional-parameters/edit.html?id=${personAdditionalParam.personOptParamDefId}' />"><fmt:message
                            key="link.edit"/></a>
                    <auth:experimenter>
                        <a href="<c:url value='/lists/person-optional-parameters/delete.html?id=${personAdditionalParam.personOptParamDefId}' />"
                           onclick="return confirm('Are you sure you want to delete item?');"><fmt:message
                                key="link.delete"/></a>
                    </auth:experimenter>
                </td>
            </tr>
        </c:forEach>
    </table>

    <auth:experimenter>
        <div class="actionBox">
            <a href="<c:url value='add.html'/>" class="lightButtonLink"><fmt:message
                    key="link.addPersonOptionalParameter"/></a>
        </div>
    </auth:experimenter>

</ui:listsTemplate>