<div align=center>

  ![파티퀘스트 로고](https://github.com/bllor/Project2023/assets/136154061/40df2242-f521-40b4-b8e5-6a67b0289f22)

</div>

<h1> PARTY_QUEST</h1><br>
개발자 스터디 모임 커뮤니티 웹사이트


<br>
<h1> ⏱ 프로젝트 기간</h1><br>
23.11.01~23.12.08(28일 224시간)

<br>
<h1>👫 멤버소개</h1><br>

|이름|직책|역할|
|:------|:------|:------|
|이동한|팀장|회원가입, 로그인, 약관안내, 메인 페이지, 스터디 목록, 검색 기능, 데이터베이스 설계, 개발 보고서 작성, 발표|
|최동일|팀원|스터디 신청, 스터디 참여자 목록, 알림 기능, 승인제 스터디 대기명단 기능, 개발 보고서 작성|
|박경진|팀원|스터디 보기, 스터디 수정, 스터디 삭제, 커뮤니티, 개발 보고서 작성|
|이현정|팀원|스터디 모임 생성, 좋아요 기능, 유효성 검증, 이메일 인증, CS(고객센터) 목록 출력 및 페이징,<br> 와이어 프레임 제작, 개발 보고서 작성, 발표 PPT 제작|
<br>
<h1>🌟프로젝트 메인 페이지 소개</h1><br>

![파티퀘스트 메인 화면](https://github.com/Phoenix-Argo/partyquest/assets/136154061/92938a4c-f031-4c6f-a77c-8f3ae325dca7)

<br>
<h1> 🎱프로젝트 결과</h1><br>

-국비 팀프로젝트 1위<br>
-[PARTY_QUEST_결과보고서](https://github.com/Phoenix-Argo/partyquest/files/13626327/PARTY_QUEST_.pdf): 개발한 서비스의 결과 보고서 입니다.<br>
-[PARTY_QUEST_발표PPT](https://github.com/Phoenix-Argo/partyquest/files/13626330/party_quest_PPT.pdf): 개발한 서비스의 발표 보고서 입니다.

<br>
<h1> 🌝본인 주요 개발 기능</h1><br>

**1. 스터디 신청**<br>

1)스터디는 승인제 방식과 선착순 방식으로 나뉘며, 선착순 스터디를 신청할 경우 바로 참여가 가능하고,<br> 
  승인제 스터디일 경우 대기 명단으로 이동.<br>

2)본인이 생성한 스터디, 이미 신청한 스터디일 경우 신청이 되지 않음.<br>

3)스터디 대기 명단에 있을 경우, 참여 승인 또는 거절을 할 경우 상태가 변경되며 해당 유저에게 알림<br>
<br>
**2.마이 스터디**<br>

1)나와 관련된 모든 스터디 조회<br>

 (내가 만든 스터디, 내가 참여한 스터디, 좋아요한 스터디, 대기 중인 스터디, 거절된 스터디)<br>

2)스터디 참여인원 보기<br>
<br>
**3.나의 알림**<br>

1)스터디 대기 명단에서 승낙 또는 거절되는 경우 알림 발생.<br>

2)읽지 않은 알림이 존재할 경우, 알림 글씨 색 변경 및 편지 이모지로 알림 유무 확인.<br>

<br>
<h1> 🖥개발 환경</h1><br>

**OS**: Window10<br>
**Browser** : Chrome<br>
**Language(Server)** : Java 17,Spring boot 3.1.4, Spring Security, Spring Data JPA etc<br>
**Language(Client)** : Vue.js 3.0.0, HTML5, CSS3, JavaScript Es6, jQuery etc<br>
**Library** : <br>
jackson-core:2.15.3<br> 
querydsl-core:5.0.0 <br>
jjwt-api:0.11.5<br>
spring-boot-startersecurity: 3.1.5<br>
spring-bootstarter-validation:3.1.5 <br>
mysql-connector-j <br>
ckeditor5-vue:5.1.0<br>
jwt-decode:4.0.0<br>
pinia:2.1.7<br>
etc<br>

**DBMS** : MySQL, H2<br>
**Tool** :<br> Eclipse IDE 2022-06(4.x.x)<br> IntelliJ IDEA Community Edition<br>
2023.2.2 HeidSQL 12.x <br>Git 2.x.x <br>Github<br> Jira<br> Figma

<h1>프로젝트를 하면서 느낀 점</h1>

**1.TDD 개발**

이번 프로젝트에서는 test기반으로 API를 만들었는데 , 유닛 테스트 없이 진행했던 프로젝트들 보다 더 효율성이 좋았던 것 같습니다.<br> 
유닛 테스트를 하지 않을 경우, 프로젝트를 재시작하고 해당 API를 사용하는 화면에 갸아지 내가 보낸 정보가 정확한지 확인할 수 있었는데,<br> 이것은 시간이 많이 소요됩니다.<br>
하지만 유닛테스트를 통해서 불필요하게 소비되는 시간들을 절약할 수 있어서 더 효율적으로 개발을 할 수 있게 되었습니다.</br>
<br>
**2.알림 기능**

프로젝트 발표 리허설을 하던 중 학원 수강생에게 스터디에 승인될 경우 어떻게 알게 되나요? 라는 질문을 받았습니다.<br>

알림 기능이 따로 없었기 때문에 없다고 얘기를 한 후, 발표 리허설이 끝난 후 다대다 매핑 테이블을 이용하여 알림 기능을 구현하였습니다.<br>

알림이 많이 발생할 경우 webflux가 spring mvc보다 효율적으로 처리할 수 있어서, 현재 webflux를 도입하기 위해서 공부를 하고 있으며,<br> 추후 개발을 통해서 webflux를 도입할 예정입니다.


