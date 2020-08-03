<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Ad"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <h1>Edit Ad</h1>
          <%-- edit page --%>
    <form action="${pageContext.request.contextPath}/ads/edit" method="post">
             <%--pulls ad to be edited--%>
        <input type="hidden" name="adId" value="${ad}">
        <div class="col-md-6 justify-content-center form-group">
            <label for="title"> Title:</label>
                 <%--auto fills ad title--%>
            <input id="title" type="text" name="title" value="${currentTitle}">
        </div>
        <div class="form-group">
            <label for="description"> Description: </label>
            <%--auto fills ad Description--%>
            <textarea id="description" type="text" name="desc">${currentDesc}</textarea>
            <input type="submit" class="btn btn-primary btn-block">
        </div>
    </form>
           <%--submits and redirects to editAdsServlet post--%>
</div>
</body>
</html>