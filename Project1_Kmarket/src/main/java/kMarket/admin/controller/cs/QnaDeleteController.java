package kMarket.admin.controller.cs;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kMarket.cs.service.CsArticleService;

@WebServlet("/admin/cs/qna/delete.do")
public class QnaDeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	 Logger logger = LoggerFactory.getLogger(this.getClass());
	 CsArticleService aService = CsArticleService.INSTANCE;
	
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String cNo = req.getParameter("cNo");
		 String menu1 = req.getParameter("menu1");
		 String menu2 = req.getParameter("menu2");
		 logger.debug("cNo :"+cNo);
		 aService.deleteArticle(cNo);
		 req.setAttribute("menu1", menu1);
		 req.setAttribute("menu2", menu2);
		 RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs/qna/list.do");
		dispatcher.forward(req, resp);
	 
	 }
	 
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BufferedReader br = req.getReader();
		StringBuilder sb = new StringBuilder();
        String cur;
        while ((cur = br.readLine()) != null) {
            sb.append(cur);
        }
		
        //ObjectMapper om = new objectMapper();
        //jackson 라이브러리 추가 하는 거 찾기
        //jackson버전이 달라도 괜찮을지 생각해보기
        //동환님은 2.12.3인데 이 버전에는 jar파일이 없어서 최신 파일을 다운받아야 할 것 같음
        
		
		
		
	}
	
}
