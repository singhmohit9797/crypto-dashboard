<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<body>
            <c:forEach items="${coins}" var="c">
                      <a>${c.name }</a>  
                      <a>${c.symbol } </a>
                      <a>${c.price_usd} </a>
                          <br><br>
                        
             </c:forEach>
</body>
</html>