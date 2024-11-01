package lotto.model;

import lotto.util.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserLotto {
    private List<Integer> numbers;
    private int bonusNumber;

    public void setNumbers(String inputNumbers) {
        validateInputNotEmpty(inputNumbers);
        this.numbers = convertToList(inputNumbers);
        new Lotto(numbers);
    }

    public void setBonusNumber(String inputBonusNumber) {
        validateInputNotEmpty(inputBonusNumber);
        this.bonusNumber = convertToInt(inputBonusNumber);
        validateBonusNumber(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateInputNotEmpty(String inputNumbers) {
        if (inputNumbers == null || inputNumbers.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 사용자 입력이 비어있습니다.");
        }
    }

    private List<Integer> convertToList(String inputNumbers) {
        try {
            return Arrays.stream(inputNumbers.split(Constants.DELIMITER_COMMA))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호를 숫자로 입력해 주세요.");
        }
    }

    private int convertToInt(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 숫자로 입력해 주세요.");
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber > Constants.MAX_LOTTO_NUMBER || bonusNumber < Constants.MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 1~45사이 정수로 입력해 주세요.");
        }
    }
}

