package com.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class fileManager {
	
	
	
	//사용자한테 내보내는거니까 리스폰스에 담아서
	//파일 보내는 경로까지
	public static boolean doFileDownload(HttpServletResponse response,
			String saveFileName, String originalFileName, String path) {
		
		try {
			
			
			
			String filePath = path + File.separator + saveFileName;
			
			//파일을 다운 받을 때 한글이름 깨짐 방지 
			originalFileName = new String(
					originalFileName.getBytes("euc-kr"),"ISO-8859-1");
					
			File f = new File(filePath);
			
			
			if(!f.exists()) {
				return false;
			}
			
			response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition",
					"attachment;fileName=" + originalFileName);
			
			BufferedInputStream bis = 
					new BufferedInputStream(new FileInputStream(f));
			
			OutputStream out = response.getOutputStream();
			
			int data;
			byte buffer[] = new byte[4096];
			
			while((data=bis.read(buffer, 0, 4096))!=-1) {
				out.write(buffer, 0, data);
			}
			out.flush();
			out.close();
			bis.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
		return true;
		}
	
	
	
	
	
	//파일 삭제는 물리적인 파일 삭제랑, 
	//DB에서 그 파일 데이터 삭제 두 가질 해야함
	//아래는 물리적 파일 삭제 (진짜 하드에 있는 파일 삭제)
	//DB 데이터삭제는 DAO에서 
	public static void doFileDelete(String fileName, String path) {
		
		try {
			
			String filePath = path + File.separator + fileName;
			
			File f = new File(filePath);
			
			if(f.exists()) {
				f.delete();
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
