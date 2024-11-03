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
        String userInput = input.printPurchaseAmountInputMessage();
        LottoPurchaseResponse purchaseResponse = controller.saveLottoAmountInput(userInput);
        output.printPurchaseLotto(purchaseResponse);

        //당첨 번호 입력 및 저장
        userInput = input.printWinningNumberInputMessage();
        WinningNumberSaveResponse winningNumberSaveResponse = controller.saveLottoWinningNumberInput(userInput);

        //key값 저장
        int index = winningNumberSaveResponse.winningNumberIndex();

        //보너스 번호 입력 및 저장
        userInput = input.printBonusNumberInputMessage();
        controller.saveBonusNumber(new BonusNumberSaveRequest(index, userInput));

        //당첨 통계 계산
        PrizeResultResponse prizeResult = controller.getPrizeResult(index);
    }

}
