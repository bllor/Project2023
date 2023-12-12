<%--
  Created by IntelliJ IDEA.
  User: leedonghan
  Date: 2023/09/17
  Time: 12:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_header.jsp"%>
<main>
    <%@ include file="_aside.jsp"%>
    <section class="write">
        <nav>
            <h3>문의하기 답변</h3>
            <p>
                HOME > 고객센터 > <strong>문의하기</strong>
            </p>
        </nav>
        <article>
            <form action="${ctxPath }/admin/cs/qna/answer.do" method="post">
                <input type="hidden"  value="${list.menu1 }" id="menu1" name="menu1"></input>
                <input type="hidden"  value="${list.menu2 }" id="menu2" name="menu2" ></input>
                <input type="hidden"  value="${list.cNo}" id="cNo" name="cNo" ></input> 
                <table>
                    <tr>
                        <td id="type">유형</td>
                        <td><div>${list.menu1 }-${list.menu2 }</div></td>
                    </tr>
                    <tr>
                        <td>제목</td>
                        <td><input type="text" name="title" readonly value="${list.title }"></td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td>
                            <textarea name="content" readonly>${list.content}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>답변하기</td>
                        <c:choose>
                        <c:when test="${list.comment  eq 0}">
	                        <td>
	                            <textarea name="reply" required placeholder="답변을 입력하시오."></textarea>
	                        </td>
                        </c:when>
                        <c:otherwise>
	                        <td>
	                            <textarea name="reply" value="${list.content }" readonly ></textarea>
	                        </td>
                        </c:otherwise>
                        </c:choose>
                    </tr>
                </table>
                <div class="btnGroupQna">
                    <a href="${ctxPath}/admin/cs/qna/delete.do?menu1=${list.menu1}&menu2=${list.menu2}&cNo=${list.cNo}" id="delete_button" data-cno="${list.cNo }">삭제하기</a>
                    <a href="${ctxPath}/admin/cs/qna/list.do?menu1=${list.menu1}&menu2=${list.menu2}" >목록으로</a>
                    <input type="submit" value="답변하기" id="reply_button">
                </div>
            </form>
        </article>
    </section>
</main>
<script>

	$(function(){
		
		$('#delete_button').click(function(e){
			
			const cNo = $(this).data('cno');
			const menu1 =$('#menu1').val();
			const menu2 =$('#menu2').val();
			console.log("cNo : "+cNo);
			console.log("menu1 : "+menu1);
			console.log("menu2 : "+menu2);
			if(confirm('정말로 삭제하시겠습니까?')){
				return true;
			}else{
				e.preventDefault();
				return false;
			}
			
		});//click end
		
		
	});//end
	
</script>
<%@ include file="_footer.jsp"%>

