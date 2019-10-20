package service;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import dbconn.DbConn;

public class MemberDao {
/*	멤버변수=전역=인스턴스 =객체 내부에서만 외부에서 수정가능할수도 있으니
	private 붙임
	static 붙으면 클래스 변수*/
	private Connection conn;
	
	public MemberDao(){//생성자 > 만들어지면 자동으로 실행
	DbConn db = new DbConn();
	this.conn = db.getConnection();
	}
	public int insertMember(String userId, String userPwd,
			String userName, String userSex, int jumin_number,
			String juso, String ip,
			String writeday, String t_fav){
	
		Statement stmt =null;
		
		int execYn = 0;
		String sql = ("insert into member32 (midx,id,pwd,name,sex,jumin,juso,userIp,writeday,fav) values(midx_seq.nextval,'"+userId+"','"+userPwd+"','"+userName+"','"+userSex+"','"+jumin_number+"','"+juso+"','"+ip+"','"+writeday+"','"+t_fav+"')"); 
	 	
		try{
			stmt = ((java.sql.Connection) conn).createStatement();
	 	execYn = stmt.executeUpdate(sql);
	 	}catch(Exception e){
	 		e.printStackTrace();
	 	}finally{
	 		try{
	 			stmt.close();
	 			conn.close();
	 		}catch(Exception e){
	 			e.printStackTrace();
	 		}
	 	}
	 	return execYn;
			}


	public ArrayList<MemberVo> selectMember(String userName){
		
		ArrayList<MemberVo> alist = new ArrayList<MemberVo>();
		
		Statement stmt	= null;
		//결과 값 객체 선언
		ResultSet rs =null;
	try {
		String sql = "select * from member32 where name like '%"+userName+ "%' and delYn='n' order by midx desc";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()){	
			MemberVo mv = new MemberVo();
					mv.setMidx(rs.getInt("midx"));
					mv.setId(rs.getString("id"));
					mv.setPwd(rs.getString("pwd"));
					mv.setName(rs.getString("name"));
					mv.setSex(rs.getString("sex"));
					mv.setJumin(rs.getString("jumin"));
					mv.setJuso(rs.getString("juso"));
					mv.setUserIp(rs.getString("userIp"));
					String[] favArray = {rs.getString("fav")};
					mv.setFav(favArray);
					mv.setWriteday(rs.getString("writeday"));
					mv.setDelYn(rs.getString("DelYn"));
					
					alist.add(mv);
		
				} } catch (Exception e){
					e.printStackTrace();
				} finally{
					try{
							rs.close();
							stmt.close();
							conn.close();
					}catch(Exception e){
						e.printStackTrace();
						}
				}
							return alist;
	}
	
}
