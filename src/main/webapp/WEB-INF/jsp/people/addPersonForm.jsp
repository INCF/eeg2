<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/" %>
<ui:personsTemplate pageTitle="pageTitle.addEditPerson" dateOfBirthCalendar="true">
    <c:choose>
        <c:when test="${addPerson.id > 0}">
            <!-- editation -->
            <h1><fmt:message key="pageTitle.editPerson"/></h1>

            <c:url value="/people/edit.html?id=${addPerson.id}" var="formUrl"/>
        </c:when>
        <c:otherwise>
            <!-- creating new -->
            <h1><fmt:message key="pageTitle.addPerson"/></h1>

            <c:url value="add-person.html" var="formUrl"/>
        </c:otherwise>
    </c:choose>

    <form:form action="${formUrl}" method="post" commandName="addPerson" cssClass="standardInputForm">
        <fieldset>

            <div class="itemBox">
                <form:label path="givenname" cssClass="textFieldLabel"
                            cssErrorClass="textFieldLabel errorLabel"><fmt:message key="label.name"/></form:label>

                <form:input path="givenname" cssClass="textField" cssErrorClass="textField errorField"/>

                <form:errors path="givenname" cssClass="errorBox"/>
            </div>

            <div class="itemBox">
                <form:label path="surname" cssClass="textFieldLabel"
                            cssErrorClass="textFieldLabel errorLabel"><fmt:message key="label.surname"/></form:label>

                <form:input path="surname" cssClass="textField" cssErrorClass="textField errorField"/>

                <form:errors path="surname" cssClass="errorBox"/>
            </div>

            <div class="itemBox">
                <form:label path="dateOfBirth" cssClass="textFieldLabel"
                            cssErrorClass="textFieldLabel errorLabel"><fmt:message
                        key="label.dateOfBirth"/></form:label>

                <form:input path="dateOfBirth" cssClass="textField dateField"
                            cssErrorClass="textField dateField errorField"/>
                <span class="note"><fmt:message key="form.note.dateFormatDDMMYYYY"/></span>

                <form:errors path="dateOfBirth" cssClass="errorBox"/>
            </div>

            <div class="itemBox">
                <form:label path="gender" cssClass="radio2ButtonsLabel"
                            cssErrorClass="radio2ButtonsLabel errorLabel"><fmt:message key="label.gender"/></form:label>

                <form:radiobutton path="gender" value="M"/> <form:label path="gender" for="gender1"><fmt:message
                    key="label.gender.male"/></form:label>
                <form:radiobutton path="gender" value="F"/> <form:label path="gender" for="gender2"><fmt:message
                    key="label.gender.female"/></form:label>

                <form:errors path="gender" cssClass="errorBox"/>
            </div>

            <div class="itemBox">
                <form:label path="email" cssClass="textFieldLabel"
                            cssErrorClass="textFieldLabel errorLabel"><fmt:message key="label.emailLogin"/></form:label>

                <form:input path="email" cssClass="textField" cssErrorClass="textField errorField"/>

                <form:errors path="email" cssClass="errorBox"/>
            </div>

            <div class="itemBox">
                <form:label path="phoneNumber" cssClass="textFieldLabel"
                            cssErrorClass="textFieldLabel errorLabel"><fmt:message
                        key="label.phoneNumber"/></form:label>

                <form:input path="phoneNumber" cssClass="textField" cssErrorClass="textField errorField"/>

                <form:errors path="phoneNumber" cssClass="errorBox"/>
            </div>

            <div class="itemBox">
                <form:label path="note" cssClass="textareaFieldLabel"
                            cssErrorClass="textareaFieldLabel errorLabel"><fmt:message key="label.note"/></form:label>

                <form:textarea path="note" cssClass="textareaField" cssErrorClass="textareaField errorField"/>

                <form:errors path="note" cssClass="errorBox"/>
            </div>

            <div class="itemBox">
                <form:label path="laterality" cssClass="textFieldLabel"
                            cssErrorClass="textFieldLabel errorLabel"><fmt:message key="label.laterality"/></form:label>
                <form:select path="laterality" id="selectLaterality" cssClass="selectBox">
                    <option value="L"><fmt:message key="label.left"/></option>
                    <option value="R"><fmt:message key="label.right"/></option>
                    <option value="X"><fmt:message key="label.unspecified"/></option>
                </form:select>
            </div>
            <div class="itemBox">
                <form:label path="educationLevel" cssClass="textFieldLabel"
                            cssErrorClass="textFieldLabel errorLabel"><fmt:message
                        key="label.educationLevel"/></form:label>
                <form:select path="educationLevel" id="selectEducationLevel" cssClass="selectBox">
                    <c:forEach items="${education}" var="educationLevel">
                        <form:option value="${educationLevel.educationLevelId}" label="${educationLevel.title}"/>
                    </c:forEach>
                </form:select>
            </div>

            <div class="itemBox">
                <input type="submit" value="<fmt:message key="button.save"/>" class="submitButton lightButtonLink"/>
            </div>
        </fieldset>
    </form:form>
</ui:personsTemplate>
