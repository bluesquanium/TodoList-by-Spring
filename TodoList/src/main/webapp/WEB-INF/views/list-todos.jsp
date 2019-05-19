<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%@ include file="common/header.jspf"%>

    <style>
        .table-name {
            caption-side: top;
            text-align: center;
        }
    </style>

    <body>
        <%@ include file="common/navigation.jspf"%>

        <div class="container">

            <table class="table table-striped">
                <caption class="h1 table-name">${name}'s Todo List </caption>
                <thead>
                    <tr>
                        <th>Priority</th>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Is Done</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <!-- for(Todo todo: todos) -->
                    <c:forEach items="${todos}" var="todo">
                        <tr class="<spring:message code="bootstrap.${todo.isDone}"/> ">
                            <td>${todo.priority}</td>
                            <td> <a href=" <spring:url value="/content?id=${todo.id}" /> ">${todo.desc}</a> </td>
                            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}"/></td>
                            <td> <a href=" <spring:url value="/update-isdone?id=${todo.id}" /> "> <spring:message code="${todo.isDone}" /> </a> </td>
                            <td><a href=" <spring:url value="/update-todo?id=${todo.id}" /> " class="btn btn-primary">Update</a>
                                <a href=" <spring:url value="/delete-todo?id=${todo.id}" /> " class="btn btn-danger">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>

            <div>
                <a class="btn btn-success" href=" <spring:url value="/add-todo" /> ">Add</a>
            </div>

        </div>
    </body>

    <%@ include file="common/footer.jspf"%>
</html>