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
            <title>Loan</title>
            <style type="text/css">
                .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
                .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color: #ff3331;}
                .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
                .tg .tg-4eph{background-color:#f9f9f9}
            </style>
        </head>
<body>
<h1>
    Add  Loan
</h1>
<c:url var="addAction" value="/loan/add" ></c:url>

<form:form action="${addAction}" commandName="transferDetail">
    <table>
        <c:if test="${!empty loan.id} && ${loan.id!=0}">
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
            <td> <form:label path="loan">
                <spring:message text="Customer"/>
            </form:label></td>
            <td>
                <form:select path="loan.customer.id">
                    <form:option value="0" label="-----Select------" />
                    <form:options items="${listCustomer}" itemValue="id" itemLabel="name" />
                </form:select>
            </td>
        </tr>
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
                <form:label path="loan.number">
                    <spring:message text="Number"/>
                </form:label>
            </td>
            <td>
                <form:input path="loan.number" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="loan.date">
                    <spring:message text="Date"/>
                </form:label>
            </td>
            <td>
                <form:input path="loan.date" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="loan.capital">
                    <spring:message text="Capital"/>
                </form:label>
            </td>
            <td>
                <form:input path="loan.capital" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="loan.interest">
                    <spring:message text="Interest"/>
                </form:label>
            </td>
            <td>
                <form:input path="loan.interest" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="loan.total">
                    <spring:message text="Total"/>
                </form:label>
            </td>
            <td>
                <form:input path="loan.total" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${loan.id>0}">
                    <input type="submit"
                           value="<spring:message text="Edit Loan"/>" />
                </c:if>
                <c:if test="${loan.id==0}">
                    <input type="submit"
                           value="<spring:message text="Add Loan"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Loan List</h3>
<c:if test="${!empty listLoan}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Number</th>
            <th width="120">Date</th>
            <th width="120">Capital</th>
            <th width="120">Interest</th>
            <th width="120">Total</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listLoan}" var="loan">
            <tr>
                <td>${loan.id}</td>
                <td>${loan.number}</td>
                <td>${loan.date}</td>
                <td>${loan.capital}</td>
                <td>${loan.interest}</td>
                <td>${loan.total}</td>
                <td><a href="<c:url value='/loan/edit/${loan.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/loan/remove/${loan.id}' />" >Delete</a></td>
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
