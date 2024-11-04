package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    private static final String LOTTO_PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_QUANTITY_MESSAGE = "개를 구매했습니다.";

    private static final String THREE_MATCH_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String FOUR_MATCH_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String FIVE_MATCH_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_MATCH_BONUS_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_MATCH_MESSAGE = "6개 일치 (2,000,000,000원) - ";

    private static final String UNIT = "개";

    public static void main(String[] args) {
        try {
            System.out.println(LOTTO_PURCHASE_PRICE_INPUT_MESSAGE);
            List<Integer> lottoPurchaseAmount = getLottoPurchaseAmount(Console.readLine());

            List<Integer> winningNumbers = getWinningNumber();

            int bonusNumber = getBonusNumber();

            int lottoCount = getLottoCount(lottoPurchaseAmount);
            System.out.println(lottoCount + LOTTO_QUANTITY_MESSAGE);

            List<Lotto> lottoNumbers = getLottoNumbers(lottoCount);
            printLottoNumbers(lottoNumbers);

            System.out.println();

            int purchaseAmount = lottoCount * 1000;

            Map<Integer, Integer> matchCounts = calculateAllLineMatches(winningNumbers, lottoNumbers, bonusNumber);
            double profitRate = calculateProfitRate(matchCounts, purchaseAmount);

            printMatchStatistics(matchCounts, profitRate);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Integer> getLottoPurchaseAmount(String lottoPurchaseAmount) {
        List<Integer> purchaseAmount = new ArrayList<>();

        for (String amount : lottoPurchaseAmount.split(",")) {
            if (!amount.trim().matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자로만 입력이 가능합니다.");
            }

            int parsedAmount = Integer.parseInt(amount.trim());

            if (parsedAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로만 입력이 가능합니다.");
            }

            purchaseAmount.add(parsedAmount);
        }

        return purchaseAmount;
    }


    public static List<Integer> getWinningNumber() {
        System.out.println(LOTTO_WINNING_NUMBER_INPUT_MESSAGE);
        String inputWinningNumber = Console.readLine();

        if (!inputWinningNumber.matches("^[\\d,]+$")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 숫자로만 입력해 주세요.");
        }

        List<String> winningNumbers = new ArrayList<>(List.of(inputWinningNumber.split(",")));
        List<Integer> parsedWinningNumbers = new ArrayList<>();

        for (String winningNumber : winningNumbers) {
            try {
                int parsedNumber = Integer.parseInt(winningNumber);

                if (parsedNumber < 1 || parsedNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 1 ~ 45번까지만 입력이 가능합니다.");
                }

                parsedWinningNumbers.add(parsedNumber);

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력해주세요");
            }
        }

        return parsedWinningNumbers;
    }

    public static int getBonusNumber() {
        System.out.println(LOTTO_BONUS_NUMBER_INPUT_MESSAGE);
        String bonusNumber = Console.readLine();
        int getValidatedBonusNumber = Integer.parseInt(bonusNumber);

        if (!bonusNumber.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 단일 숫자만 입력이 가능합니다.");
        }

        if (getValidatedBonusNumber < 1 || getValidatedBonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45번까지만 입력이 가능합니다.");
        }

        return getValidatedBonusNumber;
    }

    public static int getLottoCount(List<Integer> purchaseAmounts) {
        int totalAmount = 0;

        for (int amount : purchaseAmounts) {
            totalAmount += amount;
        }

        return totalAmount / 1000;
    }

    public static List<Lotto> getLottoNumbers(int lottoCount) {
        List<Lotto> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Lotto.pickRandomNumber());
            lottoNumbers.add(lotto);
        }

        return lottoNumbers;
    }

    public static void printLottoNumbers(List<Lotto> lottoNumbers) {
        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto);
        }
    }

    public enum LottoRank {
        FIRST_RANK(6, false, 2_000_000_000),
        SECOND_RANK(5, true, 30_000_000),
        THIRD_RANK(5, false, 1_500_000),
        FOURTH_RANK(4, false, 50_000),
        FIFTH_RANK(3, false, 5_000);

        private final int matchCount;
        private final boolean bonusMatch;
        private final int prize;

        LottoRank(int matchCount, boolean bonusMatch, int prize) {
            this.matchCount = matchCount;
            this.bonusMatch = bonusMatch;
            this.prize = prize;
        }

        public int getPrize() {
            return prize;
        }

        public boolean matches(int matchCount, boolean bonusMatch) {
            return this.matchCount == matchCount && this.bonusMatch == bonusMatch;
        }

        public static LottoRank findRank(int matchCount, boolean bonusMatch) {
            for (LottoRank rank : values()) {
                if (rank.matches(matchCount, bonusMatch)) {
                    return rank;
                }
            }
            return null;
        }
    }


    public static Map<LottoRank, Integer> calculateAllLineMatches(List<Integer> winningNumbers, List<Lotto> lottoNumbers, int bonusNumber) {
        Map<LottoRank, Integer> matchCounts = new HashMap<>();

        for (LottoRank rank : LottoRank.values()) {
            matchCounts.put(rank, 0);
        }

        for (Lotto lotto : lottoNumbers) {
            int matchCount = countLineMatch(winningNumbers, lotto.getNumbers());
            boolean bonusMatch = (matchCount == 5) && lotto.getNumbers().contains(bonusNumber);

            LottoRank rank = LottoRank.findRank(matchCount, bonusMatch);

            if (rank != null) {
                matchCounts.put(rank, matchCounts.get(rank) + 1);
            }
        }
        return matchCounts;
    }

    // 한 줄마다 당첨 번호와 일치여부 확인
    private static int countLineMatch(List<Integer> winningNumbers, List<Integer> line) {
        int matchCount = 0;

        for (int number : line) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public static void printMatchStatistics(Map<Integer, Integer> matchCounts, double profitRate) {
        System.out.println(THREE_MATCH_MESSAGE + matchCounts.getOrDefault(3, 0) + UNIT);
        System.out.println(FOUR_MATCH_MESSAGE + matchCounts.getOrDefault(4, 0) + UNIT);
        System.out.println(FIVE_MATCH_MESSAGE + matchCounts.getOrDefault(5, 0) + UNIT);
        System.out.println(FIVE_MATCH_BONUS_MESSAGE + matchCounts.getOrDefault(-5, 0) + UNIT);
        System.out.println(SIX_MATCH_MESSAGE + matchCounts.getOrDefault(6, 0) + UNIT);

        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    public static double calculateProfitRate(Map<LottoRank, Integer> matchCounts, int purchaseAmount) {
        int totalPrize = 0;

        for (LottoRank rank : matchCounts.keySet()) {
            int count = matchCounts.get(rank);
            totalPrize += rank.getPrize() * count;
        }

        double profitRate = ((double) totalPrize / purchaseAmount) * 100;
        return Math.round(profitRate * 100) / 100.0;
    }
}