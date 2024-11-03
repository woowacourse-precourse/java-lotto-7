package lotto;

import lotto.config.LottoConfig;
import lotto.controller.LottoController;
import lotto.controller.dto.BonusNumberSaveRequest;
import lotto.controller.dto.LottoPurchaseResponse;
import lotto.controller.dto.PrizeResultResponse;
import lotto.controller.dto.WinningNumberSaveResponse;
import lotto.view.Input;
import lotto.view.Output;

public class LottoApplication {

    private static Input input = new Input();
    private static Output output = new Output();

    private static LottoController controller = LottoConfig.getLottoController();

    public static void run() {

        //lotto 구입, 저장, 출력
        int purchase = input.printPurchaseAmountInputMessage();
        int purchaseIndex = controller.saveLottoAmountInput(purchase);
        LottoPurchaseResponse purchaseResponse = controller.getLottoNumber();
        output.printPurchaseLotto(purchaseResponse);

        //당첨 번호 입력 및 저장
        String userInput = input.printWinningNumberInputMessage();
        WinningNumberSaveResponse winningNumberSaveResponse = controller.saveLottoWinningNumberInput(userInput);

        //key값 저장
        int winningNumberIndex = winningNumberSaveResponse.winningNumberIndex();

        //보너스 번호 입력 및 저장
        int bonusNumber = input.printBonusNumberInputMessage();
        controller.saveBonusNumber(new BonusNumberSaveRequest(winningNumberIndex, bonusNumber));

        //당첨 통계 계산
        PrizeResultResponse prizeResult = controller.getPrizeResult(winningNumberIndex, purchaseIndex);
        output.printStatistics(prizeResult);
    }

}
