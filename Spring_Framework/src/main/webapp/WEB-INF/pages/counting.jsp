<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
    <head>
        <title>Hello Spring</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="/resources/css/theme.css">
    </head>
    <body>
        <h1>Hello Spring</h1>
        <p> Count: ${counting.count}</p>
        
        <form action="/add" method="POST">
           <input type="submit" value="Add" />
        </form>
        <form action="/subtract" method="POST">
            <input type="submit" value="Subtract" />
        </form>
    </body>
</html>