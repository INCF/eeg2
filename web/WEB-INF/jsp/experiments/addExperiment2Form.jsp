<%--
  Created by IntelliJ IDEA.
  User: pbruha
  Date: 10.3.11
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/" %>
<ui:experimentsTemplate pageTitle="pageTitle.addEditExperiment" addExperimentCalendar="true">

    <h1><fmt:message key="pageTitle.addExperiment"/></h1>

    <form:form method="post" commandName="addExperimentWizard" cssClass="standardInputForm" name="addExperimentWizard"
               enctype="multipart/form-data">
        <input type="hidden" name="param"/>
        <fieldset>
            <div class="itemBox">
                <form:label path="scenario" cssClass="selectBoxLabel"
                            cssErrorClass="selectBoxLabel errorLabel">
                    <fmt:message key="label.scenario"/>
                </form:label>

                <form:select path="scenario" cssClass="selectBox">
                    <form:option value="-1">
                        <fmt:message key="select.option.noScenarioSelected"/>
                    </form:option>
                    <c:forEach items="${scenarioList}" var="scenario">
                        <form:option value="${scenario.scenarioId}" label="${scenario.title}"></form:option>
                    </c:forEach>
                </form:select>


                <form:errors path="scenario" cssClass="errorBox"/>

                <div class="itemBox">
                    <form:label path="hardware" cssClass="multipleSelectBoxLabel"
                                cssErrorClass="multipleSelectBoxLabel errorLabel"><fmt:message
                            key="label.hardware"/></form:label>

                    <form:select path="hardware" multiple="multiple" id="selectHardware" cssClass="multipleSelectBox">
                        <c:forEach items="${hardwareList}" var="hardware">
                            <option value="${hardware.hardwareId}">${hardware.title}</option>
                        </c:forEach>
                    </form:select>
                    <input type="button" name="new_hardware" id="create-hardware"
                           value="<fmt:message key="button.addHardwareDefinition"/>">
                    <form:errors path="hardware" cssClass="errorBox"/>
                </div>

                <div class="itemBox">
                    <form:label path="weather" cssClass="selectBoxLabel"
                                cssErrorClass="selectBoxLabel errorLabel"><fmt:message
                            key="label.weather"/></form:label>

                    <form:select path="weather" id="selectWeather" multiple="false" cssClass="selectBox">
                        <option value="-1"><fmt:message key="select.option.noWeatherSelected"/></option>
                        <c:forEach items="${weatherList}" var="weather">
                            <option value="${weather.weatherId}">${weather.title}</option>
                        </c:forEach>
                    </form:select>
                    <input type="button" name="new_weather" id="create-weather"
                           value="<fmt:message key="button.addWeatherDefinition"/>">

                    <form:errors path="weather" cssClass="errorBox"/>
                </div>


                <div class="itemBox">
                    <form:label path="weatherNote" cssClass="textFieldLabel"
                                cssErrorClass="textFieldLabel errorLabel"><fmt:message
                            key="label.weatherNote"/></form:label>

                    <form:input path="weatherNote" cssClass="textField" cssErrorClass="textField errorField"/>

                    <form:errors path="weatherNote" cssClass="errorBox"/>
                </div>

                <div class="itemBox">
                    <form:label path="temperature" cssClass="textFieldLabel"
                                cssErrorClass="textFieldLabel errorLabel"><fmt:message
                            key="label.temperature"/></form:label>

                    <form:input path="temperature" cssClass="textField" cssErrorClass="textField errorField"/> °C

                    <form:errors path="temperature" cssClass="errorBox"/>
                </div>
                <div class="itemBox">

                    <form:label path="privateNote" cssClass="textFieldLabel"
                                cssErrorClass="textFieldLabel errorLabel"><fmt:message
                            key="label.private"/></form:label>

                    <form:checkbox path="privateNote" cssClass="checkBox"
                                   value="${addExperimentWizard.privateNote}"/>

                    <form:errors path="privateNote" cssClass="errorBox"/>
                </div>
            </div>


            <div class="actionBox">
                <input type="submit" value="Previous" name="_target0" class="submitButton lightButtonLink"/>
                <input type="submit" value="Next" name="_target2" class="lightButtonLink"/>
                <input type="submit" value="Cancel" name="_cancel" class="lightButtonLink"/>
            </div>


        </fieldset>
    </form:form>

    <div id="dialog-form-weather" title="Create new weather">
        <p class="validateTips">All form fields are required.</p>

        <form>
            <fieldset>
                <label for="weatherTitle"><fmt:message key="label.title"/></label>
                <input type="text" name="weatherTitle" id="weatherTitle" class="text ui-widget-content ui-corner-all"/>
                <label for="weatherDescription"><fmt:message key="label.description"/></label>
                <input type="text" name="weatherDescription" id="weatherDescription"
                       class="text ui-widget-content ui-corner-all"/>
            </fieldset>
        </form>
    </div>

    <div id="dialog-form-hardware" title="Create new hardware">
        <p class="validateTips">All form fields are required.</p>

        <form>
            <fieldset>
                <label for="hardwareTitle"><fmt:message key="label.hardwareTitle"/></label>
                <input type="text" name="hardwareTitle" id="hardwareTitle"
                       class="text ui-widget-content ui-corner-all"/>
                <label for="hardwareType"><fmt:message key="label.hardwareType"/></label>
                <input type="text" name="hardwareType" id="hardwareType" class="text ui-widget-content ui-corner-all"/>
                <label for="hardwareDescription"><fmt:message key="label.hardwareDescription"/></label>
                <input type="text" name="hardwareDescription" id="hardwareDescription"
                       class="text ui-widget-content ui-corner-all"/>
            </fieldset>
        </form>
    </div>
     <div id="dialog-form-scenario" title="Create new scenario">
        <p class="validateTips">All form fields are required.</p>

        <form>
            <fieldset>

                <label for="researchGroup"><fmt:message key="label.researchGroup"/></label>
                 <select name="researchGroup" id="researchGroup" class="text ui-widget-content ui-corner-all">
                    <option value="-1"><fmt:message key="select.option.noResearchGroupSelected"/></option>
                    <c:forEach items="${researchGroupList}" var="researchGroup">
                        <option value="${researchGroup.researchGroupId}" label="" <c:if
                                test="${researchGroup.researchGroupId == defaultGroupId}"> selected </c:if> >
                            <c:out value="${researchGroup.title}"/>
                        </option>
                    </c:forEach>
                </select>
                <label for="scenarioTitle"><fmt:message key="label.title"/></label>
                <input type="text" name="scenarioTitle" id="scenarioTitle" class="text ui-widget-content ui-corner-all"/>
                <label for="length"><fmt:message key="label.lenght"/></label>
                <input type="text" name="length" id="length" class="text ui-widget-content ui-corner-all"/>

                <label for="scenarioDescription"><fmt:message key="label.hardwareDescription"/></label>
                <textarea rows="3" cols="20" name="scenarioDescription" id="scenarioDescription" class="text ui-widget-content ui-corner-all"/>
                <label for="dataFile"><fmt:message key="label.dataFile"/></label>
                <input type="file" name="dataFile" id="dataFile" class="fileField"/>
                <label for="privateNote"><fmt:message key="label.private"/></label>
                <input type="checkbox" name="privateNote" value="private"  />
            </fieldset>
        </form>
    </div>
</ui:experimentsTemplate>