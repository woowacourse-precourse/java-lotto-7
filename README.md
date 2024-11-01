# 📘 README 구현 체크 리스트

# ✅ FeedBack 체크 리스트

## 1️⃣ 가독성

- [ ]  작명의 의미 전달력
- [ ]  의미 있는 주석 달기
- [ ]  코드 포맷팅  IntelliJ IDEA: ⌥⌘L
- [ ]  커밋 메시지의 feedback 적용하기 (구문 형태, 제목과 내용)
- [x]  EOF 세팅
- [ ]  값 객체는 VO로 분류
- [ ]  요약 설명은 Comment에 ReadMe는 꼼꼼히하고 상시 업데이트
- [ ]  구현순서를 깔끔하게 하였는가

## 2️⃣ 코딩 습관

- [ ]  싱글톤을 적용하기
- [ ]  Stream 적극 활용
- [ ]  Interface 적극 사용
- [ ]  근거 있는 static 사용
- [ ]  컬렉션 사용 API 적극 사용하기
- [ ]  디버깅 적극 사용

## 3️⃣ 설계 중점 사항

- [ ]  1급 컬렉션 사용
- [ ]  참조로 추적되는 데이터형 getter 지양 → DTO 사용 (record 타입) or 방어적 복사 대안
- [ ]  구현방식에 집중해서 과제 자체에 대한 예외들을 빼먹지 말 것
- [ ]  Enum으로 상수 그룹화 관리
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

IllegalArgumentException()
IllegalStateException()

IOException()
NullPointerException()

LottoNumber 번호 자체에 대한 클래스

- [x]  1-45 범위 제한

Lotto factory 만들어야 할듯

- [x]  인터페이스로 구현

Lotto 1급 컬렉션

- [x]  생성에 대한 부분을 Random 매서드에서 찿음
- [x]  오름차순 정렬

Lottos 만들 것

- [x]  lottoFactory를 통해서 확장성 증가

enum을 통한 에러 코드 관리

- [x]  에러를 인터페이스화
- [x]  로또 번호가 범위를 벗어난 경우 → RangeError
- [x]  로또 길이가 범위를 벗어난 경우 → RangeError
- [x]  전체 constant를 관리하자

NumberCombination 구현

- [x]  abstract 클래스로 숫자 조합을 의미함
- [x]  사용자 답 guess가 상속
- [x]  lotto . 가상속
- [x]  validation 기능 protected로 구현

✅ 

- [x] Lotto에 들어가는 것을 숫자가 아닌 모든 것으로 하기 위해 필드를 interface화 해보자 
- [ ] validator 과 추가 입력 객체도 interface 로 해주어야해...

입력의 그 부분부터 다시 시작 조심하세요

같은 숫자의 로또가 뽑히면 손해잖아..


interface를 적극 활용

-> InputManager needs refactoring 함수가 너무 길어요
-> Output 가격을 좀 더 잘 출력할 수 있는 부분 refactoring 대상.
-> (6,1) 케이스가 잘못 나올 텐데 그 부분을 고칠 필요가 있어요
