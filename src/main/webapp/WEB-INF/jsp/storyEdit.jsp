<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>DiggText - a social text information aggregator.</title>
    <link href="<s:url value="/static" />/css/styles.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
  <div class="body">
    <div class="content">
		<form:form method="POST" commandName="story" action="submitStory">
		<table>
			<tr>
				<td>Category</td><td>
					<form:select path="category">
						<form:options items="${categories}" itemValue="id" itemLabel="name" />
					</form:select>
				</td>
			</tr>	
		    <tr>
		        <td>Title</td><td><form:input path="title" size="65"></form:input></td>
		    </tr>
		    <tr>
		        <td>Url</td><td><form:input path="url" size="65"></form:input></td>
		    </tr>
		    <tr>
		        <td>Description</td><td><form:textarea path="textDescription" rows="10" cols="30" ></form:textarea></td>
		    </tr>
		    <tr>
		        <td colspan="2">
		            <input type="submit" value="Submit"/>
		        </td>
		    </tr>
		</table>  
		</form:form>
	<div>

  </div>
  </body>
</html>
