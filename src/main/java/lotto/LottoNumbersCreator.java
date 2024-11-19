package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbersCreator {
    private static final String splitDivider = ",";

    public static List<Integer> createRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoInfo.FIRST_NUMBER.getInfo(), LottoInfo.LAST_NUMBER.getInfo(),
                LottoInfo.NUMBER_COUNT.getInfo());
    }

    public static List<Integer> createWinningNumbers(String input) {
        validateNotStartEndWithComma(input);
        return createNumberListByInput(input);
    }

    public static void validateNotStartEndWithComma(String input) {
        if (input.startsWith(splitDivider) || input.endsWith(splitDivider)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_INPUT_COMMA_ERROR.getMessage());
        }
    }

    public static List<Integer> createNumberListByInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split(splitDivider)) {
            numbers.add(CommonValidation.convertStringToInt(number));
        }
        return numbers;
    }
}
