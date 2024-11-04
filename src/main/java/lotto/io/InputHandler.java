package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validation.LottoNumberValidation;
import lotto.validation.MoneyValidation;

public class InputHandler {
    private final MoneyValidation moneyValidation;
    private final LottoNumberValidation lottoNumberValidation;
    private final InputUtils inputUtils;

    public InputHandler(MoneyValidation moneyValidation, LottoNumberValidation lottoNumberValidation,
                        InputUtils inputUtils) {
        this.moneyValidation = moneyValidation;
        this.lottoNumberValidation = lottoNumberValidation;
        this.inputUtils = inputUtils;
    }

    public long inputMoney() {
        String stringMoney = Console.readLine();
        moneyValidation.isNumber(stringMoney);
        return Long.parseLong(stringMoney);
    }

    public int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputWinningNumbers() {
        List<String> splitInput = inputUtils.splitByComma(Console.readLine());
        List<Integer> intSplitInput = inputUtils.toIntegerList(splitInput);
        lottoNumberValidation.duplicateValid(intSplitInput);
        return intSplitInput;
    }
}
