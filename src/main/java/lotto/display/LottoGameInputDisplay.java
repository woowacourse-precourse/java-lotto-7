package lotto.display;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.validator.LottoGameValidator;

public class LottoGameInputDisplay {

    private final LottoGameOutputDisplay outputDisplay;

    public LottoGameInputDisplay(LottoGameOutputDisplay outputDisplay) {
        this.outputDisplay = outputDisplay;
    }

    public int inputMoney() {
        outputDisplay.printGuideMessage("구입금액을 입력해 주세요.");

        while (true) {
            try {
                int money = inputNumber();
                LottoGameValidator.checkMoneyValid(money);

                return money;
            } catch (IllegalArgumentException e) {
                outputDisplay.printErrorMessage(e);
            }
        }
    }

    public List<Integer> inputWinnerNumbers() {
        outputDisplay.printGuideMessageWithNewline("당첨 번호를 입력해 주세요.");

        while (true) {
            try {
                List<Integer> winNumbers = inputNumbers(",");
                LottoGameValidator.checkWinNumbersValid(winNumbers);

                return winNumbers;
            } catch (IllegalArgumentException e) {
                outputDisplay.printErrorMessage(e);
            }
        }
    }

    public int inputBonusNumber(List<Integer> winnerNumbers) {
        outputDisplay.printGuideMessageWithNewline("보너스 번호를 입력해 주세요.");

        while (true) {
            try {
                int bonus = inputNumber();
                LottoGameValidator.checkBonusValid(bonus, winnerNumbers);

                return bonus;
            } catch (IllegalArgumentException e) {
                outputDisplay.printErrorMessage(e);
            }
        }
    }

    private int inputNumber() {
        String rawNumber = Console.readLine();

        LottoGameValidator.checkIsBlank(rawNumber);
        LottoGameValidator.checkIsNumeric(rawNumber);

        return Integer.parseInt(rawNumber);
    }

    private List<Integer> inputNumbers(String separator) {
        String rawNumberMess = Console.readLine();
        LottoGameValidator.checkIsBlank(rawNumberMess);

        List<String> rawNumbers = Arrays.stream(rawNumberMess.split(separator))
                .map(String::strip)
                .toList();

        for (String rawNum : rawNumbers) {
            LottoGameValidator.checkIsNumeric(rawNum);
        }

        return rawNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }
}
