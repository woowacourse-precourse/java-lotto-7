package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        while (true) {
            try {
                int purchaseAmount = inputView.readPurchaseAmount(); // 구입 금액 입력
                List<Lotto> purchasedLottos = lottoService.purchaseLottos(purchaseAmount); // 로또 구매
                outputView.printLottoNumbers(purchasedLottos.size(), purchasedLottos); // 구매한 로또 티켓 출력

                // 당첨 번호와 보너스 번호 입력을 별도의 메서드로 처리
                WinningNumbers winningNumbers = inputWinningNumbers(); // 수정된 부분

                LottoResult result = lottoService.calculateResult(purchasedLottos, winningNumbers); // 당첨 결과 계산
                outputView.printLottoResults(result); // 결과 출력

                double totalProfitRate = lottoService.calculateProfitRate(purchaseAmount, result.getTotalPrize()); // 수익률 계산
                outputView.printTotalProfitRate(totalProfitRate); // 총 수익률 출력

                break; // 성공적으로 처리된 경우 루프 종료
            } catch (IllegalArgumentException | IllegalStateException e) {
                outputView.displayError(e.getMessage()); // 오류 메시지 출력
            }
        }
    }

    private WinningNumbers inputWinningNumbers() {
        while (true) {
            try {
                return inputView.readWinningNumbers(); // 당첨 번호 및 보너스 번호 입력
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage()); // 오류 메시지 출력
                // 필요 시 추가적인 사용자 입력 요청을 고려할 수 있음
            }
        }
    }

}
