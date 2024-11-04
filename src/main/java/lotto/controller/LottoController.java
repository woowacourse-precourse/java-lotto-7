package lotto.controller;

import java.util.List;
import lotto.domain.LottoRank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final LottoService lottoService;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoService = new LottoService();
        this.outputView = new OutputView();
    }

    public void run() {

        // 구매 금액 입력
        String purchasePriceInput;
        int purchaseAmount;

        while (true) {
            try {
                purchasePriceInput = inputView.inputPurchasePrice();
                System.out.println();
                purchaseAmount = lottoService.validatePurchasePrice(purchasePriceInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        // 로또 발행
        lottoService.generateLottoNumbers(purchaseAmount);

        outputView.printLottoTicketCountAndNumbers(purchaseAmount, lottoService.getLottoTickets());

        // 당첨 번호 입력
        String winningNumbersInput;

        while (true) {
            try {
                winningNumbersInput = inputView.inputWinningNumbers();
                System.out.println();
                List<Integer> numbers = lottoService.validateWinningNumbers(winningNumbersInput);
                lottoService.generateWinningLotto(numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        // 보너스 번호 입력
        String bonusNumberInput;
        int bonusNumber;

        while (true) {
            try {
                bonusNumberInput = inputView.inputBonusNumber();
                System.out.println();
                bonusNumber = lottoService.validateBonusNumber(bonusNumberInput);
                lottoService.saveBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        // 당첨 통계
        lottoService.calculateWinningNumbers();

        // 당첨 통계 결과 출력
        for (LottoRank value : LottoRank.values()) {
            int matchedCount = lottoService.getMatchedCount(value);
            if (value == LottoRank.SECOND) {
                outputView.printLottoResultWithBonusNumber(value.getMatchCount(),
                        value.getFormattedPrize(),
                        matchedCount);
                continue;
            }
            outputView.printLottoResultWithoutBonusNumber(value.getMatchCount(),
                    value.getFormattedPrize(),
                    matchedCount);
        }
    }

}
