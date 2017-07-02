<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content= "text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>게시글 목록</title>
</head>
<body>
	<section>
		<div class="main-container">
			<div class="container">
				<div class="row">
					<div class="main object-non-visible">
						<div class="form-block center-block p-30">
							<h2 class="title"><strong>게시판 목록</strong></h2>
							<form:form commandName="BoardVo" action="/assignment/board/update/${boardView.bno}" method="PATCH">
					          <div class="form-group">
					            <label>제목</label>
					            <input type="text" name="subject" value="${boardView.subject}" class="form-control">
					          </div>
					          <div class="form-group">
					            <label>내용</label>
					            <textarea name="content" class="form-control" rows="5">${boardView.content}</textarea>
					          </div>
					          <button type="submit" class="btn btn-default">수정</button>
					        </form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>