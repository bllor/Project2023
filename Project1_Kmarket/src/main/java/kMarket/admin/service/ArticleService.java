package kMarket.admin.service;

import kMarket.admin.dao.ArticleDao;
import kMarket.admin.dto.ArticleRequestDto;
import kMarket.admin.dto.ArticleResponseDto;
import kMarket.admin.request.ArticleUpdateRequest;

import java.sql.SQLException;
import java.util.List;

public class ArticleService {
//    singleton
    private static ArticleService INSTANCE = new ArticleService();
    private ArticleService() {} //생성자에 접근 x
    public static ArticleService getInstance() {
        return INSTANCE;
    }

    private static ArticleDao articleDao = ArticleDao.getInstance();

    private static ArticleDao dao = ArticleDao.getInstance();
    public int insertArticle(ArticleRequestDto dto) {
        return dao.insertArticle(dto);
    }

    public List<ArticleResponseDto> getArticlesByCate(String cate) throws SQLException {
        return articleDao.selectArticles(cate);
    }

    public ArticleResponseDto getOneArticle(Integer cNo) throws SQLException {
        return articleDao.selectArticle(cNo);
    }

    public boolean updateArticle(ArticleUpdateRequest dto) throws SQLException {
        return articleDao.updateArticle(dto);
    }
}
