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
            if (!amount.trim().matches("\\d+")){
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
        List<String> winningNumbers = new ArrayList<>(List.of(Console.readLine().split(",")));

        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < winningNumbers.size(); i++) {
            try {
                integerList.add(i, Integer.parseInt(winningNumbers.get(i)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력해주세요");
            }
        }

        return integerList;
    }

    public static int getBonusNumber() {
        System.out.println(LOTTO_BONUS_NUMBER_INPUT_MESSAGE);
        String bonusNumber  = Console.readLine();

        if (bonusNumber == "\\d+") {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력이 가능합니다.");
        }
        return Integer.parseInt(bonusNumber);
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

    public static Map<Integer, Integer> calculateAllLineMatches(List<Integer> winningNumbers, List<Lotto> lottoNumbers, int bonusNumber) {
        Map<Integer, Integer> matchCounts = new HashMap<>();
        matchCounts.put(3, 0);
        matchCounts.put(4, 0);
        matchCounts.put(5, 0);
        matchCounts.put(6, 0);

        int bonusMatchCount = 0;

        for (Lotto lotto : lottoNumbers) {
            int matchCount = countLineMatch(winningNumbers, lotto.getNumbers());

            if (matchCount >= 3 && matchCount <= 6) {
                matchCounts.put(matchCount, matchCounts.get(matchCount) + 1);
            }

            if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
                bonusMatchCount++;
            }
        }

        // 보너스 매치 여부
        matchCounts.put(5, matchCounts.get(5) - bonusMatchCount);
        matchCounts.put(-5, bonusMatchCount);

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

        System.out.printf("총 수익률은 %.2f%%입니다.\n", profitRate);
    }

    public static double calculateProfitRate(Map<Integer, Integer> matchCounts, int purchaseAmount) {
        int totalPrize = 0;

        int threeMatchPrize = 5000;
        int fourMatchPrize = 50000;
        int fiveMatchPrize = 1500000;
        int fiveMatchBonusPrize = 30000000;
        int sixMatchPrize = 2000000000;

        totalPrize += matchCounts.getOrDefault(3, 0) * threeMatchPrize;
        totalPrize += matchCounts.getOrDefault(4, 0) * fourMatchPrize;
        totalPrize += matchCounts.getOrDefault(5, 0) * fiveMatchPrize;
        totalPrize += matchCounts.getOrDefault(-5, 0) * fiveMatchBonusPrize;
        totalPrize += matchCounts.getOrDefault(6, 0) * sixMatchPrize;

        double profitRate = ((double) totalPrize / purchaseAmount) * 100;

        return Math.round(profitRate * 100) / 100.0;
    }
}