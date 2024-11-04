package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        int lottoCount = purchaseAmount / 1000;
        List<Lotto> purchasedLottos = Lotto.generateLottos(lottoCount);
        printPurchasedLottos(purchasedLottos);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        printResults(purchasedLottos, winningNumbers, bonusNumber);
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.");
        }
        return amount;
    }

    private static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    private static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] splitInput = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : splitInput) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        return winningNumbers;
    }

    private static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonusNumber;
    }

    private static void printResults(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] results = new int[5]; // 인덱스 0: 3개 일치, 1: 4개 일치, 2: 5개 일치, 3: 5개 + 보너스, 4: 6개 일치

        for (Lotto lotto : purchasedLottos) {
            int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
            if (matchCount == 6) {
                results[4]++;
            } else if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
                results[3]++;
            } else if (matchCount == 5) {
                results[2]++;
            } else if (matchCount == 4) {
                results[1]++;
            } else if (matchCount == 3) {
                results[0]++;
            }
        }

        printStatistics(results);
    }

    private static void printStatistics(int[] results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", results[0]);
        System.out.printf("4개 일치 (50,000원) - %d개%n", results[1]);
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", results[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", results[3]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", results[4]);
    }
}
