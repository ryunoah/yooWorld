package com.util;
//page 처리 클래스
public class MyUtil {
	
	//전체 페이지의 갯수
	
	public int getPageCount(int numPerPage, int dataCount) {
		
		int pageCount = 0;
		
		pageCount = dataCount / numPerPage;
		
		if(dataCount % numPerPage != 0) {
			pageCount++;
			
		}
		return pageCount;
	}
	
	
	
	
	//페이징 처리 메소드
	public String pageIndexList(int currentPage, int totalPage, String listUrl) {
		
		int numPerBlock = 5;
		//currentPageSetup엔  ◀이전 버튼 누르면 들어갈 페이지 예를들어 6에서 이전 누르면 ◀이전 버튼은 5를 향해야함
		int currentPageSetup;
		int page;
		
		StringBuffer sb = new StringBuffer();
		
		if(currentPage==0||totalPage==0) {
			return "";
		}
		
		//listUrl에 list.jsp넣을거. 
		//list.jsp 이렇게 들어오거나
		//list.jsp?searchKey=name&searchValue=suzi 이런식으로 드러올거
		//왜 ?있나 없나 검사햇냐면
		//<a href="list.jsp?searchKey=subject&searchValue=1&pageNum=2"> 이런식으로 된거에 없으면 붙혀주거나 하려고 하는거
		//?가 있다면 &붙히고 없으면 ? 붙혀
		if(listUrl.indexOf("?")!=-1) {
			listUrl = listUrl + "&";
		} else {
			listUrl += "?";
		}
			
		currentPageSetup = (currentPage/numPerBlock)*numPerBlock;
		
		if(currentPage % numPerBlock ==0) {
			currentPageSetup = currentPageSetup - numPerBlock;
		}
		
		
		//◀이전
		if(totalPage > numPerBlock && currentPageSetup >0) {
			//<a href="list.jsp?pageNum=5">◀이전</a>&nbsp; 이 모양 만든거임
			sb.append("<a href=\"" + listUrl + "pageNum=" + currentPageSetup + "\">◀이전</a>&nbsp;");
		}
		
		//바로가기 페이지
		page = currentPageSetup + 1; 
		while(page <= totalPage && page <= (currentPageSetup + numPerBlock)) {
			
			if(page == currentPage) {
				//append는 누적하는거니까 저 위에 
				//sb.append("<a href=\"" + listUrl + "pageNum=" + currentPageSetup + "\">◀이전</a>&nbsp;");
				//여기에 누적하는거
				sb.append("<font color=\"Fuchsia\">" + page + "</font>&nbsp;");
			} else {
				sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">" + page + "</a>&nbsp;");
			}
			
			page++;
		}
		
		
		//다음▶
		if(totalPage - currentPageSetup > numPerBlock) {
			
			sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">다음▶</a>&nbsp;");
			
			
		}
	
	return sb.toString();
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
}
