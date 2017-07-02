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
							<div class="form-group">
						        <label>제목</label>
						        <span>${boardView.subject}</span>
						      </div>
						      <div class="form-group">
						        <label>작성자</label>
						        <span>${boardView.writer}</span>
						      </div>
						      <div class="form-group">
						        <label>작성날짜</label>
						        <span><fmt:formatDate value="${boardView.reg_date}" pattern="yyyy/ MM/ dd HH:mm" /></span>
						      </div>
						      <div class="form-group">
						        <label>조회수</label>
						        <span>${boardView.hit}</span>
						      </div>
						      <div class="form-group">
						        <label>내용</label>
						        <p>${boardView.content}</p>
						      </div>
						      <div class="form-group">
						          <input type="button" value="수정" onclick="location.href='<c:url value='/board/update/${boardView.bno}' />'">
						          <form:form action="/board/${boardView.bno}" method="DELETE">
						              <input type="submit" value="삭제">
						          </form:form>
						      </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>