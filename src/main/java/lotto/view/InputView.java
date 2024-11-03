package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputView {

    public static int purchase() {
        int amount;
        do {
            amount = getPurchaseAmount();
        } while (!isValidPurchaseAmount(amount));
        System.out.println();
        return amount;
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 올바른 숫자를 입력해 주세요.");
            return -1;
        }
    }

    private static boolean isValidPurchaseAmount(int amount) {
        if (amount < 0 || amount % 1000 != 0) {
            System.out.println("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            return false;
        }
        return true;
    }

    public static List<Integer> winningNumbers() {
        List<Integer> winNumbers;
        do {
            winNumbers = getWinningNumbers();
        } while (winNumbers == null);
        System.out.println();
        return winNumbers;
    }

    private static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            List<Integer> numbers = Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            new Lotto(numbers);
            return numbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static int bonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;
        do {
            bonusNumber = getBonusNumber();
        } while (!isValidBonusNumber(bonusNumber, winningNumbers));
        System.out.println();
        return bonusNumber;
    }

    private static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 올바른 숫자를 입력해 주세요.");
            return -1;
        }
    }

    private static boolean isValidBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        try {
            Lotto winningLotto = new Lotto(winningNumbers);
            if (winningLotto.hasBonusNumber(bonusNumber)) {
                System.out.println("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                return false;
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
