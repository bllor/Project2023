<%--
  Created by IntelliJ IDEA.
  User: leedonghan
  Date: 2023/09/16
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="_header.jsp" %>
<main>
    <%@ include file="_aside.jsp" %>
    <section id="admin-cs-notice-list" class="admin-cs-list">
        <nav>
            <h3>공지 사항 목록</h3>
            <p>
                HOME > 고객센터 > <strong>공지사항</strong>
            </p>
        </nav>
        <section>
            <div>
                <select>
                    <option>
                        옵션1
                    </option>
                </select>
            </div>
            <table>
                <tr>
                    <th><input type="checkbox" name="all"/></th>
                    <th>번호</th>
                    <th>유형</th>
                    <th>제목</th>
                    <th>조회</th>
                    <th>날짜</th>
                    <th>관리</th>
                </tr>
                <c:forEach var="article" items="${articles}">
                    <tr>
                        <td><input type="checkbox" name="상품코드"/></td>
                        <td><a href="/admin/cs/notice/detail.do?cNo=${article.cNo}">${article.cNo}</a></td>
                        <td>${article.cate}</td>
                        <td>${article.title}</td>
                        <td>100</td>
                        <td>00.00.00</td>
                        <td>
                            <a href="#">[삭제]</a>
                            <a href="#">[수정]</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="notice_list_button">
                <input type="button" value="선택삭제"/>
                <a href="/admin/cs/notice/write.do">글작성</a>
            </div>
            <div class="paging">
                        <span class="prev">
                            <a href="#"><&nbsp;이전</a>
                        </span>
                <span class="num">
                            <a href="#" class="on">1</a>
                            <a href="#">2</a>
                            <a href="#">3</a>
                            <a href="#">4</a>
                            <a href="#">5</a>
                            <a href="#">6</a>
                            <a href="#">7</a>
                        </span>
                <span class="next">
                            <a href="#">다음&nbsp;></a>
                        </span>
            </div>
        </section>
    </section>
    </section>
</main>
<%@ include file="_footer.jsp" %>
