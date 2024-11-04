package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Model;
import lotto.controller.util.InputValidatorUtil;
import lotto.validator.AmountValidator;
import lotto.validator.NumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final InputView input;
    private final OutputView output;

    public Controller() {
        input = new InputView();
        output = new OutputView();
    }

    public void run() {
        Model model = init();
        printLottos(model);
        setWinningNumbers(model);
        setBonusNumber(model);
        printResult(model);
    }

    private Model init() {
        String amount = InputValidatorUtil.inputValidate(
                input::readAmount,
                new AmountValidator()
        );
        return new Model(amount);
    }

    private void printLottos(Model model) {
        output.printCount(model.getCount());
        List<Lotto> lottos = model.getLottos();
        for (Lotto lotto : lottos) {
            output.printLotto(lotto.getNumbers());
        }
    }

    private void setWinningNumbers(Model model) {
        String winningNumbers = InputValidatorUtil.inputValidate(
                input::readWinningNumbers,
                new NumberValidator()
        );
        model.initializeWinningNumbers(winningNumbers);
    }

    private void setBonusNumber(Model model) {
        String bonusNumber = InputValidatorUtil.inputValidate(
                input::readBonusNumber,
                new NumberValidator()
        );
        model.appendBonusNumber(bonusNumber);
    }

    private void printResult(Model model) {
        output.printWinningDetail(model.getWinningDetail());
        output.printResult(model.computeRoi());
    }
}
