package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Supplier;

public class InputView {
    public static final String ASK_MONEY_INPUT = "구입금액을 입력해 주세요.";
    public static final String ASK_LOTTO_NUM_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_MONEY_NOT_NUMBER = "[ERROR] 입력하신 금액이 양의 정수가 아닙니다.";
    public static final String INPUT_INVALID_LOTTO_NUMBER = "[ERROR] 올바르지 않은 번호 형식입니다.";

    private final Supplier<String> inputSupplier;

    public InputView() {
        this(Console::readLine);
    }

    public InputView(Supplier<String> inputSupplier) {
        this.inputSupplier = inputSupplier;
    }

    public int lottoMoneyInput() {
        System.out.println(ASK_MONEY_INPUT);
        String rawMoney = inputSupplier.get();
        validateIsNumber(rawMoney);
        return Integer.parseInt(rawMoney);
    }

    public String[] lottoNumberInput() {
        System.out.println(ASK_LOTTO_NUM_INPUT);
        String rawNumbers = inputSupplier.get();
        String[] numbers = rawNumbers.split(",");

        // 각 번호가 숫자인지 확인하고, 그렇지 않으면 예외 발생
        for (String number : numbers) {
            if (!isNumber(number.trim())) {
                throw new IllegalArgumentException(INPUT_INVALID_LOTTO_NUMBER);
            }
        }
        return numbers;
    }

    private void validateIsNumber(String rawValue) {
        try {
            Integer.parseInt(rawValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_MONEY_NOT_NUMBER);
        }
    }

    private boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
