<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <%--making sure the user is authenticated--%>
    <c:choose>
        <%--checks session to make sure user is logged in--%>
        <%--preventing non registed users to see ads--%>
         <c:when test="${sessionScope['user'] != null}">
             <h1>Here Are all the ads!</h1>
        <%-- loops thru ads and displays   --%>
            <c:forEach var="ad" items="${ads}">
                <div class="col-md-6">
                    <h2>${ad.title}</h2>
                    <p>${ad.description}</p>
                        <%--added if statment with forms and inputs--%>
             <%--checks if logged in user created ad. allows edit and delete if so--%>
                    <c:if test="${user_id eq ad.userId}">
                        <form action="${pageContext.request.contextPath}/ads/edit" method="get">
                            <input type="hidden" name="ad_id" value="${ad.id}">
                            <input class="btn btn-sm" type="submit" value="edit">
                        </form>
                        <form action="${pageContext.request.contextPath}/ads/delete" method="post">
                        <%--passes data to the backend with out user seeing it--%>
                            <input type="hidden" name="ad_id" value="${ad.id}">
                            <input class="btn btn-sm btn-danger" type="submit" value="delete">
                        </form>
                               <%--deleteAdsServlet--%>
                    </c:if>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <h1>Sorry Please Log In.</h1>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
