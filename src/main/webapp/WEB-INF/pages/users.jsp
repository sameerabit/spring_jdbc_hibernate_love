<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="utf-8">
        <title>Spring MVC Application</title>

        <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css" rel="stylesheet">
    </head>

    <body>
        <div class="container">
            <h1>Users</h1>
            <form:form method="post" action="add" commandName="user" role="form">
                <div class="form-group">
                    <form:label path="username">First Name:</form:label>
                    <form:input path="username" class="form-control" placeholder="User Name"/>
                </div>
                <div class="form-group">
                    <form:label path="password">Last Name:</form:label>
                    <form:input path="password" class="form-control" placeholder="Password Name"/>
                </div>

                <button type="submit" class="btn btn-default">Add User</button>
            </form:form>

        </div>
    </body>
</html>