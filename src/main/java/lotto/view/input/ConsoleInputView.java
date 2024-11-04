package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.request.PurchaseAmountDTO;
import lotto.dto.request.WinningLottoBonusNumberDTO;
import lotto.dto.request.WinningLottoNumbersDTO;
import lotto.view.input.parser.InputParser;

public class ConsoleInputView implements InputView {
    private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_WINNING_LOTTO_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    @Override
    public PurchaseAmountDTO inputPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT);
        String amountInput = Console.readLine();
        System.out.println();
        return PurchaseAmountDTO.of(
                InputParser.parsePurchaseAmount(amountInput)
        );
    }

    @Override
    public WinningLottoNumbersDTO inputWinningLottoNumbers() {
        System.out.println(REQUEST_WINNING_LOTTO_NUMBERS);
        String lottoNumbersInput = Console.readLine();
        System.out.println();
        return WinningLottoNumbersDTO.of(
                InputParser.parseWinningLottoNumbers(lottoNumbersInput)
        );
    }

    @Override
    public WinningLottoBonusNumberDTO inputWinningLottoBonusNumber() {
        System.out.println(REQUEST_WINNING_LOTTO_BONUS_NUMBER);
        String bonusNumberInput = Console.readLine();
        System.out.println();
        return WinningLottoBonusNumberDTO.of(
                InputParser.parseWinningLottoBonusNumber(bonusNumberInput)
        );
    }
}
