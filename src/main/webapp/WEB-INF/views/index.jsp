<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/sketchy/bootstrap.min.css" />
</head>
<body>

<h1>Please upload any file type - you can add multiple files and types!</h1>
  <form action="/test" method="post" enctype="multipart/form-data">
      <input type="file" name="files" multiple>
      <input type="submit" value="Upload Files"></input>
   </form>
</body>
</html>