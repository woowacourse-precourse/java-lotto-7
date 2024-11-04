package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.validator.InputBonusNumberValidator;
import lotto.validator.InputPurchaseAmountValidator;
import lotto.validator.InputWinningLottoValidatior;

public class InputView {
    private final InputPurchaseAmountValidator inputPurchaseAmountValidator = new InputPurchaseAmountValidator();
    private final InputWinningLottoValidatior inputWinningLottoValidatior = new InputWinningLottoValidatior();
    private final InputBonusNumberValidator inputBonusNumberValidator = new InputBonusNumberValidator();

    public String inputPurchaseAmount() {
        String input = Console.readLine();
        inputPurchaseAmountValidator.validate(input);
        return input;
    }

    public Lotto inputWinningLottoNumbers() {
        String input = Console.readLine();
        inputWinningLottoValidatior.isValidBeforeParsing(input);
        return convertInputIntoLotto(input);
    }

    public int bonusWinningLottoNumber() {
        String input = Console.readLine();
        inputBonusNumberValidator.validateBeforeParsing(input);
        int bonusNumber = Integer.parseInt(input);
        inputBonusNumberValidator.validateAfterParsing(bonusNumber);
        Console.close();
        return bonusNumber;
    }

    private Lotto convertInputIntoLotto(String input) {
        List<Integer> winningLottoNumbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(inputWinningLottoValidatior::isValidAfterParsing)
                .map(Integer::parseInt)
                .toList();
        return new Lotto(winningLottoNumbers);
    }
}
