package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoInputView {
    private final LottoInputValidator lottoInputValidator;
    private final LottoInputParser lottoInputParser;

    public LottoInputView(LottoInputValidator lottoInputValidator, LottoInputParser lottoInputParser) {
        this.lottoInputValidator = lottoInputValidator;
        this.lottoInputParser = lottoInputParser;
    }

    public int readLottoPurchasePrice() {
        String lottoPurchasePrice = readInput();
        lottoInputValidator.validateLottoPurchasePrice(lottoPurchasePrice);
        return lottoInputParser.parseInt(lottoPurchasePrice);
    }

    public List<Integer> readLottoWinningNumbers() {
        String winningNumbers = readInput();
        lottoInputValidator.validateLottoWinningNumbers(winningNumbers);
        return lottoInputParser.parseNumbers(winningNumbers);
    }

    public int readLottoBonusNumber() {
        String bonusNumber = readInput();
        lottoInputValidator.validateLottoBonusNumber(bonusNumber);
        return lottoInputParser.parseInt(bonusNumber);
    }

    private String readInput() {
        return Console.readLine();
    }


}
