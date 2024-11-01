# 📘  설계에 대한 설명 

# ✅ FeedBack 체크 리스트

## 1️⃣ 가독성

- [ ]  작명의 의미 전달력
- [ ]  의미 있는 주석 달기
- [ ]  코드 포맷팅  IntelliJ IDEA: ⌥⌘L
- [x]  커밋 메시지의 feedback 적용하기 (구문 형태, 제목과 내용)
- [x]  EOF 세팅
- [x]  값 객체는 VO로 분류 (하나 뿐이어서 디렉토리 생성 생략)
- [ ]  요약 설명은 Comment에 ReadMe는 꼼꼼히하고 상시 업데이트
- [ ]  구현순서를 깔끔하게 하였는가

## 2️⃣ 코딩 습관

- [ ]  싱글톤을 적용하기
- [ ]  Stream 적극 활용
- [x]  Interface 적극 사용
- [x]  근거 있는 static 사용
- [x]  컬렉션 사용 API 적극 사용하기
- [x]  디버깅 적극 사용
- [ ]  안쓰는 Importation 삭제

## 3️⃣ 설계 중점 사항

- [x]  1급 컬렉션 사용
- [x]  참조로 추적되는 데이터형 getter 지양 → DTO 사용 (record 타입) or 방어적 복사 대안
- [ ]  구현방식에 집중해서 과제 자체에 대한 예외들을 빼먹지 말 것
- [x]  Enum으로 상수 그룹화 관리
- [ ]  매서드는 한 가지 일만 처리한다
- [ ]  마지막 프로그래밍 요구 사항 지켰는지 check

## 4️⃣ Test

- [ ]  assertJ 를 사용하여 명확한 단위 테스트 (given, when, then)
- [ ]  test coverage check
- [ ]  테스트에서 Interface를 상속받는 Mock 클래스 사용해보기
- [ ]  테스트 자체에서 매서드를 만들거나 여러 기능을 사용해 중복 테스트 줄이기
- [ ]  2주차 feedback 테스트 매서드 참고 자료 활용
- [ ]  UI(System.out, System.in, Scanner) 로직은 제외한다
---

https://techcourse-storage.s3.ap-northeast-2.amazonaws.com/9b82d8a360c548fcadd14c551dbcbe06

예외적 부분 먼저 설계

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.



---
# ✅ 구현 체크 리스트 (개인 참고용)

Constants

- [x]  Interface를 구현하는 enum들로 그룹화해서 관리한다.

Controller

- [x]  전체 컨트롤러
- [x]  입력값을 처리하는 LottoInputManger를 인터페이스로 구현
- [x]  숫자 로또용 구현체 구현 ( 숫자 입력값만을 알맞게 받도록 구현 , domain 클래스의 validation을 월권하지 않는다)

domain

Lotto라는 것의 Component. 즉, 로또의 구성을 Inteface화 하여 확장성을 높인다

- [x]  Component를 인터페이스화 하고 필수 로직을 넣자
- [x]  이걸 구현하는 숫자 클래스를 만들고 validation 로직 구현 1~45 사이
- [x]  Lotto 는 List<Component> 로  생각한다. 길이에 대한 valiation과 랜덤하게 만들어지는 것과 수동으로 만드는 것을 두개 만든다
- [x]  Lottos는 List<Lotto>이고 내부에 생성되는 로또 숫자는 중복되어선 안된다.
- [x]  Score를 만들어서 score 시스템을 입력받고 그에 맞게 점수를 산출하도록 구현
- [x]  LottoMachine은 Score와 factory를 주입받으면 설정이 완료된다
- [x]  LottoMachine은 로또를 사는 기능이 있고 로또와 Score를 Dto 형태로 외부에 전달한다.
