# 권한체크
* HTTP 페이지 요청에 대해서 권한을 검사한다.
* 권한 검사는 체이닝된 필터들로 구성되어 있다.
* `MyPageCheckFilter class` : /mypage 경로에 대해서 권한을 검사한다.
  * `Member.ROLE`이 USER인 경우에 접근할 수 있다.
* `AdminCheckFilter class` : /admin 경로에 대해서 권한을 검사한다.
  * `Member.ROLE`이 Admin인 경우에 접근할 수 있다.