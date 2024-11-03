package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class TypeConverter {

    public List<Integer> convertToList(String inputWinningNumbers) {
        validateEmptyString(inputWinningNumbers);

        List<Integer> inputWinningNumbersList = new ArrayList<>();

        for (String number : inputWinningNumbers.split(",")) {
            validateNumberIsInteger(number);
            int winningNumber = Integer.parseInt(number.trim()); // 숫자로 변환
            inputWinningNumbersList.add(winningNumber);
        }

        return inputWinningNumbersList;
    }

    private void validateEmptyString(String inputWinningNumbers) {
        if (inputWinningNumbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력해주세요.");
        }
    }

    private void validateNumberIsInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 유효하지 않은 값이 포함되어 있습니다.");
        }
    }
}
