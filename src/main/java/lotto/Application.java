package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static final int LOTTO_UNIT_PRICE = 1000;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = calculatePurchaseAmount(scanPurchasePrice());
        Lotto winningNumbersLotto;

        System.out.println("\n" + purchaseAmount + "개를 구매했습니다.");
        List<Lotto> myLottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            myLottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        printLottos(myLottos);

        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String[] winningNumbersInput = Console.readLine().split(",");
            List<Integer> winningNumbers = new ArrayList<>();
            try{
                if (winningNumbersInput.length != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.(쉼표(,)로 구분)");
                }

                for (String winningNumber : winningNumbersInput) {
                    int number = Validator.validateNumber(winningNumber);
                    winningNumbers.add(number);
                }

                winningNumbersLotto = new Lotto(winningNumbers);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int bonusNumber;

        while (true) {
            System.out.println("\n보너스 번호를 입력해 주세요.");
            String bonusNumberInput = Console.readLine();
            try{
                bonusNumber = Validator.validateBonusNumber(bonusNumberInput, winningNumbersLotto);

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Map<PrizeRank, Integer> prizeRankCounts = new HashMap<>();

        for (PrizeRank prizeRank : PrizeRank.values()) {
            prizeRankCounts.put(prizeRank, 0);
        }

        for (Lotto lotto : myLottos) {
            int matchCount = lotto.getMatchCount(winningNumbersLotto);
            boolean isBonusMatch = lotto.isBonusMatch(bonusNumber);
            PrizeRank prizeRank = PrizeRank.getPrizeRank(matchCount, isBonusMatch);
            prizeRankCounts.put(prizeRank, prizeRankCounts.get(prizeRank) + 1);
        }

        double rateOfReturn = getRateOfReturn(prizeRankCounts, purchaseAmount);

        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + prizeRankCounts.get(PrizeRank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeRankCounts.get(PrizeRank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeRankCounts.get(PrizeRank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeRankCounts.get(PrizeRank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeRankCounts.get(PrizeRank.FIRST) + "개");
        System.out.println("총 수익률은 "+ String.format("%.1f", rateOfReturn) +"%입니다.");
    }

    public static int calculatePurchaseAmount(int purchasePrice) {
        return purchasePrice / LOTTO_UNIT_PRICE;
    }

    public static int scanPurchasePrice() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                String purchasePriceInput = Console.readLine();
                return Validator.validatePurchasePrice(purchasePriceInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    public static double getRateOfReturn(Map<PrizeRank, Integer> prizeRankCounts, int purchaseAmount) {
        // 수익률 = 총상금 / 구입금액 * 100
        // 수익률 = 총상금 / (구입개수 * 1000) * 100
        double totalPrizeAmount = 0;
        for (PrizeRank prizeRank : PrizeRank.values()) {
            double prizeAmount = prizeRank.getPrizeAmount();
            int prizeCount = prizeRankCounts.get(prizeRank);
            totalPrizeAmount += prizeAmount * prizeCount;
        }
        return totalPrizeAmount / (purchaseAmount * 1000) * 100;
    }
}
