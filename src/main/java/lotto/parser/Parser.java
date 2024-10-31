package lotto.parser;

import java.util.Arrays;
import java.util.List;
import lotto.validator.Validator;

public class Parser {
    private final Validator validator;

    public Parser() {
        this.validator = new Validator();
    }

    public int parsePayment(String inputPayment) {
        int payment;

        try {
            payment = Integer.parseInt(inputPayment);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주십시오.");
        }

        validator.validatePayment(payment);

        return payment;
    }

    public List<Integer> parseWinningNumbers(String inputWinningNumbers) {
        String[] rawWinningNumbers = inputWinningNumbers.split(",");

        List<Integer> winningNumbers;

        try {
            winningNumbers = Arrays.stream(rawWinningNumbers)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주십시오.");
        }

        validator.validateWinningNumbers(winningNumbers);

        return winningNumbers;
    }

    public int parseBonus(String inputBonus) {

        int bonus;
        try {
            bonus = Integer.parseInt(inputBonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주십시오.");
        }

        validator.validateLottoNumber(bonus);

        return bonus;
    }
}
