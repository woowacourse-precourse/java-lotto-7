package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    private static final String DELIMITER = ",";
    public void validateBuyLotto(String amount) {
        int lottoAmount = parseInt(amount);

        if (isValidThousandUnit(lottoAmount)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해주세요.");
        }
    }

    public void validateWinningNumber(String numbers) {
        List<Integer> winningNumbers = separateByDelimiter(numbers);

        checkDuplicates(winningNumbers);
    }

    private boolean isValidThousandUnit(int amount) {
        return (amount < 1000) || (amount % 1000 != 0);
    }

    private void checkDuplicates(List<Integer> winningNumbers) {
        List<Integer> uniqueNumbers = winningNumbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (winningNumbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 중복되지 않게 입력해주세요.");
        }
    }

    /*
     * 구분 기호로 문자열을 분리하는 메소드입니다.
     * List<String>으로 변형하고 각각의 원소 안에 공백이 있는지 체크 합니다.
     * 있다면 에러 발생
     * 없다면 각각의 원소들을 int로 바꿔 반환한다.
    */
    private List<Integer> separateByDelimiter(String numbers) {
        List<String> separatedNumbers = Arrays.stream(
                        numbers.split(DELIMITER))
                .toList();

        isContainingSpaces(separatedNumbers);

        return convertToInteger(separatedNumbers);
    }

    private void isContainingSpaces(List<String> separatedNumbers) {
        for (String number : separatedNumbers) {
            if (number.contains(" ")) {
                throw new IllegalArgumentException("[ERROR] 오직 ,로만 당첨 번호를 구분해서 입력하시고 공백을 포함하지 말아주세요.");
            }
        }
    }

    private List<Integer> convertToInteger(List<String> numbers) {
        for (String number : numbers) {
            parseInt(number);
        }

        return NumberParser.convertToInteger(numbers);
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 문자가 아닌 숫자를 입력해주세요.");
        }
    }

}
