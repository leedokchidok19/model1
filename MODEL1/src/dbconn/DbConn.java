package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConn {
	
		 private Connection conn = null;
				//접속 정보 																												ㄴmidx_seq 넣으면 시퀀스로
			private	String coninfo ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
			private	String idinfo = "아이디";
			private	String pwdinfo = "비밀번호";
				//예외처리
			public Connection getConnection(){
					try	{
			//드라이버를 먼저 등록하고 그 중 사용가능한 드라이버속에 클래스 찾기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//드라이버 매니저가 접속 정보로 연결하기
			conn = DriverManager.getConnection(coninfo,idinfo,pwdinfo);
			                                             // ㄴ매개변수들
						} catch (Exception e){
									e.printStackTrace();
									 }
					return conn;
													}
			}