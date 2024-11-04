package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {

    private final List<Integer> winningNumberList;

    public WinningNumber(String winningNumberString) {
        validateNotEmpty(winningNumberString); // 빈 값 검사
        String[] winningNumberStringArray = splitWinningNumberString(winningNumberString); // 당첨번호 문자열 배열로 변환
        validateSixNumbers(winningNumberStringArray); // 당첨번호가 6개인지 검사
        validateAllNumbersAreIntegers(winningNumberStringArray); // 당첨번호가 모두 정수인지 검사
        this.winningNumberList = convertToIntegerList(winningNumberStringArray); // 문자열 배열을 정수 리스트로 변환
        validateNoDuplicates(); // 중복 검사
        validateNumberRange(); // 숫자 범위 검사
    }
    private String[] splitWinningNumberString(String winningNumberString) {
        return winningNumberString.split(","); // 당첨번호 문자열 ","로 분리해 문자열 배열로 변환
    }

    private List<Integer> convertToIntegerList(String[] winningNumberStringArray) {
        return Arrays.stream(winningNumberStringArray) // 당첨번호 문자열 배열을 숫자 리스트로 변환
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
}