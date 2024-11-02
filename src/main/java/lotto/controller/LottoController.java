package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionMessage;
import lotto.exception.LottoException;
import lotto.service.LottoService;
import lotto.utils.LottoUtils;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private final Input input = new Input();
    private final Output output = new Output();

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void getLottoAmountInputMessage() {
        input.printPurchaseAmountInputMessage();
    }

    public void saveLottoAmountInput() {
        String input = Console.readLine();

        LottoException.throwIllegalArgumentException(
            ExceptionMessage.NOT_EMPTY_STRINGS, LottoUtils.isBlank(input)
        );

        lottoService.saveLottoPurchase(input);
        output.printPurchaseLotto(lottoService.createLottoNumbers());
    }

    public void getLottoWinningNumberInputMessage() {
        input.printWinningNumberInputMessage();
    }

    public void saveLottoWinningNumberInput() {
        String input = Console.readLine();

        LottoException.throwIllegalArgumentException(
            ExceptionMessage.NOT_EMPTY_STRINGS, LottoUtils.isBlank(input)
        );

        lottoService.saveWinningNumber(input);
    }
}
