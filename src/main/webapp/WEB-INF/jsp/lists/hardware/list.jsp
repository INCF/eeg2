<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/" %>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth/" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<ui:listsTemplate pageTitle="pageTitle.hardwareList">
    <h1><fmt:message key="pageTitle.hardwareList"/></h1>

    <form:form method="post" commandName="selectGroupCommand" cssClass="standardInputForm"
               name="selectGroupCommand" action="${next}" >
        <form:label path="researchGroupId" cssClass="selectBoxLabel" cssErrorClass="selectBoxLabel errorLabel"><fmt:message key="label.researchGroup"/></form:label>

        <form:select path="researchGroupId" cssClass="selectBox" onChange="this.form.submit()">
                        <c:forEach items="${researchGroupList}" var="researchGroup">
                            <option value="${researchGroup.researchGroupId}" label="" <c:if test="${selectGroupCommand.researchGroupId==researchGroup.researchGroupId}"><c:out value="selected=\"selected\""/></c:if>>
                                <c:out value="${researchGroup.title}"/>
                            </option>
                        </c:forEach>
                    </form:select>

                    <form:errors path="researchGroupId" cssClass="errorBox"/>
    </form:form>


    <table class="dataTable">
        <thead>
        <tr>
            <th style="width: 50px;"><fmt:message key="dataTable.heading.id"/></th>
            <th style="width: 150px;"><fmt:message key="dataTable.heading.title"/></th>
            <th style="width: 150px;"><fmt:message key="dataTable.heading.type"/></th>
            <th><fmt:message key="dataTable.heading.description"/></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${hardwareList}" var="hardware">
            <tr>
                <td><c:out value="${hardware.hardwareId}" /></td>
                <td><c:out value="${hardware.title}" /></td>
                <td><c:out value="${hardware.type}" /></td>
                <td><c:out value="${hardware.description}" /></td>
                <td>
                    <a href="<c:url value='/lists/hardware-definitions/edit.html?id=${hardware.hardwareId}&groupid=${selectGroupCommand.researchGroupId}' />"><fmt:message
                            key="link.edit"/></a>
                    <auth:experimenter>
                        <a href="<c:url value='/lists/hardware-definitions/delete.html?id=${hardware.hardwareId}&groupid=${selectGroupCommand.researchGroupId}' />"
                           onclick="return confirm('Are you sure you want to delete item?');"><fmt:message
                                key="link.delete"/></a>
                    </auth:experimenter>
                </td>
            </tr>
        </c:forEach>
    </table>

    <auth:experimenter>
        <div class="actionBox">
            <a href="<c:url value='add.html?groupid=${selectGroupCommand.researchGroupId}' />" class="lightButtonLink"><fmt:message
                    key="link.addHardwareDefinition"/></a>
        </div>
    </auth:experimenter>

</ui:listsTemplate>
