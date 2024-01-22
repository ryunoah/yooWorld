package com.util;
//page ó�� Ŭ����
public class MyUtil {
	
	//��ü �������� ����
	
	public int getPageCount(int numPerPage, int dataCount) {
		
		int pageCount = 0;
		
		pageCount = dataCount / numPerPage;
		
		if(dataCount % numPerPage != 0) {
			pageCount++;
			
		}
		return pageCount;
	}
	
	
	
	
	//����¡ ó�� �޼ҵ�
	public String pageIndexList(int currentPage, int totalPage, String listUrl) {
		
		int numPerBlock = 5;
		//currentPageSetup��  ������ ��ư ������ �� ������ ������� 6���� ���� ������ ������ ��ư�� 5�� ���ؾ���
		int currentPageSetup;
		int page;
		
		StringBuffer sb = new StringBuffer();
		
		if(currentPage==0||totalPage==0) {
			return "";
		}
		
		//listUrl�� list.jsp������. 
		//list.jsp �̷��� �����ų�
		//list.jsp?searchKey=name&searchValue=suzi �̷������� �巯�ð�
		//�� ?�ֳ� ���� �˻��޳ĸ�
		//<a href="list.jsp?searchKey=subject&searchValue=1&pageNum=2"> �̷������� �Ȱſ� ������ �����ְų� �Ϸ��� �ϴ°�
		//?�� �ִٸ� &������ ������ ? ����
		if(listUrl.indexOf("?")!=-1) {
			listUrl = listUrl + "&";
		} else {
			listUrl += "?";
		}
			
		currentPageSetup = (currentPage/numPerBlock)*numPerBlock;
		
		if(currentPage % numPerBlock ==0) {
			currentPageSetup = currentPageSetup - numPerBlock;
		}
		
		
		//������
		if(totalPage > numPerBlock && currentPageSetup >0) {
			//<a href="list.jsp?pageNum=5">������</a>&nbsp; �� ��� �������
			sb.append("<a href=\"" + listUrl + "pageNum=" + currentPageSetup + "\">������</a>&nbsp;");
		}
		
		//�ٷΰ��� ������
		page = currentPageSetup + 1; 
		while(page <= totalPage && page <= (currentPageSetup + numPerBlock)) {
			
			if(page == currentPage) {
				//append�� �����ϴ°Ŵϱ� �� ���� 
				//sb.append("<a href=\"" + listUrl + "pageNum=" + currentPageSetup + "\">������</a>&nbsp;");
				//���⿡ �����ϴ°�
				sb.append("<font color=\"Fuchsia\">" + page + "</font>&nbsp;");
			} else {
				sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">" + page + "</a>&nbsp;");
			}
			
			page++;
		}
		
		
		//������
		if(totalPage - currentPageSetup > numPerBlock) {
			
			sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">������</a>&nbsp;");
			
			
		}
	
	return sb.toString();
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
}
