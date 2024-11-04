package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = inputPurchaseAmount();
            LottoMachine.validatePurchaseAmount(purchaseAmount);
            List<Lotto> purchasedLottos = LottoMachine.purchaseLottos(purchaseAmount);
            printPurchasedLottos(purchasedLottos);

            Lotto winningLotto = inputWinningLotto();
            int bonusNumber = inputBonusNumber();

            LottoResult result = new LottoResult(purchasedLottos, winningLotto, bonusNumber);
            result.printResult();
            double yield = result.calculateYield(purchaseAmount);
            System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 금액을 입력해 주세요.");
        }
    }

    private static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private static Lotto inputWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> numbers = parseNumbers(input);
        return new Lotto(numbers);
    }

    private static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        try {
            int bonusNumber = Integer.parseInt(input);
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }

    private static List<Integer> parseNumbers(String input) {
        try {
            return Stream.of(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }
}

