<%--
  Created by IntelliJ IDEA.
  User: ssvh
  Date: 9/28/16
  Time: 5:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
        <%@ page session="false" %>
        <html>
        <head>
            <title>Payment</title>
            <style type="text/css">
                .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
                .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color: #ff3331;}
                .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
                .tg .tg-4eph{background-color:#f9f9f9}
            </style>
   </head>
<body>
<h1>
    Add  Payment
</h1>
<br>
<h3>Payment List</h3>
<c:if test="${!empty listInstallPayments}">
    <table class="tg">
        <tr>
            <th width="80">Loan No</th>
            <th width="80">Interest</th>
            <th width="120">Capital</th>
            <th width="120">Fee</th>
            <th width="120">Date</th>
            <th width="120">Status</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listInstallPayments}" var="payment">
            <tr>
                <td>${payment.loan.id}</td>
                <td>${payment.interest}</td>
                <td>${payment.capital}</td>
                <td>${payment.fee}</td>
                <td>${payment.date}</td>
                <td>${payment.status}</td>
                <td><a href="<c:url value='/payment/edit/${payment.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/payment/remove/${payment.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    </c:if>
</body>
</html>
</title>
</head>
</html>


