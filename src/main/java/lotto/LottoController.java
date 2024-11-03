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
        Status status = new Status(inputMoneyController());
        status.setLottos(LottoFactory.generateLotto(status.getLottoCount()));
        OutputView.printLottoPurchasing(status.getLottoCount(), status.getLottos());
        status.setWinningNumbers(winningNumbersController());
        status.setBonusNumber(bonusWinningNumberController(status));
        OutputView.printLottoRankCount(status.calculationResult(), status.getEarnRate());
    }

    private Integer inputMoneyController() {
        try {
            String originalInput = InputView.inputPurchaseMoney();
            Validator.validateMoney(originalInput);
            return Integer.parseInt(originalInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return inputMoneyController();
    }

    private List<Integer> winningNumbersController() {
        try {
            String originalInput = InputView.inputWinningNumbers();
            List<String> parsedInput = Parser.parsing(originalInput);
            Validator.validateWinningGroup(parsedInput);
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
            String originalInput = InputView.inputBonusWinningNumber();
            Validator.validateBonusNumber(originalInput, status);
            return Integer.parseInt(originalInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return bonusWinningNumberController(status);
    }
}
