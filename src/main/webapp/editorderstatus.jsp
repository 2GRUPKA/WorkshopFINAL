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
        <div> <input type='number' name='id' required placeholder="id" /></div>
        <div>
            <select name="status">
                <option value="Accepted">Accepted</option>
                <option value="Taken into repair">Taken into repair</option>
                <option value="In repair">In repair</option>
                <option value="Ready for pick up">Ready for pick up</option>

            </select>
        </div>

        <button>SAVE TO DB</button>

    </form>

</div>

<%@ include file="/fragments/footer.jsp"  %>

</body>
</html>
