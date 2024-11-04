package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.validation.InputValidator;
import lotto.validation.Validation;

public class InputHandler {
    private static final String INPUT_CASH_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";


    public Integer getCash() {
        return getValidateInput(INPUT_CASH_MESSAGE, Validation::validateCash);
    }
    public Lotto getLottoNumber() {
        return getValidateInput(INPUT_LOTTO_NUMBER_MESSAGE, Validation::validateLotto);
    }
    public Integer getBonus() {
        return getValidateInput(INPUT_BONUS_MESSAGE, Validation::validateBonus);
    }

    private <T> T getValidateInput(String message, InputValidator<T> validate) {
        while(true) {
            displayInputMessage(message);
            String input = getInputValue();
            try {
                return validate.validate(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void displayInputMessage(String message) {
        System.out.println(message);
    }
    private String getInputValue() {
        return Console.readLine();
    }
}
