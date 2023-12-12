package kMarket.admin.dao;

import kMarket.admin.db.DbHelper;
import kMarket.admin.db.SqlArticle;
import kMarket.admin.dto.ArticleRequestDto;
import kMarket.admin.dto.ArticleResponseDto;
import kMarket.admin.request.ArticleUpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao extends DbHelper {
    private static ArticleDao INSTANCE = new ArticleDao();

    public static ArticleDao getInstance() {
        return INSTANCE;
    }
    private ArticleDao() {};
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public int insertArticle(ArticleRequestDto dto) {

        int no = 0;

        try {
            conn = getConnection();
            conn.setAutoCommit(false); // Transaction 시작

            stmt = conn.createStatement();
            psmt = conn.prepareStatement(SqlArticle.INSERT_ARTICLE);
            psmt.setString(1, dto.getCate());
            psmt.setString(2,dto.getMenu1());
            psmt.setString(3, dto.getMenu2());
            psmt.setString(4, dto.getTitle());
            psmt.setString(5, dto.getContent());
            psmt.executeUpdate();
            rs = stmt.executeQuery(SqlArticle.SELECT_MAX_NO);
            conn.commit(); // 작업확정

            if(rs.next()) {
                no = rs.getInt(1);
            }
            close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return no;
    }

    public List<ArticleResponseDto> selectArticles(String cate) throws SQLException {
        List<ArticleResponseDto> articles = new ArrayList<>();

        try{
            conn = getConnection();
            psmt = conn.prepareStatement(SqlArticle.SELECT_ARTICLES);
            psmt.setString(1, cate);
            rs = psmt.executeQuery();

            while (rs.next()) {
                ArticleResponseDto dto = new ArticleResponseDto();
                dto.setcNo((long) rs.getInt(1));
                dto.setCate(rs.getString(2));
                dto.setMenu1(rs.getString(3));
                dto.setMenu2(rs.getString(4));
                dto.setTitle(rs.getString(5));
                dto.setContent(rs.getString(6));

                articles.add(dto);
            }
            close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        logger.info("[ArticleDao]length of result = {}",articles.size());
        return articles;
    }

    public ArticleResponseDto selectArticle(Integer cNo) throws SQLException {
        ArticleResponseDto response = new ArticleResponseDto();
        conn = getConnection();
        psmt = conn.prepareStatement(SqlArticle.SELECT_ARTICLE);
        psmt.setInt(1,cNo);
        rs = psmt.executeQuery();

        while (rs.next()) {
            response.setcNo((long) rs.getInt(1));
            response.setCate(rs.getString(2));
            response.setMenu1(rs.getString(3));
            response.setMenu2(rs.getString(4));
            response.setTitle(rs.getString(5));
            response.setContent(rs.getString(6));
        }
        return response;
    }

    public boolean updateArticle(ArticleUpdateRequest dto) throws SQLException {
        ArticleResponseDto result = new ArticleResponseDto();
        conn = getConnection();
        psmt = conn.prepareStatement(SqlArticle.UPDATE_ARTICLE);
        psmt.setString(1, dto.getCate());
        psmt.setString(2, dto.getMenu1());
        psmt.setString(3, dto.getMenu2());
        psmt.setString(4, dto.getTitle());
        psmt.setString(5, dto.getContent());
        psmt.setInt(6, dto.getcNo());

        int rowNum = psmt.executeUpdate();
        if(rowNum == 0) return false;
        return true;
    }
}
