package lotto;

import java.util.List;
import model.Status;
import utils.Converter;
import utils.LottoFactory;
import utils.Parser;
import validator.Validator;
import view.InputView;
import view.OutputView;

public class LottoController {

    public void setProgram() {
        Status status = new Status(initialMoneyController());
        status.setLottos(LottoFactory.generateLotto(status.getLottoCount()));
        OutputView.printPurchasingLottos(status.getLottoCount(), status.getLottos());

        status.setWinningNumbers(winningNumbersController());
        status.setBonusNumber(bonusWinningNumberController(status));
        OutputView.printLottoRankCount(status.calculationResult(), status.getEarnRate());
    }

    private Integer initialMoneyController() {
        try {
            String initialInput = InputView.inputInitialMoney();
            Validator.validateInitialMoney(initialInput);
            return Integer.parseInt(initialInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }

        return initialMoneyController();
    }

    private List<Integer> winningNumbersController() {
        try {
            String originalInput = InputView.inputWinningNumbers();
            List<String> parsedInput = Parser.parsing(originalInput);
            Validator.validateWinningNumbers(parsedInput);
            List<Integer> numbers = Converter.convertStringToNumber(parsedInput);
            Validator.validateLottoNumbers(numbers);
            return numbers;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }

        return winningNumbersController();
    }


    private Integer bonusWinningNumberController(Status status) {
        try {
            String bonusInput = InputView.inputBonusWinningNumber();
            Validator.validateBonusNumber(bonusInput, status);
            return Integer.parseInt(bonusInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }

        return bonusWinningNumberController(status);
    }
}
