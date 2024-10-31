package lotto;

import java.util.regex.Pattern;

public class LottoValidator {

    private final Pattern LOTTO_PATTERN =
            Pattern.compile("^(\\d{1,2})(,(\\d{1,2})){5}$");

    public boolean isValidLotto(String input) {
        if (!LOTTO_PATTERN.matcher(input).matches()) {
            return false;
        }

        String[] numbers = input.split(",");
        for (String num : numbers) {
            int value = Integer.parseInt(num);
            if (value < 1 || value > 45) {
                return false;
            }
        }
        return true;
    }

}

