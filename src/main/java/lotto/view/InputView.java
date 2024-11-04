package lotto.view;

import lotto.Validator;
import lotto.model.Lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final int LOTTO_PRICE = 1000;

    private final Validator validator;

    public InputView(Validator validator) {
        this.validator = validator;
    }

    public int getLottoPrice() {
        while (true) {
            try {
                String input = readLine();
                validator.isValidPrice(input);
                return Integer.parseInt(input) / LOTTO_PRICE;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }

    public String getWinningNumbers() {
        while (true) {
            try {
                String input = readLine();
                validator.isValidLottoNumbers(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }

    public int getBonusLottoNumber(Lotto winningNumbers) {
        while (true) {
            try {
                String input = readLine();
                validator.isValidBonusLottoNumber(input, winningNumbers);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }


}
