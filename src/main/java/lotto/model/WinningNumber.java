package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {

    private final List<Integer> winningNumberList;

    public WinningNumber(String winningNumberString) {
        validateNotEmpty(winningNumberString);
        String[] winningNumberStringArray = splitWinningNumberString(winningNumberString);
        validateSixNumbers(winningNumberStringArray);
        validateAllNumbersAreIntegers(winningNumberStringArray);
        this.winningNumberList = convertToIntegerList(winningNumberStringArray);
        validateNoDuplicates();
        validateNumberRange();
    }

    private String[] splitWinningNumberString(String winningNumberString) {
        return winningNumberString.split(",");
    }

    private List<Integer> convertToIntegerList(String[] winningNumberStringArray) {
        return Arrays.stream(winningNumberStringArray)
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private void validateAllNumbersAreIntegers(String[] winningNumberStringArray) {
        try {
            for (String s : winningNumberStringArray) {
                Integer.parseInt(s);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자로 입력되어야 합니다.");
        }
    }

    private void validateSixNumbers(String[] winningNumberStringArray) {
        if (winningNumberStringArray.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개로 설정되어야 합니다.");
        }
    }

    private void validateNotEmpty(String winningNumberString) {
        if (winningNumberString.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 빈 값이 들어올 수 없습니다.");
        }
    }

    private void validateNoDuplicates() {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumberList);
        if (uniqueNumbers.size() != winningNumberList.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에는 중복된 숫자가 있을 수 없습니다.");
        }
    }

    private void validateNumberRange() {
        for (Integer number : winningNumberList) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public boolean isContainsNumber(int number) {
        return winningNumberList.contains(number);
    }
}
