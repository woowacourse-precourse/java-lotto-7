package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validation.InputValidation;
import lotto.validation.LottoNumberValidation;

public class InputHandler {
    private final InputValidation inputValidation;
    private final LottoNumberValidation lottoNumberValidation;
    private final InputUtils inputUtils;

    public InputHandler(InputValidation inputValidation, LottoNumberValidation lottoNumberValidation,
                        InputUtils inputUtils) {
        this.inputValidation = inputValidation;
        this.lottoNumberValidation = lottoNumberValidation;
        this.inputUtils = inputUtils;
    }

    public long inputMoney() {
        String stringMoney = Console.readLine();
        inputValidation.moneyValidation(stringMoney);
        return Long.parseLong(stringMoney);
    }

    public int inputBonusNumber() {
        String input = Console.readLine();
        lottoNumberValidation.isNumber(input);
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinningNumbers() {
        String input = Console.readLine();
        List<String> splitInput = inputUtils.splitByComma(input);
        List<Integer> intSplitInput = inputUtils.toIntegerList(splitInput);
        lottoNumberValidation.validate(intSplitInput);
        return intSplitInput;
    }
}
