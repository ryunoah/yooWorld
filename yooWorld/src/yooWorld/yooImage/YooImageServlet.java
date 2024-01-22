package yooWorld.yooImage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.DBConn;
import com.util.MyUtil;

import yooWorld.member.MemberInfo;


public class YooImageServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	protected void forward(HttpServletRequest req, HttpServletResponse resp, String url) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Connection conn = DBConn.getConnection();
		YooImageDAO dao = new YooImageDAO(conn);
		MyUtil myUtil = new MyUtil();
		String cp = req.getContextPath();
		String uri = req.getRequestURI();
		String url;
		
		HttpSession session = req.getSession();
		MemberInfo info = (MemberInfo) session.getAttribute("memberInfo");
		String logedUserID = info.getId();
		
		String root = getServletContext().getRealPath("/");
		String path = root + "yooImageBoard" + File.separator + logedUserID;
		
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		if(uri.indexOf("photoGallery.yoo")!=-1) {
			
			
			url = "/photoBoard/photoList.jsp";
			forward(req, resp, url);
		}
		
		
		
		
		
		
		
	}
}
