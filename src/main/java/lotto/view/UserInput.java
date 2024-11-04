package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInput {
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int amount = Integer.parseInt(input);

        validatePositiveAmount(amount);
        validatePurchaseAmount(amount);

        return amount;
    }

    public static List<Integer> inputWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = input.split(",");

        List<Integer> winNumbers = new ArrayList<>();

        for (String number : numbers) {
            int num = Integer.parseInt(number);
            validateNumberRange(num);
            winNumbers.add(num);
        }
        validateLottoSize(winNumbers);
        validateDuplicate(winNumbers);

        return winNumbers;
    }

    public static int inputBonusNumber(List<Integer> winNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        validateNumberRange(bonusNumber);

        winNumbers.add(bonusNumber);
        validateDuplicate(winNumbers);

        return bonusNumber;
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private static void validatePositiveAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
    }

    private static void isNumber(String input) {
        if (input.matches("\\d+")) {
            throw new NumberFormatException("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> checkDuplicateNumbers = new HashSet<>(numbers);
        if (checkDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 포함될 수 없습니다.");
        }
    }

    private static void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
