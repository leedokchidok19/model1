<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "service.MemberDao" %>
<%@ page import = "service.MemberVo" %>
<%@ page import = "java.util.ArrayList" %>

<%

request.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=UTF-8");
String userName = request.getParameter("userName");
	 if(userName == null){
		userName = "";
						 }
	
MemberDao md = new MemberDao();
ArrayList<MemberVo> t_str2 = md.selectMember(userName);

String t_str3 = "";
for(MemberVo mv : t_str2){
	
	t_str3 = t_str3+"<div class='table-row'><div class='table-cell'>"+mv.getMidx()
	+"</div><div class='table-cell'>"+mv.getId()+"</div><div class='table-cell'>"+mv.getPwd()
	+"</div><div class='table-cell'>"+mv.getName()+"</div><div class='table-cell'>"+mv.getSex()
	+"</div><div class='table-cell'>"+mv.getJumin()+"</div><div class='table-cell'>"+mv.getJuso()
	+"</div><div class='table-cell'>"+mv.getUserIp()+"</div><div class='table-cell'>"+mv.getFav()[0]
	+"</div><div class='table-cell'>"+mv.getWriteday()+"</div><div class='table-cell'>"
	+mv.getDelYn()+"</div></div>";
			
}


%>

<!doctype html>
<html>
 <head>
  <meta charset="UTF-8">
  <title>model 1방식</title>
  	<link rel = "stylesheet" type = "text/css" href = "./Include/member.css" />
	<script type = "text/javascript">
	window.onload = function(){//window<실행시 function 실행
			
			document.getElementsById("rows").innerHTML = "<%=t_str3%>";

	}		
	</script>
</head>
<body>

	<div class="table default">
		<div class="table-header">
				<div class="table-row">
						<form name = 'frm' action = './memberList.jsp' method = 'post'>
					<div class="table-head">
						<input type='text' name ='userName' >
					</div>
					<div class="table-head">
						<input type='submit' name ='submit' value = '검색'>
					</div>
						</form>		
				</div>
		</div>
		<div class="table-header">
			<div class="table-row">
				<div class="table-head">midx</div>
				<div class="table-head">아이디</div>
				<div class="table-head">패스워드</div>
				<div class="table-head">이름</div>
				<div class="table-head">성별</div>
				<div class="table-head">주민번호</div>
				<div class="table-head">주소</div>
				<div class="table-head">IP주소</div>
				<div class="table-head">취미</div>
				<div class="table-head">날짜</div>
				<div class="table-head">delYn</div>
			</div>
		</div>
		<div id = "rows"  class='table-Bobby'>
		</div>
		<%= t_str3 %>
</div>
</body>
</html>


