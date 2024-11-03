# java-lotto-precourse

기능 목록
=========

1. Constants : 여러 클래스에서 공통으로 쓰이는 상수값을 저장한다. (한 클래스에서만 쓰이는 건 하나의 클래스에 저장)
2. InputView : 입력 안내 메시지를 출력하고 입력을 받아서 Controller에 반환한다.
3. SpendingMoney : 로또 구매 금액을 보관하는 클래스이며, 문자열 입력 값을 받아서 형식 검증 후 객체를 생성한다.
    1. 입력값 검증 조건은 공백, 띄어쓰기 유무, 숫자 아닌 문자 유무, 범위, 티켓 가격 미만, 티켓 가격으로 나눴을 때 잔돈 발생 여부를 검증한다.
4. BoughtLottos : 구매 금액만큼 로또를 생성해서 보관한다. 로또를 갖는 일급 컬렉션이다.
    1. 구매 금액을 매개변수로 받아서 랜덤으로 중복되지 않은 숫자 6개로 로또(Lotto) 객체를 생성해서 컬렉션에 넣는다. 
5. Lotto : 구매한 로또 티켓이다.
6. BasicWinLottoNumbers : 로또 당첨 숫자 6개를 보관한다. 콘솔로부터 숫자 6개를 입력 받아서 객체를 생성한다. 객체를 생성하려면 숫자 6개 입력 문자열을 먼저 검증하며, 형식에 맞지 않은 문자열을 입력한 경우 예외를 호출한다.
7. BonusWinLottoNumber : 기본 당첨 숫자 6개랑 중복되지 않는 숫자 1개이다. 콘솔로부터 숫자 1개를 받아서 객체를 생성한다. 객체를 생성하려면 숫자 1개 입력 문자열을 먼저 검증하며, 형식에 맞지 않은 문자열을 입력한 경우 예외를 호출한다.
8. PrizeGrade : 로또 당첨 등급을 나타낸다. 조건, 상금 등을 저장한다. 당첨 로도 번호(보너스 번호 포함)와 구매한 로또 티켓의 숫자가 몇개 일치하는가를 매개변수로 당첨 상금 등급을 반환하는 역할도 한다.
9. WinLotto : BasicWinLottoNumbers와 BonusWinLottoNumber를 관리 보관한다.
10. CountByGrade : 구매한 로또 티켓 묶음(BoughtLottos 객체)에서 당첨된 등급별 담청 티켓 수를 매핑한 것을 저장한다.
11. LottoBenefitRate : 당첨금 합과 총 구매 금액의 비율을 백분율로 보관한다.
12. LottoResult : 구매한 로또 티켓 당첨 결과, 로또 수익률을 관리 보관한다.
13. LottoController : InputView로부터 입력값을 받아서 주요 모델을 생성하고, LottoService로 전달한다.
14. LottoService : Controller로부터 받은 모델을 가지고 비지니스 로직을 실행하고 결과값을 repository에 저장한다.
15. MemoryRepository : Service로부터 전달받은 값을 저장하고 요청에 따라 반환한다.
16. StringValidator : 여러 클래스에서 쓰이는 문자열 검증기능을 담당한다.
17. AppConfig : Controller, Service, View, Repository의 구현체 의존관계를 설정한다.
18. OutputView : 전달받은 값을 출력한다.
19. ExceptionMessage : 여러 클래스에서 공통으로 쓰이는 예외 메시지를 담았다.