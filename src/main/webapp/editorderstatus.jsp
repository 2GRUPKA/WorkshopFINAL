<%--
  Created by IntelliJ IDEA.
  User: jakub
  Date: 04.07.18
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ include file="/fragments/header.jsp"  %>

<div>
    <form action="" method="post">
        <div> <input type='text' name='id' required placeholder="id" /></div>

        <div> <input type='text' name='status' required placeholder="status" /></div>

        <button>SAVE TO DB</button>

    </form>

</div>

<%@ include file="/fragments/footer.jsp"  %>

</body>
</html>
