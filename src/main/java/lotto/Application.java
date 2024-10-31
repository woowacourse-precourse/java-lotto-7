package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static void main(String[] args) {
        try {
            int money = purchaseMoney();
            validatePurchaseAmount(money);

            List<Lotto> lottos = generateLottos(money / LOTTO_PRICE);
            printPurchasedLottos(lottos);

            WinningLotto winningLotto = inputWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int purchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private static void validatePurchaseAmount(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다.");
        }

        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    private static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
        System.out.println();
    }

    private static WinningLotto inputWinningNumbers() {
        List<Integer> winningNumbers = inputAndParseWinningNumbers();
        int bonusNumber = inputAndParseBonusNumber();
        return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
    }

    private static List<Integer> inputAndParseWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력 가능합니다.");
        }
    }

    private static int inputAndParseBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        }
    }
}
