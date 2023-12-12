package kMarket.admin.controller.cs;

import kMarket.admin.dto.ArticleResponseDto;
import kMarket.admin.service.ArticleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "adminNotice",value = "/admin/cs/notice/list.do")
public class NoticeController extends HttpServlet {
    //private static final long serialVersionUID = 1L;
    private static final ArticleService articleService = ArticleService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/cs_notice_list.jsp");
        try {
            List<ArticleResponseDto> articles = articleService.getArticlesByCate("notice");
            req.setAttribute("articles", articles);
            dispatcher.forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
