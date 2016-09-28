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
        <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ page session="false" %>
        <html>
        <head>
            <title>Expense</title>
            <style type="text/css">
                .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
                .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color: #ff3331;}
                .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
                .tg .tg-4eph{background-color:#f9f9f9}
            </style>
        </head>
<body>
<h1>
    Add  Expense
</h1>

<c:url var="addAction" value="/expense/add" ></c:url>

<form:form action="${addAction}" commandName="expense">
    <table>
        <c:if test="${expense.id>0}">
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
            <td> <form:label path="branch">
                <spring:message text="Branch"/>
            </form:label></td>
            <td>
                <form:select path="branch.id">
                    <form:option value="0" label="-----Select------" />
                    <form:options items="${listBranch}" itemValue="id" itemLabel="name" />
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="reason">
                    <spring:message text="reason"/>
                </form:label>
            </td>
            <td>
                <form:input path="reason" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="amount">
                    <spring:message text="amount"/>
                </form:label>
            </td>
            <td>
                <form:input path="amount" />
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <c:if test="${expense.id>0}">
                    <input type="submit"
                           value="<spring:message text="Edit Expense"/>" />
                </c:if>
                <c:if test="${expense.id==0}">
                    <input type="submit"
                           value="<spring:message text="Add Expense"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Expense List</h3>
<c:if test="${!empty listExpense}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Branch</th>
            <th width="120">Reason</th>
            <th width="120">Amount</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listExpense}" var="expense">
            <tr>
                <td>${expense.id}</td>
                <td>${expense.branch.name}</td>
                <td>${expense.reason}</td>
                <td>${expense.amount}</td>
                <td><a href="<c:url value='/expense/edit/${expense.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/expense/remove/${expense.id}' />" >Delete</a></td>
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
