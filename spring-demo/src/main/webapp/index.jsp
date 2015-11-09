<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<head>
    <title></title>
    <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
</head>
<body>
    this is test.
    <a href="${ctx}/learn/testRb?name=zhangsan&age=1">testRb</a><br>
    <a href="#" onclick="dopost2()">testCustomObj</a><br>
    <a href="#" onclick="dopost3()">testCustomObjWithRp</a><br>
    <a href="${ctx}/learn/testDate?date=2014-05-06">testDate</a><br>
    <a href="${ctx}/learn/xmlOrJson">xmlOrJson</a><br>
    <a href="${ctx}/learn/innerTest?name=xxx&age=10">innerTest</a>
<script>
    function dopost(){
        console.info("aaaaa");
        $.post('${ctx}/learn/testRb',{"name":"zhangsan","age":1},function(data){});
    }

    function dopost2(){
        console.info("aaaaa");
        $.post('${ctx}/learn/testCustomObj',{"name":"zhangsan","age":1},"application/json");
    }

    function dopost3(){
        console.info("aaaaa");
        $.post('${ctx}/learn/testCustomObjWithRp',{"name":"zhangsan","age":1},"application/json");
    }
</script>
</body>
</html>
