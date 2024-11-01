package lotto.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Seller {
    private final String PAY_PATTERN = "^[1-9][0-9]{3,}";

    public void validate(String input) {
        Pattern patternPay = Pattern.compile(PAY_PATTERN);
        Matcher matcherPay = patternPay.matcher(input);

        if (!matcherPay.matches()) {
            reject();
        }

        int money = Integer.parseInt(input);
        if (money % 1000 != 0) {
            reject();
        }
    }

    public void reject() {
        throw new IllegalArgumentException();
    }
}
