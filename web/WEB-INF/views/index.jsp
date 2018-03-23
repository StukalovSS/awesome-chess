<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Hello world!</title>
        <link rel="stylesheet" type="text/css" href="${request.contextPath}/resources/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="${request.contextPath}/resources/css/style.css">
    </head>
    <body>
        <div class="container-fluid">
            <div class="block">
                <span class="bigyellowtext">{</span>
                <span class="bigredtext">Bonjour</span>
                <span class="bigyellowtext"> =)</span><br/>

                <span class="bigyellowtext">I`m the </span>
                <span class="bigbluetext">mock</span>
                <span class="bigyellowtext">.}</span>
            </div>
            <br/>
            <div class="alert alert-primary" role="alert">text</div>
        </div>
    <script  src="${request.contextPath}/resources/js/jquery-3.2.1.slim.min.js"></script>
    <script  src="${request.contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>
