<%@ include file = "Comman/Navigation.jsp" %>
<%@ include file = "Comman/Header.jsp" %>

<div class="container">

    <div>Welcome ${name}</div>
    <hr>
    <h2> Your todos</h2>

    <table class="table">
        <thead>
            <tr>
                <th>Description</th>
                <th>Date</th>
                <th>Completed</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.desc}</td>
                    <td>${todo.dateCompletion}</td>
                    <td>${todo.isDone}</td>
                    <td> <a href="deletetodo?id=${todo.id}" class="btn btn-warning">Delete</a> </td>
                    <td> <a href="updatetodo?id=${todo.id}" class="btn btn-success">Update</a> </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="addtodo" class="btn btn-success">AddTask</a>

</div>

<%@ include file = "Comman/Footer.jsp" %>