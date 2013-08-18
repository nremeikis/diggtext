<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>DiggText - a social text information aggregator.</title>
    <link href="<s:url value="/static" />/css/styles.css" 
          rel="stylesheet" 
          type="text/css" />
  </head>

  <body>
  <div class="body">
      <div class="content">
		<h1>Recent Posts</h1>
		<c:forEach items="${stories}" var="story">
			<div class="post-line">
			    <div class="revised"><c:out value="${story.getCategory().name}"/></div>
			    <div class="comments">0 comments</div>
			    <div class="summary"><h2><c:out value="${story.title}"/></h2><span class="tags"></span></div>
			</div>
		
		</c:forEach>		
      </div>
  </div>
  </body>
</html>
