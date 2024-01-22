package yooWorld.yooImage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class YooImageDAO {
	Connection conn;
	
	public YooImageDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	public int getMaxNum() {
		int maxNum = 0;
		
		return maxNum;
	}
	
	
	public int insertDate() {
		int result = 0;
		return result;
	}
	

	public List<YooImageDTO> getList(int start, int end){
		List<YooImageDTO> lists = new ArrayList<YooImageDTO>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			sql = "select * from(";
			sql+= "select rownum rnum, data.* from (";
			sql+= "select num,subject,saveFileName,originalFileName,";
			sql+= "hitCount,likeCount,createdDate from yooImage";
			sql+= "order by num desc";
			sql+= ") data) where rnum>=? and rnum<=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				YooImageDTO dto = new YooImageDTO();
				dto.setNum(rs.getInt("num"));
				dto.setSubject(rs.getString("subject"));
				dto.setSaveFileName(rs.getString("saveFileName"));
				dto.setOriginalFileName(rs.getString("originalFileName"));
				dto.setHitCount(rs.getInt("hitCount"));
				dto.setLikeCount(rs.getInt("likeCount"));
				dto.setCreatedDate(rs.getString("createdDate"));
				
				lists.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
