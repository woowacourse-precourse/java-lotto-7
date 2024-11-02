package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {

        int purchaseAmount = readPurchaseAmount();
        List<Lotto> purchasedLottos = generateLottos(purchaseAmount);

        printPurchasedLottos(purchasedLottos);

        Set<Integer> winningNumbers = readWinningNumbers();


    }

    private static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요");
        int amount = Integer.parseInt(Console.readLine());
        validateAmount(amount);
        return amount;
    }

    private static void validateAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }
    }

    private static List<Lotto> generateLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / LOTTO_PRICE;
        return IntStream.range(0, numberOfLottos)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)
                        .stream().sorted().collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    private static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for(Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static Set<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        Set<Integer> winningNumbers = Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    private static void validateWinningNumbers(Set<Integer> winningNumbers) {
        if (winningNumbers.size() != 6 || winningNumbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 범위 내의 중복되지 않은 숫자 6개여야 합니다.");
        }
    }
}


