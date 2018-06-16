<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${sessionScope.login.name}
<c:if test="${sessionScope.login.type=='student'}">
    <meta http-equiv="refresh" content="0;url=student/listClass" />
</c:if>
<c:if test="${sessionScope.login.type=='teacher'}">
    <meta http-equiv="refresh" content="0;url=teacher/listClass" />
</c:if>
</body>
</html>
