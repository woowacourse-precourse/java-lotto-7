package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final String ERROR_MESSAGE = "[ERROR]";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = inputMoney();
        int lottoCount = purchaseAmount / LOTTO_PRICE;

        // 로또 발행
        List<Lotto> purchasedLottos = issueLottos(purchaseAmount / LOTTO_PRICE);
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
        purchasedLottos.forEach(System.out::println);

        // 당첨 번호 입력
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> number = inputNumber();

        // 보너스 번호 입력
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = inputBonusNumber(number);
    }

    private static int inputMoney() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                int money = Integer.parseInt(Console.readLine());
                validateMoney(money);
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE + " 구입 금액은 1,000원 단위여야 합니다.");
            }
        }
    }

    private static void validateMoney(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Lotto> issueLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    private static List<Integer> inputNumber() {
        while (true) {
            try {
                String input = Console.readLine();
                List<Integer> numbers = parseWinningNumbers(input);
                validateWinningNumbers(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE + " " + e.getMessage());
            }
        }
    }

    private static List<Integer> parseWinningNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해야 합니다.");
        }
    }

    private static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6 || numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static int inputBonusNumber(List<Integer> winningNumber) {
        while (true) {
            try {
                String input = Console.readLine().trim();
                parseBonusNumber(input);
                int bonusNumber = Integer.parseInt(input);
                validateBonusNumber(bonusNumber, winningNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE + " " + e.getMessage());
            }
        }
    }

    private static void parseBonusNumber(String input) {
        if (input.contains(",") || input.trim().contains(" ")) {
            throw new IllegalArgumentException("보너스 번호는 숫자 1개만 입력해야 합니다.");
        }

        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("보너스 번호는 정수여야 합니다.");
        }
    }

    private static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
