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
                    var index = ${fn:length(credit)};

                    // Add a new Employee
                    $("#add").off("click").on("click", function() {
                        $(this).before(function() {
                            var html = '<div id="credit' + index + '.wrapper" class="hidden">';
                            html += '<input type="text" id="credit' + index + '.number" name="credit[' + index + '].number" />';
                            html += '<input type="text" id="credit' + index + '.amount" name="credit[' + index + '].amount" />';
                            html += '<input type="hidden" id="credit' + index + '.remove" name="credit[' + index + '].remove" value="0" />';
                            html += '<a href="#" onclick="removeRow('+index+')" class="creditremove" data-index="' + index + '">remove</a>';
                            html += "</div>";
                            return html;
                        });
                        $("#credit" + index + "\\.wrapper").show();
                        index++;
                        return false;
                    });

                    //cheque
                    // Start indexing at the size of the current list
                    var chIndex = ${fn:length(cheque)};

                    // Add a new Employee
                    $("#addCheque").off("click").on("click", function() {
                        $(this).before(function() {
                            var html = '<div id="cheque' + chIndex + '.wrapper" class="hidden">';
                            html += '<input type="text" id="cheque' + chIndex + '.number" name="cheque[' + chIndex + '].number" />';
                            html += '<input type="text" id="cheque' + chIndex + '.amount" name="cheque[' + chIndex + '].amount" />';
                            html += '<input type="hidden" id="cheque' + chIndex + '.remove" name="cheque[' + chIndex + '].remove" value="0" />';
                            html += '<a href="#" onclick="removeChequeRow('+chIndex+')" class="chequeremove" data-chIndex="' + chIndex + '">remove</a>';

                            html += "</div>";
                            return html;
                        });
                        $("#cheque" + chIndex + "\\.wrapper").show();
                        chIndex++;
                        return false;
                    });


                });

                function removeRow(key){
                    $("#credit" + key + "\\.wrapper").remove();
                }

                function removeChequeRow(key){
                    $("#cheque" + key + "\\.wrapper").remove();
                }

            </script>
        </head>
<body>
<h1>
    Add  Payment
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

    </table>

    <table>
        <tr colspan="2">Cash Payment</tr>
        <tr>
            <td>
                <form:label path="cash">
                    <spring:message text="cash"/>
                </form:label>
            </td>
            <td>
                <form:input path="cash.amount" />
            </td>
        </tr>
    </table>

    <table>
        <tr colspan="2">Credit Card Payments</tr>
        <tr>
            <td>Card No</td>
            <td>Amount</td>
        </tr>
        <tr>
            <td>
                <c:forEach items="${credit}" var="credit" varStatus="loop">
               <div id="credit${loop.index}.wrapper">
                        <!-- Generate the fields -->
                        <form:input path="credit[${loop.index}].number" />
                        <form:input path="credit[${loop.index}].amount" />
                        <!-- Add the remove flag --><!-- Add a link to remove the Employee -->
                        <a href="#" class="creditremove" data-index="${loop.index}">remove</a>
                    </div>
                    </c:forEach>
                    <button id="add" type="button">add</button>
            </td>
        </tr>
    </table>

    <table>
        <tr colspan="2">Cheque Payments</tr>
        <tr>
            <td>Cheque No</td>
            <td>Amount</td>
        </tr>
        <tr>
            <td>
                <c:forEach items="${cheque}" var="cheque"  varStatus="loop">
                <!-- Add a wrapping div -->
                    <div id="cheque${loop.index}.wrapper">
                        <!-- Generate the fields -->
                        <form:input path="cheque[${loop.index}].number" />
                        <form:input path="cheque[${loop.index}].amount" />
                        <!-- Add the remove flag -->
                        <!-- Add a link to remove the Employee -->
                        <a href="#" class="chequeremove" data-index="${loop.index}">remove</a>
                    </div>
                    </c:forEach>
                    <button id="addCheque" type="button">add</button>
            </td>
        </tr>
    </table>
    <table>
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
<c:if test="${!empty listInstallPayments}">
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

