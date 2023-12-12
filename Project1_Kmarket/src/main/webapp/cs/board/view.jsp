<%@ page  contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file ="../_header.jsp" %>
<jsp:include page="./_aside${dto.cate}.jsp" />
                        <nav>
                            <h2 class="title"><span>${dto.cate eq 'faq'?'Q.':''}</span>${dto.title }</h2>
	                         <c:choose>   
	                            <c:when test="${dto.cate eq 'qna' }">
	                            <p>${dto.writer }</p>
	                            <p>${dto.rdate}</p>
	                            </c:when>
	                         </c:choose>   
                        </nav>
                        <div class="content">
                            <p>
								${dto.content}
                              </p>
                              
                        </div>
                        <a href="./list.do?cate=${dto.cate}&menu1=${dto.menu1}" class="btnList">목록보기</a>
                    </article>   
                </section> 
            </div>
        </section>
<%@include file ="../_footer.jsp" %>