<%--
  Created by IntelliJ IDEA.
  User: ssvh
  Date: 7/24/16
  Time: 5:13 PM
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

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
            <script type="text/javascript">
                $(function() {

                    // Start indexing at the size of the current list
                    var index = ${fn:length(employer.employees)};

                    // Add a new Employee
                    $("#add").off("click").on("click", function() {
                        $(this).before(function() {
                            var html = '<div id="employees' + index + '.wrapper" class="hidden">';
                            html += '<input type="text" id="employees' + index + '.firstname" name="employees[' + index + '].firstname" />';
                            html += '<input type="text" id="employees' + index + '.lastname" name="employees[' + index + '].lastname" />';
                            html += '<input type="hidden" id="employees' + index + '.remove" name="employees[' + index + '].remove" value="0" />';
                            html += '<a href="#" class="employees.remove" data-index="' + index + '">remove</a>';
                            html += "</div>";
                            return html;
                        });
                        $("#employees" + index + "\\.wrapper").show();
                        index++;
                        return false;
                    });

                    // Remove an Employee
                    $("a.employees\\.remove").on("click", function() {
                        var index2remove = $(this).data("index");
                        $("#employees" + index2remove + "\\.wrapper").hide();
                        $("#employees" + index2remove + "\\.remove").val("1");
                        return false;
                    });

                });
            </script>
        </head>
<body>
<h1>
    Add  Loan
</h1>
<c:url var="addAction" value="/payment/add" ></c:url>

<form:form action="${addAction}" commandName="payment">
    <table>
        <c:if test="${!empty id} && ${id!=0}">
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
            <td> <form:label path="loan.id">
                <spring:message text="Loan"/>
            </form:label></td>
            <td>
                <form:input path="loan.id" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="interest">
                    <spring:message text="interest"/>
                </form:label>
            </td>
            <td>
                <form:input path="interest" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="capital">
                    <spring:message text="capital"/>
                </form:label>
            </td>
            <td>
                <form:input path="capital" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="fee">
                    <spring:message text="fee"/>
                </form:label>
            </td>
            <td>
                <form:input path="fee" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="date">
                    <spring:message text="date"/>
                </form:label>
            </td>
            <td>
                <form:input path="date" />
            </td>
        </tr>
        <tr>
            <td>Employees</td>
            <td>
                <c:forEach items="${employer.employees}" varStatus="loop">
                <!-- Add a wrapping div -->
                <c:choose>
                <c:when test="${employer.employees[loop.index].remove eq 1}">
                <div id="employees${loop.index}.wrapper" class="hidden">
                    </c:when>
                    <c:otherwise>
                    <div id="employees${loop.index}.wrapper">
                        </c:otherwise>
                        </c:choose>
                        <!-- Generate the fields -->
                        <form:input path="employees[${loop.index}].firstname" />
                        <form:input path="employees[${loop.index}].lastname" />
                        <!-- Add the remove flag -->
                        <c:choose>
                            <c:when test="${employees[loop.index].remove eq 1}"><c:set var="hiddenValue" value="1" /></c:when>
                            <c:otherwise><c:set var="hiddenValue" value="0" /></c:otherwise>
                        </c:choose>
                        <form:hidden path="employees[${loop.index}].remove" value="${hiddenValue}" />
                        <!-- Add a link to remove the Employee -->
                        <a href="#" class="employees.remove" data-index="${loop.index}">remove</a>
                    </div>
                    </c:forEach>
                    <button id="add" type="button">add</button>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${id>0}">
                    <input type="submit"
                           value="<spring:message text="Edit Loan"/>" />
                </c:if>
                    <%--<c:if test="${id==0}">--%>
                <input type="submit"
                       value="<spring:message text="Add Loan"/>" />
                    <%--</c:if>--%>
            </td>
        </tr>
    </table>

    

</form:form>
<br>
<h3>Loan List</h3>
<c:if test="${!empty listTransferDetail}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
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

