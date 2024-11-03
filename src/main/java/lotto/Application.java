package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        while (true) {
            try {
                runApplication();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void runApplication() {
        int purchaseAmount = readPurchaseAmount();
        Lotto[] userLottos = LottoFactory.createLottos(purchaseAmount);

        System.out.println(purchaseAmount / LOTTO_PRICE + "개를 구매했습니다.");
        for (Lotto lotto : userLottos) {
            System.out.println(lotto.getNumbers());
        }

        WinningNumbers winningNumbers = readWinningNumbers();

        Result result = new Result(userLottos, winningNumbers);
        result.printResult();
    }

    private static int readPurchaseAmount() {
        System.out.println("로또 구입 금액을 입력해 주세요.");
        int amount = parseAmount(Console.readLine());
        validateAmount(amount);
        return amount;
    }

    private static int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }

    private static void validateAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private static WinningNumbers readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        int[] numbers = InputParser.parseNumbers(Console.readLine());

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = parseBonusNumber(Console.readLine());

        return new WinningNumbers(numbers, bonusNumber);
    }

    private static int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }
}

