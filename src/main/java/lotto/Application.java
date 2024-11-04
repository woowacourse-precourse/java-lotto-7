package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private static final String ERROR_INVALID_AMOUNT = "[ERROR] 구입 금액은 양수여야 합니다";
    private static final String ERROR_AMOUNT_NOT_DIVISIBLE = "[ERROR] 구입 금액은 " + LOTTO_PRICE + "으로 나누어 떨어져야 합니다.";
    private static final String ERROR_INVALID_INPUT = "[ERROR] 잘못된 입력입니다.";
    private static final String ERROR_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이의 숫자여야 합니다.";
    private static final String ERROR_BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private static final String ERROR_INVALID_TYPE = "[ERROR] 올바르지 않은 타입입니다";

    public static void main(String[] args) {
        int amount = getAmount();
        int lottoCount = calculateLottoCount(amount);
        List<Lotto> purchasedLottos = purchaseLottos(lottoCount);
        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber(winningLotto.getNumbers());
        showResult(purchasedLottos, winningLotto, bonusNumber);
    }

    private static Lotto getWinningLotto() {
        return new Lotto();
    }

    private static List<Lotto> purchaseLottos(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(generateRandomLottoNumbers());
            purchasedLottos.add(lotto);
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
        return purchasedLottos;
    }

    private static int calculateLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    public static int getAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String inputAmount = Console.readLine();
                return validateAmountValue(inputAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int validateAmountValue(String inputAmount) {
        try {
            int amount = Integer.parseInt(inputAmount);
            if (amount < 0) {
                throw new IllegalArgumentException(ERROR_INVALID_AMOUNT);
            }
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException(ERROR_AMOUNT_NOT_DIVISIBLE);
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }

    }

    private static List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER,MAX_NUMBER,LOTTO_NUMBER_COUNT);
    }

    private static int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String inputBonus = Console.readLine();
                return validateBonusNumber(inputBonus, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int validateBonusNumber(String inputBonus, List<Integer> winningNumbers) {
        try {
            int bonusNumber = Integer.parseInt(inputBonus.trim());
            if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
                throw new IllegalArgumentException(ERROR_BONUS_NUMBER_RANGE);
            }
            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException(ERROR_BONUS_NUMBER_DUPLICATE);
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_TYPE);
        }
    }

    private static void showResult(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        int[] rankCount = calculateRank(purchasedLottos, winningLotto, bonusNumber);
        printStatistics(rankCount);
        calculateYield(rankCount,purchasedLottos.size()*LOTTO_PRICE);
    }

    private static void printStatistics(int[] rankCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", rankCount[Rank.FIFTH.ordinal()]);
        System.out.printf("4개 일치 (50,000원) - %d개%n", rankCount[Rank.FOURTH.ordinal()]);
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", rankCount[Rank.THIRD.ordinal()]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", rankCount[Rank.SECOND.ordinal()]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", rankCount[Rank.FIRST.ordinal()]);
    }

    private static int[] calculateRank(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        int[] rankCount = new int[Rank.values().length];
        for (Lotto lotto : purchasedLottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningLotto.getNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            Rank rank = Rank.valueOf(matchCount, bonusMatch);
            rankCount[rank.ordinal()]++;
        }
        return rankCount;
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
        int totalPrize = 0;

        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                totalPrize += rankCount[rank.ordinal()] * rank.getPrize();
            }
        }
        double profit = ((double) totalPrize / amount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profit);
    }
}
