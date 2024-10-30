package lotto.view.input.validator;

import lotto.view.input.domain.RegexPattern;

public class InputValidator {
    public static void moneyValidate(String input) {
        if (!RegexPattern.NUMBER_REGEX.match(input)) throw new IllegalArgumentException("[ERROR] 형식에 맞지 않는 입력값 양의 정수만 입력해주세요");
    }
    public static void bonusNumberValidate(String input) {
        if (!RegexPattern.NUMBER_REGEX.match(input)) throw new IllegalArgumentException("[ERROR] 형식에 맞지 않는 입력값 양의 정수만 입력해주세요");
    }
    public static void winningLottoValidate(String input) {
        if (!RegexPattern.LOTTO_REGEX.match(input)) throw new IllegalArgumentException("[ERROR] 형식에 맞지 않는 입력값 ex)1,2,3,4,5,6 형식으로 입력해주세요");
    }
}
