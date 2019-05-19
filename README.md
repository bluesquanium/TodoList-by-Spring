# Spring으로 만든 TodoList
 ID : guest

 PW : guest

## 기능 (표시된 것들은 구현 성공)
 - [X] 새로운 TODO(제목과 내용)를 작성할 수 있다.
 - [X] TODO 목록을 볼 수 있다.
 - [X] TODO 항목의 제목과 내용을 수정할 수 있다.
 - [X] TODO 항목을 삭제할 수 있다.
 - [X] 사용자의 선택에 의해 TODO에는 마감 기한을 넣을 수 있다.
 - [X] TODO 항목의 우선순위를 설정 및 조절할 수 있다.
 - [X] TODO 항목에 대한 완료 처리를 할 수 있다.
 - [ ] 마감기한이 지난 TODO에 대해 알림을 노출할 수 있다.
 - [X] 로그인 기능 ( id:guest, pw:guest 를 통해 로그인 가능 )
 - [ ] 회원가입
 - [X] 우선순위 뿐만 아니라 날짜, 완료 여부에 따라 정렬해주는 기능

## 리눅스 설치 및 빌드 방법

아래의 실행 방법으로 성공적으로 Tomcat을 통해 웹에 접속 시, URL, 그리고 로그인 ID와 PW는 아래와 같다.

URL : "localhost:8080/todolist"

[ ID : guest, PW : guest ]



### 1. Tomcat 설치

 - 아래의 링크로 들어가 tomcat 8 버젼, tar.gz 파일을 다운 받습니다.
 
 
    https://tomcat.apache.org/download-80.cgi
    ![install](/image/install.png)
 - tar.gz 파일을 다운로드 받은 디렉토리에서 아래의 명령어를 통해 압축해제 및 폴더 명을 바꿔줍니다.
   - tar -zxvf 파일명 root directory에서 압축을 해제합니다.
   - mv 파일명 tomcat8 디렉토리의 이름을 바꿉니다.
   
### 2. todolist.war 파일 다운로드
 - 해당 깃허브 Repository(TodoList-by-Spring) 의 [WAR 파일](https://github.com/bluesquanium/TodoList-by-Spring/tree/master/WAR%20%ED%8C%8C%EC%9D%BC "WAR 파일") 폴더에서 "todolist.war"파일을 다운로드 받습니다.

### 3. 웹 실행
 - 설치한 Tomcat 폴더 내의 webapps 폴더 안에 todolist.war 파일을 넣어줍니다.
 ![webapps](/image/webapps.jpg)
 - cd 명령어를 통해 Tomcat 폴더 내의 bin 폴더로 이동한 뒤, 아래의 명령어를 통해 Tomcat을 실행시켜 줍니다.
   - sudo ./startup.sh
 ![startup](/image/startup.jpg)
 - 브라우저를 통해 "localhost:8080/todolist" 로 이동하면 웹이 실행됩니다.
 ![login](/image/login.jpg)
 - [ ID : guest, PW : guest ] 를 입력하면 로그인할 수 있습니다.
 ![TodoList](/image/TodoList.jpg)
