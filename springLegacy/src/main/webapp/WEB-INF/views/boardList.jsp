<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<div class="main object-non-visible" data-animation-effect="fadeInUpSmall" data-effect-delay="100">
						<div class="form-block center-block p-30">
							<h2 class="title"><strong>게시판 목록</strong></h2>
						    <table class="table">
						        <tr>
						            <th>번호</th>
						            <th>제목</th>
						            <th>작성자</th>
						            <th>작성날짜</th>
						            <th>조회수</th>
						        </tr>
						        <c:forEach var="bL" items="${boardList}">
							        <tr>
							            <td>${bL.bno}</td>
							            <td><a href="/assignment/board/${bL.bno}">${bL.subject}</a></td>
							            <td>${bL.writer}</td>
							            <td><fmt:formatDate value="${bL.reg_date}" pattern="MM/ dd" /></td>
							            <td>${bL.hit}</td>
							        </tr>
						        </c:forEach>
						    </table>
							<div class="form-group has-feedback">
								<div class="col-sm-12">		
									<a href="<c:url value='/board/writeBoard' />" class="btn btn-primary pull-right">글쓰기</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>