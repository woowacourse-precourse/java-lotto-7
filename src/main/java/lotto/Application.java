package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static List<Lotto> lotteries = new ArrayList<>();

    public static void main(String[] args) {
        String inputMoney = getInputMoney();
        buyLotto(Integer.parseInt(inputMoney));
        getWinningNumber();
        getBonusNumber();
    }

    private static String getInputMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                validateMoney(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateMoney(String money) {
        if (money == null || money.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 필수입니다.");
        }
        try {
            int amount = Integer.parseInt(money);
            if (amount < LOTTO_PRICE || !checkUnitMoney(amount)) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위이며, 1,000원 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력해 주세요.");
        }
    }

    private static boolean checkUnitMoney(int money) {
        return money % LOTTO_PRICE == 0;
    }

    private static void buyLotto(int money) {
        int count = money / LOTTO_PRICE;
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            Lotto lotto = Lotto.create();
            System.out.println(lotto);
            lotteries.add(lotto);
        }
    }

    public static List<Lotto> getLotteries() {
        return new ArrayList<>(lotteries);
    }

    private static Lotto getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        while (true) {
            try {
                validateWinningNumber(input);
                List<Integer> numbers = getWinningNumbers(input);
                Lotto winningLotto = Lotto.WinningLotto(numbers);
                Lotto.setBonusNumber(winningLotto, getBonusNumber());
                return winningLotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> getWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateWinningNumber(String input) {
        validateEmptyWinningNumber(input);
        validateIntegerWinningNumber(input);
        validateRangeWinningNumber(input);
    }

    private static void validateEmptyWinningNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 필수입니다.");
        }
    }

    private static void validateIntegerWinningNumber(String input) {
        String[] numbers = input.split(",");
        for (String number : numbers) {
            try {
                Integer.parseInt(number.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자로 입력해 주세요.");
            }
        }
    }

    private static void validateRangeWinningNumber(String input) {
        String[] numbers = input.split(",");
        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        while (true) {
            try {
                validateBonusNumber(input);
                int bonusNumber = Integer.parseInt(input);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateBonusNumber(String input) {
        validateEmptyBonusNumber(input);
        validateIntegerBonusNumber(input);
        validateRangeBonusNumber(input);
    }

    private static void validateEmptyBonusNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 필수입니다.");
        }
    }

    private static void validateIntegerBonusNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해 주세요.");
        }
    }

    private static void validateRangeBonusNumber(String input) {
        int num = Integer.parseInt(input);
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}