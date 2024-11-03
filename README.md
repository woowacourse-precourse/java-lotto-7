# java-lotto-precourse

## 구현 기능 목록
### view
1. InputView
2. OutputView
### util
1. RandomNumbers : 1 - 45 사이에서 6개의 중복되지 않은 랜덤 숫자를 생성, 반환하는 클래스
2. SplitNumbers : 입력받은 당첨 번호에 대한 Split을 담당하는 클래스
3. ValidateNumbers : 로또 번호를 검증하는 클래스
4. LottoConfig : 로또 특징을 가진 enum 클래스
### domain
1. Lotto : 주어진 Lotto 클래스 (domain 으로 이동해서 사용)
2. BonusNumber : 보너스 번호에 대한 클래스
3. PurchaseAmount : 구매 금액에 대한 클래스
4. MyLotto : 구매한 로또에 대한 클래스
5. LottoRanking : 로또 등수에 대한 클래스
6. LottoStatistic : 로또 통계(수익률)에 대한 클래스
7. Ranking : 로또 등수에 따른 정보를 갖고 있는 enum 클래스
### controller
1. LottoController : 로또 게임에 대한 컨트롤러 클래스
### message
1. ErrorMessage : 에러 메세지를 관리하는 enum 클래스 

## 프로그래밍 요구 사항
- [x] indent depth 가 3이 넘지 않도록 구현 => 메서드 분리
- [x] 메서드의 길이가 15라인이 넘어가지 않도록 구현
- [x] 3항 연산자 사용 금지
- [x] else 예약어 사용 금지 => if 에서 값을 return 하는 방식으로 구현
- [x] Java Enum 을 적용하여 프로그램을 구현
- [x] 구현한 기능에 대한 단위 테스트를 작성. 단, UI(System.out, System.in, Scanner) 로직은 제외 => LottoTest를 참고하여 학습하기
- [x] 잘못된 값 입력 경우, IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메세지를 출력 후 그 부분부터 입력을 다시 받는다.
- [Exception]이 아닌 [IllegalArgumentException], [IllegalStateException] 등과 같은 명확한 유형을 처리한다. 

## 고려할 예외 사항
- [x] 구입 금액이 정수가 아닌 경우
- [x] 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우
- [x] 당첨 번호가 1 - 45 사이의 정수가 아닌 경우
- [x] 당첨 번호가 6개가 아닌 경우
- [x] 당첨 번호의 구분자가 쉼표(,)가 아닌 경우 
- [x] 보너스 번호가 (자연수가 아닌 경우 | 1 - 45의 숫자가 아닌 경우 | 당첨 번호와 겹치는 경우)

## 고려사항
- [x] 로또 번호 오름차순으로 정렬하여 보여줘야한다.
- [x] 수익률은 소수점 둘째 자리에서 반올림한다.