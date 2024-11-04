package lotto.controller;

import java.util.List;
import lotto.exception.CustomException;
import lotto.service.LottoService;
import lotto.util.Converter;
import lotto.util.Parser;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    private int handlePurchase() {
        String moneyInput = inputView.inputMoney();
        Validator.validateMoney(moneyInput);
        return Converter.convertStringToInteger(moneyInput);
    }

    private List<Integer> handleWinningNumber() {
        String numbersInput = inputView.inputNumbers();
        List<String> numbers = Parser.parse(numbersInput);
        Validator.validateLottoNums(numbers);
        return Converter.convertStringToIntegerList(numbers);
    }

    private int handleBonusNumber() {
        String bonusNumberInput = inputView.inputBonusNumber();
        Validator.validateBonus(bonusNumberInput);
        return Converter.convertStringToInteger(bonusNumberInput);
    }

    public void startLotto() {
        try {
            int money = handlePurchase();
            lottoService.purchaseLotto(money);
            outputView.printPurchase(lottoService.getPurchasedResult());
            List<Integer> winningNumbers = handleWinningNumber();
            int bonusNumber = handleBonusNumber();
            lottoService.saveWinningLotto(winningNumbers, bonusNumber);
            lottoService.getLottoResult();
            outputView.printLottoResult(lottoService.getLottoResultResponse());
        } catch (CustomException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }


}
