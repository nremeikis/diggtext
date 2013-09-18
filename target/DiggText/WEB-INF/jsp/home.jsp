<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>DiggText - a social text information aggregator.</title>
    <link href="<s:url value="/static" />/css/styles.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
  <div class="top">
      <div class="top-in">
        <div class="nav">
          <div class="search">
            <form action="submitUrl" method="post">
            	<div class="field-validation-error">${error}</div>
            	<input type="text" id="httpAddress" name="httpAddress"/>
				<input type="submit" value="Submit Url"/>         
			</form>
          </div>
        </div>
      </div>
    </div>
  <div class="body">
      <div class="content">
		<h1>Recent Posts</h1>
		<c:forEach items="${stories}" var="story">
			<div class="post-line">
			    <div class="revised"><c:out value="${story.getCategory().name}"/></div>
			    <div class="comments">0 comments</div>
			    <div class='summary'>
			    <h2>
				    <c:url value="/redirectToSite" var="url"><c:param name="id" value="${story.id}"/></c:url>
				    <a href="<c:out value="${url}"/>"><c:out value="${story.getTitle()}"/></a>
			    </h2>
			    <span class="tags"></span></div>
			</div>
		</c:forEach>		
      </div>
  </div>
  </body>
</html>
