package lotto.service;

import lotto.domain.WinningNumbers;

import java.util.List;

public class Validator {
    public void validateEmptyInput(String input) {
        if(input.isEmpty()) {
            throw new IllegalArgumentException(
                "[ERROR] 아무것도 입력하지 않았습니다. 다시 입력해주세요."
            );
        }
    }

    public void validatePositiveInput(int money) {
        if(money <= 0) {
            throw new IllegalArgumentException(
                "[ERROR] 0 또는 음수룰 입력할 수 없습니다. 다시 입력해주세요."
            );
        }
    }

    public int validateFormatInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(
                "[ERROR] 숫자 외 다른 문자가 입력되었거나 입력 제한 범위를 초과했습니다. 다시 입력해주세요."
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

    public void validateEmptyInputInNumbers(String input) {
        if(input == null) {
            throw new IllegalArgumentException(
                "[ERROR] 입력되지 않은 번호가 있습니다. 리스트를 다시 입력해주세요."
            );
        }
    }

    public void validateNumberCount(int size) {
        if (size != 6) {
            throw new IllegalArgumentException(
                "[ERROR] 로또 번호는 6개여야 합니다. 현재 사이즈 : " + size
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

    public void validateWinningNumberDuplicate(int number, List<Integer> winningNumbers) {
        if(winningNumbers.contains(number)) {
            throw new IllegalArgumentException(
                "[ERROR] 중복된 숫자가 입력되었습니다. 다시 입력해주세요. 중복값 : " + number
            );
        }
    }

    public void validateBonusNumberDuplicate(int number, int winningNumber) {
        if(number == winningNumber) {
            throw new IllegalArgumentException(
                "[ERROR] 이미 당첨 번호로 등록된 숫자입니다. 다시 입력해주세요. 중복값 : " + number
            );
        }
    }
}
