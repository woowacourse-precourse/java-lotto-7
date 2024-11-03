package lotto;

import static java.lang.Integer.parseInt;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    private static final int PER_LOTTO_PRICE = 1000;
    private static final int RAND_MIN = 1;
    private static final int RAND_MAX = 45;
    private static final int THRESHOLD = 6;
    private static final String DELIMITER = ",";

    public static void main(String[] args) {
        int purchasePrice; // 로또 구입금액
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String purchasePriceStr = Console.readLine();
                purchasePrice = parseInt(purchasePriceStr);
                if (purchasePrice <= 0 || purchasePrice % PER_LOTTO_PRICE != 0) {
                    throw new IllegalArgumentException("[ERROR] 1,000원 단위의 올바른 금액을 입력하세요.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int lottoPieces = purchasePrice / PER_LOTTO_PRICE;
        System.out.printf("%d개를 구매했습니다.%n", lottoPieces);

        List<Lotto> numbersLines = new ArrayList<>();
        for (int i = 0; i < lottoPieces; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(RAND_MIN, RAND_MAX, THRESHOLD));
            Collections.sort(numbers);
            numbersLines.add(new Lotto(numbers));
            System.out.println(numbers);
        }

        List<Integer> winningNumbers = new ArrayList<>(); // 추첨 번호
        while (winningNumbers.size() < 6) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String[] input = Console.readLine().split(DELIMITER);
                if (input.length != 6) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
                }
                for (String number : input) {
                    int num = parseInt(number.trim());
                    if (num < 1 || num > 45) {
                        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                    winningNumbers.add(num);
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int bonusNumber;
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonusNumber = parseInt(Console.readLine().trim());
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("당첨 통계");
        System.out.println("---");

        Map<LottoResult, Integer> totalMatchCount = new HashMap<>();
        for (LottoResult result : LottoResult.values()) {
            totalMatchCount.put(result, 0);
        }

        for (Lotto lotto : numbersLines) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int matchCount = 0;
            for (Integer number : lottoNumbers) {
                if (winningNumbers.contains(number)) {
                    matchCount++;
                }
            }

            boolean bonusMatched = lottoNumbers.contains(bonusNumber);
            LottoResult result = LottoResult.fromMatchCount(matchCount, bonusMatched);
            totalMatchCount.put(result, totalMatchCount.get(result) + 1);
        }

        for (LottoResult result : LottoResult.values()) {
            System.out.printf("%d개 일치 (%,d원) - %d개%n", result.getMatchCount(), result.getPrize(), totalMatchCount.getOrDefault(result, 0));
        }

        long totalWinningAmount = 0;
        for (LottoResult result : LottoResult.values()) {
            totalWinningAmount += result.getPrize() * totalMatchCount.getOrDefault(result, 0);
        }

        double winningRate = (double) totalWinningAmount / purchasePrice * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", winningRate);
    }
}

enum LottoResult {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final long prize;

    LottoResult(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoResult fromMatchCount(int matchCount, boolean bonusMatched) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5) {
            if (bonusMatched) return SECOND;
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public long getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}


