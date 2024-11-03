package lotto.model;

import lotto.model.draw.BonusNumber;
import lotto.model.draw.WinningLotto;
import lotto.model.draw.DrawResult;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.LottoTicketGenerator;
import lotto.model.lotto.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;
// 로또 매니저를 통해서 사용자로 부터 입력받은 값을 도메인과 연결해 서비스 로직을 동작시키고 결과를 만들어냅니다
public class LottoManager {
    // inputview와 outputview, LottoTicketGenerator를 생성자로 DI합니다.
    // lottoTicketGenerator의 경우 생성자로 DI를 해야할 지에 대한 고민이 존재 -> LottoTicketGenerator가 유연하게 다른 Generator로 변경될 가능성이 있는지 모르겠음
    // lottoTicketGenerator와 LottoManager의 결합도가 높아도 상관이 없지 않을까 하는 생각이 들어 리뷰 받아봐야겠음...
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoTicketGenerator lottoTicketGenerator;
    // 필드에 선언된 변수가 너무 많아지고 있지 않을까..? 필드에 선언된 변수를 줄이려면 어떻게 해야할 지 고민해보자
    private PurchaseAmount purchaseAmount;
    private LottoTicket lottoTicket;
    private WinningLotto winningLotto;
    private BonusNumber bonusNumber;
    private DrawResult drawResult;

    public LottoManager(InputView inputView, OutputView outputView, LottoTicketGenerator lottoTicketGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoTicketGenerator = lottoTicketGenerator;
    }
    // 전체적인 로또 로직을 수행
    public void run() {
        buyLottoTicket();
        draw();
        displayDrawStatistics();
    }
    // 구입 금액을 입력받아 해당 금액만큼의 로또가 담긴 로또 티켓을 구매합니다.
    private void buyLottoTicket() {
        purchaseAmount = receivePurchaseAmount();
        lottoTicket = lottoTicketGenerator.generateLottoTicket(purchaseAmount);
        outputView.printLottoTicket(lottoTicket, purchaseAmount.getPurchasableLottoAmount());
    }
    // 당첨 번호와 보너스 번호를 입력 받고 구매한 로또 티켓을 추첨해서 당첨 결과를 생성합니다.
    private void draw() {
        winningLotto = receiveWinningNumbers();
        bonusNumber = receiveBonusNumber();
        drawResult = DrawResult.of(winningLotto, bonusNumber, lottoTicket);
        drawResult.generateDrawResult();
    }
    // 당첨 결과를 기반으로 해당 로또 티켓의 당첨 통계를 계산하고 수익률과 함께 사용자에게 보여줍니다.
    private void displayDrawStatistics() {
        outputView.printDrawResult(drawResult);
        int totalPrizeMoney = drawResult.getTotalPrizeMoney();
        double profitPercentage = purchaseAmount.calculateProfitPercentage(totalPrizeMoney);
        outputView.printProfitPercentage(profitPercentage);
    }
    // 구입 금액을 입력받고 예외 발생 시 해당 부분으로 다시 입력을 받습니다.
    private PurchaseAmount receivePurchaseAmount() {
        while (true) {
            try {
                return PurchaseAmount.from(inputView.enterPurchaseAmount());
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }
    // 당첨 번호를 입력받고 예외 발생 시 해당 부분부터 다시 입력 받습니다.
    private WinningLotto receiveWinningNumbers() {
        while (true) {
            try {
                return WinningLotto.from(inputView.enterWinningNumbers());
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }
    // 보너스 번호를 입력받고 예외 발생 시 해당 부분부터 다시 입력 받습니다.
    private BonusNumber receiveBonusNumber() {
        while (true) {
            try {
                BonusNumber bonusNumber = BonusNumber.from(inputView.enterBonusNumbers());
                bonusNumber.checkDuplicationNumber(winningLotto);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
            }
        }
    }

}
