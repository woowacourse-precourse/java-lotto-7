# java-lotto-precourse


### 로또 기능 목록

### 기능 1: 입력 받기
- 기능 1 세부 사항
    - [ ] 구입금액
      -[ ] 빈 문자열, 숫자 변환, 1000 나머지 예외처리
    - [ ] 당첨번호
      - [ ] 빈 문자열, 숫자 변환 예외처리
      - [ ] 로또 번호 클래스 중복 확인 및 6개 확인, 1 - 45 범위 숫자인지 확인
    - [ ] 보너스 번호
      - [ ] 빈 문자열, 숫자 변환 예외처리, 당첨번호 중복 확인
      - [ ] 로또 번호 클래스 중복 확인 및 6개 확인, 1 - 45 범위 숫자인지 확인
    - [ ] 사용자가 잘못된 값을 입력할 경우  "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력 받음.
---
### 기능 2: 결과 출력
- 기능 2 세부사항
    - [ ] 갯수(구입금액 / 1000)  출력
    - [ ] 갯수에 해당하는 복권번호 리스트 출력
    - [ ] 당첨 통계 출력
---
### 기능 3: Lotto 모델 생성
- 기능 3 세부사항
  - [ ] 유효성 검사
    - [ ] 6개의 번호 확인
    - [ ] 중복 확인
    - [ ] 1 - 45 범위 확인
---

### 프로그램 요구사항
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현
- [ ] 3항 연산자 X
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 생성
- [ ] JUnit 5와 AssertJ를 이용하여 단위 테스트를 작성
- [ ] 함수(또는 메서드)의 길이가 15라인 이하 
- [ ] else, switch/case 예약어
- [ ] Java Enum을 적용
- [ ] Lotto 클래스 활용
  - [ ] 필드 추가 X
  - [ ] numbers의 접근 제어자인 private은 변경 X
  - [ ] 추가 메소드 구현 가능