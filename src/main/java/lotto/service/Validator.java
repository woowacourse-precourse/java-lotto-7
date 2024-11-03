package lotto.service;

public class Validator {
    public void validateEmptyInput(String input) {
        if(input.isEmpty()) {
            throw new IllegalArgumentException(
                "[ERROR] 아무것도 입력하지 않았습니다. 다시 입력해주세요."
            );
        }
    }

    public void validateNegativeInput(int input) {
        if(input <= 0) {
            throw new IllegalArgumentException(
                "[ERROR] 0 또는 음수룰 입력할 수 없습니다 : " + input
            );
        }
    }

    public int validateNumericInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(
                "[ERROR] 숫자 외 다른 문자가 입력되었습니다. 다시 입력해주세요."
            );
        }
    }

    public void validateThousandUnitInput(int money) {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException(
                "[ERROR] 지불 금액은 1000원 단위로 입력할 수 있습니다. 다시 입력해주세요."
            );
        }
    }

    public void handleInvalidCharacterInNumber() {
        throw new IllegalArgumentException(
            "[ERROR] 숫자, 쉼표(,) 외 다른 문자가 입력되었습니다."
        );
    }

    public void handleEmptyInputInNumbers() {
        throw new IllegalArgumentException(
            "[ERROR] 입력되지 않은 번호가 있습니다."
        );
    }

    public void validateNumberCount(int size) {
        if (size != 6) {
            throw new IllegalArgumentException(
                "[ERROR] 로또 번호는 6개여야 합니다." + size
            );
        }
    }

    public void validateNumberInRange(int number) {
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException(
                "[ERROR] 1~45 사이의 숫자만 입력해주세요 : " + number
            );
        }
    }
}
