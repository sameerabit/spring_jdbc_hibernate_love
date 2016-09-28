<%--
  Created by IntelliJ IDEA.
  User: ssvh
  Date: 3/4/16
  Time: 11:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ page session="false" %>
        <html>
        <head>
            <title>Turn</title>
            <style type="text/css">
                .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
                .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color: #ff3331;}
                .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
                .tg .tg-4eph{background-color:#f9f9f9}
            </style>
        </head>
<body>
<h1>
    Add Turn
</h1>

<c:url var="addAction" value="/turn/add" ></c:url>

<form:form action="${addAction}" commandName="turn">
    <table>
        <c:if test="${turn.id>0}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="id" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td> <form:label path="fieldOfficer">
                <spring:message text="FieldOfficer"/>
            </form:label></td>
            <td>
                <form:select path="fieldOfficer.id">
                    <form:option value="0" label="-----Select------" />
                    <form:options items="${listFieldOfficer}" itemValue="id" itemLabel="name" />
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="startTime">
                    <spring:message text="startTime"/>
                </form:label>
            </td>
            <td>
                <%--<fmt:formatDate value="${startTime}" var="dateString" pattern="yyyy-MM-dd H:m:s" />--%>
                <%--<form:input path="startTime" value="${dateString}" />--%>
                    <input type="datetime" name="startTime">
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="offTime">
                    <spring:message text="offTime"/>
                </form:label>
            </td>
            <td>
                <form:input path="offTime" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${turn.id>0}">
                    <input type="submit"
                           value="<spring:message text="Edit Turn"/>" />
                </c:if>
                <c:if test="${turn.id==0}">
                    <input type="submit"
                           value="<spring:message text="Add Turn"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Turn List</h3>
<c:if test="${!empty listTurn}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Field Officer</th>
            <th width="120">Start Time</th>
            <th width="120">Off Time</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listTurn}" var="turn">
            <tr>
                <td>${turn.id}</td>
                <td>${turn.fieldOfficer.name}</td>
                <td>${turn.startTime}</td>
                <td>${turn.offTime}</td>
                <td><a href="<c:url value='/turn/edit/${turn.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/turn/remove/${turn.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
</title>
</head>
<body>

</body>
</html>
