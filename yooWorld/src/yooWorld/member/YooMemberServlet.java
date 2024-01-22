package yooWorld.member;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.DBConn;

public class YooMemberServlet extends HttpServlet {

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
	
		
		String cp = req.getContextPath();
		Connection conn = DBConn.getConnection();
		YooMemberDAO dao = new YooMemberDAO(conn);
		
		String uri = req.getRequestURI();
		String url;
		
		if(uri.indexOf("resistration.yoo")!=-1) {
			url = "/yooWorldMember/resistration.jsp";
			forward(req, resp, url);
		}
		
		else if (uri.indexOf("duplicated_ok.yoo")!=-1) {
				String id = req.getParameter("id");
			    boolean isDuplicate = dao.duplicatedID(id);

			    // 중복 확인 결과를 메시지로 설정하고 request에 저장
			   if (isDuplicate) {
				   req.setAttribute("message", "중복된 ID 입니다");
			   } else { 
				   req.setAttribute("message", "사용 가능한 ID 입니다");
				   req.setAttribute("id", id);
			   }
			    
			    
			    url = "/yooWorldMember/resistration.jsp";
			    forward(req, resp, url);
		}
		
	
		
		else if (uri.indexOf("resistration_ok.yoo")!=-1) {
			
			YooMemberDTO dto = new YooMemberDTO();
			
			dto.setId(req.getParameter("id"));
			dto.setPwd(req.getParameter("pwd"));
			dto.setName(req.getParameter("name"));
			dto.setTel(req.getParameter("tel"));
			dto.setBirth(req.getParameter("birth"));
			
			dao.userInsertData(dto);
			
			url = cp + "/index.jsp";
			resp.sendRedirect(url);
		}
		
		
		else if (uri.indexOf("login.yoo")!=-1) {
			url = "/yooWorldMember/login.jsp";
			forward(req, resp, url);
		}
		
		
		else if (uri.indexOf("login_ok.yoo")!=-1) {
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			
			YooMemberDTO dto = dao.getReadData(id);
			
			if(dto==null||(!dto.getPwd().equals(pwd))) {
				req.setAttribute("message", "아이디 또는 패스워드가 틀렸습니다.");
				
				url="/yooWorldMember/login.jsp";
				forward(req, resp, url);
				return;
			}
			
			
			HttpSession session = req.getSession();
			
			MemberInfo info = new MemberInfo();
			info.setId(dto.getId());
			info.setPwd(dto.getPwd());
			info.setName(dto.getName());
			info.setTel(dto.getTel());
			info.setBirth(dto.getBirth());
			info.setRegDate(dto.getRegDate());
			
			session.setAttribute("memberInfo", info);
			
			url=cp;
			resp.sendRedirect(url);
		}
		
		
		else if (uri.indexOf("logout.yoo")!=-1) {
			HttpSession session = req.getSession();
			session.removeAttribute("memberInfo");
			session.invalidate();
			
			url = cp;
			resp.sendRedirect(cp);
			
		}
		
		
		
		
		
		
		

	}

	
}