package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public static boolean validatePurchase(String numbers) {
        try {
            if (!(numbers.matches("^[0-9]*$")) ) {
                throw new IllegalArgumentException("[ERROR] 1숫자가 입력되어야 합니다.");
            }
            if (Integer.parseInt(numbers) % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 2금액은 천 원 단위여야 합니다.");
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean validateWinningNumber(String[] numbers) {
        try {
            if (numbers.length != 6) {
                throw new IllegalArgumentException("[ERROR] 3당첨 번호는 6개여야 합니다.");
            }
            if (!checkNumbersRange(numbers)) {
                throw new IllegalArgumentException("[ERROR] 3.1당첨 번호는 1~45 사이 숫자여야 합니다.");
            }
            if (checkDuplicateNumbers(numbers)) {
                throw new IllegalArgumentException("[ERROR] 3.2입력된 당첨 번호가 중복인 숫자가 있습니다.");
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static boolean checkNumbersRange(String[] numbers) {
        for (String number : numbers) {
            if (!(number.matches("^[0-9]*$")) ) {
                throw new IllegalArgumentException("[ERROR] 1숫자가 입력되어야 합니다.");
            }
            if(!(Integer.parseInt(number) >= 1 && Integer.parseInt(number) <= 45)) {
                return false;
            }
        }
        return true;
    }

    // Depth 3
    private static boolean checkDuplicateNumbers(String[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i].equals(numbers[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validateBonus(String[] winningNumbers, String bounsNumber) {
        try {
            if (!(bounsNumber.matches("^[0-9]*$")) ) {
                throw new IllegalArgumentException("[ERROR] 1숫자가 입력되어야 합니다.");
            }
            if (!(Integer.parseInt(bounsNumber) >= 1 && Integer.parseInt(bounsNumber) <= 45)) {
                throw new IllegalArgumentException("[ERROR] 3.1당첨 번호는 1~45 사이 숫자여야 합니다.");
            }
            if(checkDuplicationBonus(winningNumbers, bounsNumber)) {
                throw new IllegalArgumentException("[ERROR] 4당첨 번호에 이미 입력된 숫자입니다.");
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static boolean checkDuplicationBonus(String[] numbers, String input) {
        for (String element : numbers) {
            if (input.equals(element)) {
                return true;
            }
        }
        return false;
    }
}
