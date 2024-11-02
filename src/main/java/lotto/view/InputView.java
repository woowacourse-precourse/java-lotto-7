package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.dto.request.LottoAmountRequest;
import lotto.dto.response.LottoesResponse;
import lotto.util.BonusNumberValidator;
import lotto.util.Container;
import lotto.util.LottoAmountValidator;
import lotto.util.WinningNumberParser;

import java.util.List;

public class InputView {

    private final LottoAmountValidator lottoAmountValidator;
    private final WinningNumberParser winningNumberParser;
    private final BonusNumberValidator bonusNumberValidator;
    private final LottoController lottoController;

    public InputView() {
        this.lottoAmountValidator = Container.getInstance(LottoAmountValidator.class);
        this.winningNumberParser = Container.getInstance(WinningNumberParser.class);
        this.bonusNumberValidator = Container.getInstance(BonusNumberValidator.class);
        this.lottoController = Container.getInstance(LottoController.class);
    }

    public int setLottoPrice() {
        String price = Console.readLine();
        return lottoAmountValidator.validate(price);
    }

    public LottoesResponse setLottoes(int amount) {
        return lottoController.makeLottoes(LottoAmountRequest.from(amount));
    }

    public List<Integer> setWinningNumbers() {
        String numbers = Console.readLine();
        return winningNumberParser.parseWinningNumbers(numbers);
    }

    public int setBonusNumber() {
        String bonusNumber = Console.readLine();
        return bonusNumberValidator.validate(bonusNumber);
    }
}