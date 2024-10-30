# java-lotto-precourse

기능 목록
=========

1. Constants : 여러 클래스에서 공통으로 쓰이는 상수값을 저장한다. (한 클래스에서만 쓰이는 건 하나의 클래스에 저장)
2. InputView : 입력 안내 메시지를 출력하고 입력을 받아서 Controller에 반환한다.
3. SpendingMoney : 로또 구매 금액을 보관하는 클래스이며, 문자열 입력 값을 받아서 형식 검증 후 객체를 생성한다.
4. BoughtLottos : 구매 금액만큼 로또를 생성해서 보관한다. 로또를 갖는 일급 컬력션이다.
5. Lotto : 구매한 로또 티켓이다.
6. BasicWinLottoNumbers : 로또 당첨 숫자 6개를 보관한다.
7. BonusWinLottoNumber : 기본 당첨 숫자 6개랑 중복되지 않는 숫자 1개이다.
8. PrizeGrade : 로또 당첨 등급을 나타낸다. 조건, 상금 등을 저장한다.
9. WinLotto : BasicWinLottoNumbers와 BonusWinLottoNumber를 관리 보관한다.
10. LottoResult : 구매한 로또 티켓 당첨 결과, 로또 수익률을 관리 보관한다.
11. LottoController : InputView로부터 입력값을 받아서 주요 모델을 생성하고, LottoService로 전달한다.
12. LottoService : Controller로부터 받은 모델을 가지고 비지니스 로직을 실행하고 결과값을 repository에 저장한다.
13. MemoryRepository : Service로부터 전달받은 값을 저장하고 요청에 따라 반환한다.
14. StringValidator : 여러 클래스에서 쓰이는 문자열 검증기능을 담당한다.
15. AppConfig : Controller, Service, View, Repository의 구현체 의존관계를 설정한다.
16. OutputView : 전달받은 값을 출력한다.