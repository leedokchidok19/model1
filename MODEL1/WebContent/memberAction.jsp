<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.net.*"%>
    <%@ page import ="java.util.Date"%> 
  	<%@ page import ="java.text.SimpleDateFormat"%>
  	<%@ page import ="service.MemberDao" %>
  	<jsp:useBean class="service.MemberVo" id="mv" scope = "page" />
  	<%
  	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=UTF-8");
  	%>
  	<jsp:setProperty property="*" name="mv" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
			String t_fav = "";
	for(int i =0; i<mv.getFav().length; i++){
			t_fav = t_fav + mv.getFav()[i];
	} 
	//날짜 클래스 객체생성
	Date dt = new Date();
	//날짜 형태를 지정한 yy/MM/dd 형태로 포맷을 바꿔준다(소문자 mm일 때 이상한 값)
	SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
	 
	String writeday = sdf.format(dt);
	//IP추출, IP주소를 받아오는 것
	String ip = InetAddress.getLocalHost().getHostAddress();
 
	MemberDao md = new MemberDao(); 
	int execYn = md.insertMember(mv.getId(),mv.getPwd(),mv.getName(),
		  mv.getSex(),Integer.parseInt(mv.getJumin()),mv.getJuso(),ip,writeday,t_fav);
 	
 	if(execYn==0){//페이지를 이동시킨다
 		out.println("<script>alert('회원가입실패');location.href='./Member.html';</script>");
 	}else{//성공후 페이지 이동시킨다
 		out.println("<script>alert('회원가입성공');location.href='./index.html';</script>");
 	}
 		%>
</body>
</html>