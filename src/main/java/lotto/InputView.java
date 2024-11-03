package lotto;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.List;

public class InputView {
    public static int getAmountFromUser() {
        OutputView.promptForAmount();
        String input = readLine();

        return StringParser.parseInt(input);
    }

    public static List<Integer> getLottoNumbersFromUser() {
        OutputView.promptForLottoNumbers();
        String input = readLine();

        List<Integer> lottoNumbers = StringParser.parseIntListByComma(input);
        Validator.checkLottoNumbers(lottoNumbers);

        return lottoNumbers;
    }

    public static int getBonusNumberFromUser() {
        OutputView.promptForBonusNumber();
        String input = readLine();

        int bonusNumber = StringParser.parseInt(input);
        Validator.checkLottoNumber(bonusNumber);

        return bonusNumber;
    }
}
