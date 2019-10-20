package service;

public class MemberVo {
/*	Value object라고도 하고 DTO라고도 불린다	*/
	
	private int midx;		//index
	private String id;		//user - 아이디
	private String pwd;		//user - 비밀번호
	private String name;	//user - 이름
	private String sex;		//user - 성별
	private String jumin;	//user - 주민번호
	private String juso;	//user - 주소
	private String userIp;	//user - 아이피
	private String[] fav;	//user - 취미(배열)
	private String writeday;//user - 작성일
	private String delYn;	//user - 삭제여부
	
	public int getMidx() {
		return midx;
	}
	public void setMidx(int midx) {
		this.midx = midx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getJuso() {
		return juso;
	}
	public void setJuso(String juso) {
		this.juso = juso;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String[] getFav() {
		return fav;
	}
	public void setFav(String[] fav) {
		this.fav = fav;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	
	
}
