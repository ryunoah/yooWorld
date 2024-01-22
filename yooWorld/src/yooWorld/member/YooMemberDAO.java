package yooWorld.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class YooMemberDAO {

	Connection conn;
	
	public YooMemberDAO(Connection conn){
		this.conn = conn;
	}
	
	
	
	// 회원가입 인서트 데이터
	public int userInsertData(YooMemberDTO dto) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "insert into yooMember (id,pwd,name,tel,birth,regDate) ";
			sql+= "values (?,?,?,?,?,sysdate)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getBirth());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
	}
	
	//회원가입시 중복확인
	public boolean duplicatedID(String id) {
		
		boolean result = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int dataCount = 0;
		
		try {
			
			sql = "select nvl(count(*),0) from yooMember ";
			sql+= "where id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dataCount = rs.getInt(1);
			}
			
			if(dataCount!=0) {
				result = true;
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		return result;
	}
	
	//여기저기서 쓸라고 하나의 데이터 뽑아오기
	
	public YooMemberDTO getReadData(String id) {
		YooMemberDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			
			sql = "select id,pwd,name,tel,birth,TO_CHAR(regDate, 'YYYY-MM-DD') regDate ";
			sql+= "from yooMember where id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new YooMemberDTO();
				
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setBirth(rs.getString("birth"));
				dto.setRegDate(rs.getString("regDate"));
			}
			
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}
	
	
	
	
}
