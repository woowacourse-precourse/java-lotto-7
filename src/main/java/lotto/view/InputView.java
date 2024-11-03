package lotto.view;

import lotto.util.ValidatorUtils;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String INPUT_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String DIVIDER = ",";

    public static int inputBudget() {
        System.out.println(INPUT_BUDGET_MESSAGE);
        return scanInt(readLine().trim());
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return scanLottoNumbers(readLine());
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return scanLottoNumber(readLine().trim());
    }

    private static List<Integer> scanLottoNumbers(String inputString) {
        isEmpty(inputString);
        return Arrays.asList(inputString.split(DIVIDER)).stream()
                .map(String::trim)
                .map(InputView::scanLottoNumber)
                .toList();
    }

    private static int scanLottoNumber(String inputString) {
        int lottoNumber = scanInt(inputString);
        return ValidatorUtils.isInRange(lottoNumber);
    }

    private static int scanInt(String inputString) {
        isEmpty(inputString);
        return ValidatorUtils.canParseToInt(inputString);
    }

    private static void isEmpty(String inputString) {
        ValidatorUtils.isNotEmpty(inputString);
    }
}