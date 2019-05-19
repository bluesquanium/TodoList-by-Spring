<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="common/header.jspf"%>

<body>
<%@ include file="common/navigation.jspf"%>

<div class="container">
    <br/>
    <h3>Todo</h3>
    <div class="container">
        <fieldset class="form-group">
            <label>Description</label>
            <p class="form-control" readonly="true"> ${todo.desc} </p>
        </fieldset>

        <fieldset class="form-group">
            <label>Content</label>
            <textarea rows="5" class="form-control" readonly="true"> ${todo.content} </textarea>
        </fieldset>

        <fieldset class="form-group">
            <label>Target Date</label>
            <p class="form-control" readonly="true"> <fmt:formatDate pattern="yyyy-MM-dd" value="${todo.targetDate}"/> </p>
        </fieldset>

        <fieldset class="form-group">
            <label path="priority">Priority</label>
            <input path="priority" type="number" class="form-control" disabled="true" value="${todo.priority}"/>
        </fieldset>

        <fieldset class="form-group">
            <label path="isDone">isDone</label>
            <input path="isDone" type="text" class="form-control" disabled="true" value="${todo.isDone}"/>
        </fieldset>


        <a class="btn btn-warning" href=" <spring:url value="/list-todos" /> ">Back</a>
    </div>
</div>

<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

<%@ include file="common/footer.jspf"%>
</html>