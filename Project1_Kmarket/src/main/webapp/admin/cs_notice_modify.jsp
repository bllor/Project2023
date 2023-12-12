<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2023-09-20
  Time: 오후 4:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_header.jsp" %>
<main>
    <%@ include file="_aside.jsp" %>
    <section class="write">
        <nav>
            <h3>공지사항 보기</h3>
            <p>
                HOME > 고객센터 > <strong>공지사항</strong>
            </p>
        </nav>
        <article>
            <form action="/admin/cs/notice/modify.do" method="post">
                <input type="hidden" name="cNo" value="${article.cNo}"/>
            <table>
                <tr>
                    <th>유형 <button>수정</button></th>
                    <td id="menuGroup">
                        <select id="menu1" name="menu1">
                            <option>회원</option>
                            <option>쿠폰/혜택/이벤트</option>
                            <option>주문/결제</option>
                            <option>배송</option>
                            <option>취소/반품/교환</option>
                        </select>
                        <select id="menu2" name="menu2">
                            <option selected>가입</option>
                            <option>탈퇴</option>
                            <option>회원정보</option>
                            <option>로그인</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title" value="${article.title}" placeholder="제목을 입력하소!"/></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea name="content">${article.content}</textarea></td>
                </tr>
            </table>
                <input type="submit" value="수정하기">
            </form>
            <div>
                <input id="delete_btn" type="button" value="삭제" />
                <input id="modify_btn" type="button" value="수정" />
                <input id="list_btn" type="button" value="목록" />
            </div>
        </article>
    </section>
</main>
<script>
    let deleteBtn = document.getElementById("delete_btn");
    let modifyBtn = document.getElementById("modify_btn");
    let listBtn = document.getElementById("list_btn");
    document.getElementById("menuGroup");

    deleteBtn.addEventListener("click",()=>{
        location.replace("")
    })
    modifyBtn.addEventListener("click",()=>{
        location.replace("")
    })
    listBtn.addEventListener("click",()=>{
        location.replace("/admin/cs/notice/list.do");
    })
</script>
<%@ include file="_footer.jsp" %>
