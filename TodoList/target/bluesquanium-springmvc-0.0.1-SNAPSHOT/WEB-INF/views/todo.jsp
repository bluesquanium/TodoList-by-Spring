<html>
    <%@ include file="common/header.jspf"%>

    <body>
        <%@ include file="common/navigation.jspf"%>

        <div class="container">
            <br/>
            <h3>${page} Todo</h3>
            <form:form method="post" modelAttribute="todo">
                <form:hidden path="id"/>

                <fieldset class="form-group">
                    <form:label path="desc">Description</form:label>
                    <form:input path="desc" type="text" class="form-control" onFocus="this.value=''" required="required"/>
                    <form:errors path="desc" cssClass="text-warning" />
                </fieldset>

                <fieldset class="form-group">
                    <form:label path="content">Content</form:label>
                    <form:textarea path="content" rows="3" class="form-control"/>
                    <form:errors path="content" cssClass="text-warning" />
                </fieldset>

                <fieldset class="form-group">
                    <form:label path="targetDate">Target Date</form:label>
                    <form:input path="targetDate" type="date" class="form-control"/>
                    <form:errors path="targetDate" cssClass="text-warning" />
                </fieldset>

                <fieldset class="form-group">
                    <form:label path="priority">Priority</form:label>
                    <form:input path="priority" type="number" class="form-control"/>
                    <form:errors path="priority" cssClass="text-warning" />
                </fieldset>

                <input class="btn btn-success" type="submit" value="Submit"/>
            </form:form>
        </div>

        <script src="webjars/jquery/3.4.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>

    <%@ include file="common/footer.jspf"%>
</html>