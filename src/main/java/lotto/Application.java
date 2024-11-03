package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = getAmount();
        int lottoCount = amount /1000;
        System.out.println();

        System.out.println(lottoCount + "개를 구매했습니다.");
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(generateRandomLottoNumbers());
            purchasedLottos.add(lotto);
            System.out.println(lotto.getNumbers());
        }
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningLotto = new Lotto();
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = getBonusNumber(winningLotto.getNumbers());
        System.out.println();
        //구매한 로또 번호와 당첨 번호 비교, 당첨 결과 확인
        showResult(purchasedLottos, winningLotto, bonusNumber);
    }

    public static int getAmount() {
        String inputAmount = Console.readLine();
        return validateAmountValue(inputAmount);
    }

    private static int validateAmountValue(String inputAmount) {
        try {
            int amount = Integer.parseInt(inputAmount);
            if (amount < 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다");
            }
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }

    }

    private static List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    private static int getBonusNumber(List<Integer> winningNumbers) {
        String inputBonus = Console.readLine();
        return validateBonusNumber(inputBonus, winningNumbers);
    }

    private static int validateBonusNumber(String inputBonus, List<Integer> winningNumbers) {
        try {
            int bonusNumber = Integer.parseInt(inputBonus.trim());
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 타입입니다");
        }
    }

    private static void showResult(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        int[] rankCount = new int[6];

        for (Lotto lotto : purchasedLottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningLotto.getNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            if (matchCount == 6) {
                rankCount[1]++;
                continue;
            }
            if (matchCount == 5 && bonusMatch) {
                rankCount[2]++;
                continue;
            }
            if (matchCount == 5) {
                rankCount[3]++;
                continue;
            }
            if (matchCount == 4) {
                rankCount[4]++;
                continue;
            }
            if (matchCount == 3) {
                rankCount[5]++;
            }
        }
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + rankCount[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + rankCount[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCount[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCount[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCount[1] + "개");
        calculateYield(rankCount, purchasedLottos.size()*1000);
    }

    private static int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static void calculateYield(int[] rankCount, int amount) {
        int[] prizeMoney = {0, 2000000000, 30000000, 1500000, 50000, 5000};
        int totalPrize = 0;

        for (int i = 0; i <= 5; i++) {
            totalPrize += rankCount[i] * prizeMoney[i];
        }
        double profit = ((double) totalPrize / amount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profit);
    }

}
