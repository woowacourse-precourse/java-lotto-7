# java-lotto-precourse
## 프리코스 3주차 : 로또
### 1. 기능 구현 목록
* view package
  * 입력
    * 로또 구입 금액 입력받는 기능 [O]
    * 당첨 번호 입력받는 기능(쉼표 기준) [O]
    * 보너스 번호 입력받는 기능 [O]
  
  * 출력
    * 로또 수량 및 번호 출력하는 기능(오름차순 출력) [O]
    * 당첨 내역 출력하는 기능
    * 수익률 출력하는 기능
    * 에러 출력 기능 [O]
  
* model package
  * 처리 로직
    * 로또 구매 수량만큼 로또 생성 [O]
    * 로또 당 랜덤한 숫자를 생성하는 기능 [O]
    * 당첨번호와 일치하는 개수 계산하는 기능 [O]
    * 로또에서 당첨된 등수를 계산하는 기능
    * 로또에서 당첨된 금액을 계산하는 기능
    * 수익률을 계산하는 기능
  
  
* controller package
  * 실행 로직
    * 로또 프로그램 실행 기능 [O]

  * 예외 처리
    * 구입 금액 단위 예외 처리 [O]
    * 당첨 금액 중복 시 예외 처리 [O]
    * 당첨 번호 개수 예외 처리 [O]
    * 보너스 번호와 당첨 번호 중복 시 예외 처리 [O]
  

* 요구사항
  * indent(인덴트, 들여쓰기)2까지만 허용
    * while문 안에 if문이 있으면 들여쓰기는 2이다.
  * 3항 연산자 금지
  * 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현
  * else 예약어 금지(switch/case 금지)
  * Java Enum 적용하여 구현
  * 구현한 기능에 대한 단위 테스트 작성
  * 문자열, 숫자 값 하드 코딩 금지(static final로 상수화)
  * 상수, 멤버 변수, 생성자 메서드 순으로 작성
  * 변수명에서 자료형 금지
  * 하나의 메서드는 하나의 기능만 담당
    
   