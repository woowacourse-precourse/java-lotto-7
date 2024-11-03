package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Validator {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String DELIMITER = ",";


    public static void validateSize(List<Integer> inputLottoNumbers) {
        if (inputLottoNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 당첨 번호는 6개여야 합니다.");
        }
    }

    public static void tokenizeInput(String input, List<Integer> inputLottoNumbers) {
        validateDelimiter(input);
        Set<Integer> uniqueNumbers = new HashSet<>();
        StringTokenizer tokenizer = new StringTokenizer(input, DELIMITER);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            validateUnique(uniqueNumbers, token);
            inputLottoNumbers.add(Integer.parseInt(token));
        }
    }

    public static void validateUnique(Set<Integer> uniqueNumbers, String token) {
        int number = Integer.parseInt(token);
        if (!uniqueNumbers.add(number)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 중복된 숫자를 입력했습니다.");
        }
    }

    public static void validateDelimiter(String input) {
        if (!input.contains(DELIMITER)) {
            System.out.println();
            throw new IllegalArgumentException(ERROR_MESSAGE + " 잘못된 구분자를 포함하고 있습니다.");
        }
    }

    public static void validateInput(String money) {
        validateNumber(money);
        validateMoney(money);
    }

    public static void validateNumber(String number) throws IllegalArgumentException {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력이 비어 있습니다.");
        }
        if(!checkInteger(number)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 문자가 포함 됐습니다.");
        }
    }

    public static boolean checkInteger(String input) {
        for(char c : input.toCharArray()) {
            if(!Character.isDigit(c))
                return false;
        }
        return true;
    }

    public static void validateMoney(String money) {
        int amount = Integer.parseInt(money);
        if (amount < 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 금액은 0 이상의 1000 단위여야 합니다.");
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> inputLottoNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 1부터 45 사이여야 합니다.");
        }
        if (inputLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public static void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "당첨 번호에 중복된 숫자가 포함될 수 없습니다.");
            }
        }
    }
}
