<%@ include file = "Comman/Navigation.jsp" %>
<%@ include file = "Comman/Header.jsp" %>

<div class="container">
    <h2>Enter todo details</h2>
    <form:form method="post" modelAttribute="todo">

    <fieldset class="mb-3">
        <form:label path="desc">Description</form:label>
        <form:input type = "text" path = "desc" required = "required"/>
        <form:errors path = "desc" cssClass="text-warning"/>
    </fieldset>

    <fieldset class="mb-3">
        <form:label path="dateCompletion">Target Date</form:label>
        <form:input type = "text" path = "dateCompletion" required = "required"/>
        <form:errors path = "dateCompletion" cssClass="text-warning"/>
    </fieldset>
    
    <form:input type = "hidden" path = "id"/>
    <form:input type = "hidden" path = "isDone"/>

    <input type = "submit" class="btn btn-success"/>
    
</form:form>
</div>

<%@ include file = "Comman/Footer.jsp" %>

<script type="text/javascript">
    $('#dateCompletion').datepicker({
    format: 'yyyy-mm-dd',
});
</script>