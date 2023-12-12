package kMarket.admin.db;

public class SqlArticle {
    public static final String INSERT_ARTICLE = "insert into `km_csarticle` set `cate`=?, `menu1`=?, `menu2`=?,`title`=?,`content`=?";
    public static final String SELECT_MAX_NO = "select MAX(`cNo`) from `km_csarticle`";
    //TODO :paging 처리 해주어야함
    public static final String SELECT_ARTICLES = "select cNo, cate, menu1, menu2, title,content from `km_csarticle` where cate=?";
    public static final String SELECT_ARTICLE = "select cNo,cate,menu1,menu2,title,content from `km_csarticle` where cNo=?";
    public static final String UPDATE_ARTICLE = "update `km_csarticle` set cate=?,menu1=?,menu2=?,title=?,content=? where cNo=?";
}
