package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Supplier;

public class InputView {
    public static final String ASK_MONEY_INPUT = "구입금액을 입력해 주세요.";
    public static final String ASK_LOTTO_NUM_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String ASK_BONUS_NUM_INPUT = "보너스 번호를 입력해 주세요.";
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
        try {
            if (!validateIsNumber(rawMoney)) {
                throw new IllegalArgumentException(INPUT_MONEY_NOT_NUMBER);
            }
            return Integer.parseInt(rawMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return lottoMoneyInput();  // 입력 재시도
        }
    }

    public String[] lottoNumberInput() {
        System.out.println(ASK_LOTTO_NUM_INPUT);
        String rawNumbers = inputSupplier.get();
        try {
            String[] numbers = rawNumbers.split(",");
            for (String number : numbers) {
                if (!validateIsNumber(number.trim())) {
                    throw new IllegalArgumentException(INPUT_INVALID_LOTTO_NUMBER);
                }
            }
            return numbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return lottoNumberInput();
        }
    }

    public int bonusNumberInput() {
        System.out.println(ASK_BONUS_NUM_INPUT);
        String rawBonusNumber = inputSupplier.get();
        try {
            if (!validateIsNumber(rawBonusNumber)) {
                throw new IllegalArgumentException(INPUT_MONEY_NOT_NUMBER);
            }
            return Integer.parseInt(rawBonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return bonusNumberInput();
        }
    }

    private boolean validateIsNumber(String rawValue) {
        try {
            int amount = Integer.parseInt(rawValue);
            return amount > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
