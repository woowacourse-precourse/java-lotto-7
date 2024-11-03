package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoValidator {

    public static void validatePurchaseAmount(String input) {
        int amount = parsePositiveInteger(input);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }


    private static int parsePositiveInteger(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number <= 0) {
                throw new IllegalArgumentException("[ERROR] 양수를 입력해야 합니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }

    }

}
