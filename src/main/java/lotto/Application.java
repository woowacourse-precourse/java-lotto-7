package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = getPurchaseAmount();
            List<Lotto> purchasedLottos = generateLottos(purchaseAmount / 1000);
            printPurchasedLottos(purchasedLottos);

            List<Integer> winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber();

            printStatistics(purchasedLottos, winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 입력이 올바른 숫자가 아닙니다.");
        }
    }

    // 구입 금액 입력 처리
    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 유효한 금액을 입력해 주세요 (1,000원 단위).");
        }
        return amount;
    }

    // 로또 발행
    private static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    // 발행된 로또 출력
    private static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println("");
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    // 당첨 번호 입력
    private static List<Integer> getWinningNumbers() {
        System.out.println("");
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] inputs = Console.readLine().split(",");
        if (inputs.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        Set<Integer> winningNumbers = new HashSet<>();
        for (String input : inputs) {
            int number = Integer.parseInt(input.trim());
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 번호는 1에서 45 사이여야 합니다.");
            }
            winningNumbers.add(number);
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }
        return new ArrayList<>(winningNumbers);
    }

    // 보너스 번호 입력
    private static int getBonusNumber() {
        System.out.println("");
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine().trim());
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이여야 합니다.");
        }
        return bonusNumber;
    }

    // [기능] 당첨 통계 계산 및 출력
    private static void printStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] prizeCount = new int[5]; // 3등 ~ 1등
        int totalPrize = 0;

        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningNumbers);
            boolean bonusMatch = lotto.containsNumber(bonusNumber);

            if (matchCount == 6) {
                prizeCount[4]++; // 1등
                totalPrize += 2_000_000_000;
            } else if (matchCount == 5 && bonusMatch) {
                prizeCount[3]++; // 2등
                totalPrize += 30_000_000;
            } else if (matchCount == 5) {
                prizeCount[2]++; // 3등
                totalPrize += 1_500_000;
            } else if (matchCount == 4) {
                prizeCount[1]++; // 4등
                totalPrize += 50_000;
            } else if (matchCount == 3) {
                prizeCount[0]++; // 5등
                totalPrize += 5_000;
            }
        }

        System.out.println("");
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + prizeCount[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeCount[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeCount[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeCount[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeCount[4] + "개");
        
        double yield = (double) totalPrize / (lottos.size() * 1000) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}