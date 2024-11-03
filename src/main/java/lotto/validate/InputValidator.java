package lotto.validate;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;

    public static int cost(String input) {
        isNull(input);
        endsWithComma(input);
        costIsNumber(input);
        costIsThousandUnit(input);

        return Integer.parseInt(input);
    }

    public static Lotto winningNumber(String input) {
        List<Integer> winningNumbers = new ArrayList<>();

        isNull(input);
        endsWithComma(input);

        for (final String s : input.split(",")) {
            isNumber(s);
            lottoNumberRange(s);
            winningNumbers.add(Integer.parseInt(s));
        }

        return new Lotto(winningNumbers);
    }

    public static int BonusNumber(String input, Lotto lotto) {
        isNull(input);
        isNumber(input);
        lottoNumberRange(input);
        validateBonusNumberNotInWinningNumbers(input, lotto);

        return Integer.parseInt(input);
    }

    private static void endsWithComma(String names) {
        if (names.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 마지막 입력이 구분자입니다.");
        }
    }

    private static void isNull(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 문자를 입력했습니다.");
        }
    }

    private static void costIsNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 금액은 양수여야 합니다.");
        }
    }

    private static void costIsThousandUnit(String input) {
        if (Integer.parseInt(input) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
        }
    }

    private static void isNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 입력은 1이상의 정수여야 합니다.");
        }
    }

    private static void lottoNumberRange(String input) {
        int number = Integer.parseInt(input);

        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 이내여야 합니다.");
        }
    }

    private static void validateBonusNumberNotInWinningNumbers(String input, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        if (lottoNumbers.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호 내에 존재합니다.");
        }
    }

}
