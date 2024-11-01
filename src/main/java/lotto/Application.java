package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = 0;
        Lotto winningNumbersLotto;

        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String purchasePriceInput = Console.readLine();
            try {
                int purchasePrice = validatePurchasePrice(purchasePriceInput);

                if (purchasePrice % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위만 허용됩니다.");
                }

                purchaseAmount = purchasePrice / 1000;

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

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
                    int number = validateNumber(winningNumber);
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
                bonusNumber = validateBonusNumber(bonusNumberInput, winningNumbersLotto);

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

    public enum PrizeRank {
        FIRST(6, 2_000_000_000, false),
        SECOND(5, 30_000_000, true),
        THIRD(5, 1_500_000, false),
        FOURTH(4, 50_000, false),
        FIFTH(3, 5_000, false),
        NONE(0, 0, false);

        private final int matchCount;
        private final int prizeAmount;
        private final boolean isBonusNeed;

        PrizeRank(int matchCount, int prizeAmount, boolean isBonusNeed) {
            this.matchCount = matchCount;
            this.prizeAmount = prizeAmount;
            this.isBonusNeed = isBonusNeed;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public int getPrizeAmount() {
            return prizeAmount;
        }

        public static PrizeRank getPrizeRank(int matchCount, boolean isBonusMatch) {
            return Arrays.stream(values())
                    .filter(prizeRank -> (prizeRank.matchCount == matchCount))
                    .filter(prizeRank -> (!prizeRank.isBonusNeed || isBonusMatch))
                    .findFirst()
                    .orElse(NONE);
        }
    }

    static int validatePurchasePrice(String purchasePriceInput) {
        try{
            return Integer.parseInt(purchasePriceInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위의 숫자만 허용됩니다.");
        }
    }

    static int validateNumber(String numberInput) {
        try{
            return Integer.parseInt(numberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.(쉼표(,)로 구분)");
        }
    }
    static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }
    static int validateBonusNumber(String bonusNumberInput, Lotto winningNumbersLotto) {
        try {
           int bonusNumber = Integer.parseInt(bonusNumberInput);

           if (bonusNumber < 1 || bonusNumber > 45) {
               throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
           }

           if (winningNumbersLotto.contains(bonusNumber)) {
               throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
           }

           return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
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
