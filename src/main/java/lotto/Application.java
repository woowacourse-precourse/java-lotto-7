package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_RANGE_START = 1;
    private static final int LOTTO_NUMBER_RANGE_END = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final Map<String, Integer> PRIZE_MONEY = Map.of(
            "1등", 2_000_000_000,
            "2등", 30_000_000,
            "3등", 1_500_000,
            "4등", 50_000,
            "5등", 5_000,
            "꽝", 0
    );

    public static void main(String[] args) {
        try {
            int purchaseAmount = getPurchaseAmount();
            int lottoCount = purchaseAmount / LOTTO_PRICE;
            System.out.println(lottoCount + "개를 구매했습니다.");

            List<Lotto> purchasedLottos = generateLottos(lottoCount);
            purchasedLottos.forEach(lotto -> System.out.println(lotto.getNumbers()));

            List<Integer> winningNumbers = getWinningNumbers();
            //System.out.println("당첨 번호: " + winningNumbers);

            int bonusNumber = getBonusNumber();
            //System.out.println("보너스 번호: " + bonusNumber);

            Map<String, Integer> results = checkResults(purchasedLottos, winningNumbers, bonusNumber);
            printResults(results);
            calculateAndPrintProfit(results, purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int purchaseAmount = Integer.parseInt(Console.readLine().trim());
            if (purchaseAmount % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }

    private static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = generateLottoNumbers();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END, LOTTO_NUMBERS_COUNT
        ));
        Collections.sort(numbers);
        return numbers;
    }

    private static List<Integer> getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        validateLottoNumbers(winningNumbers);
        return winningNumbers;
    }

    private static int getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine().trim());
        if (bonusNumber < LOTTO_NUMBER_RANGE_START || bonusNumber > LOTTO_NUMBER_RANGE_END) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이여야 합니다.");
        }
        return bonusNumber;
    }

    private static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (int number : numbers) {
            if (number < LOTTO_NUMBER_RANGE_START || number > LOTTO_NUMBER_RANGE_END) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이여야 합니다.");
            }
        }
    }

    private static Map<String, Integer> checkResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<String, Integer> results = new HashMap<>();
        results.put("1등", 0);
        results.put("2등", 0);
        results.put("3등", 0);
        results.put("4등", 0);
        results.put("5등", 0);
        results.put("꽝", 0);

        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers);
            boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
            String prize = determinePrize(matchCount, hasBonus);
            results.put(prize, results.get(prize) + 1);
        }
        return results;
    }

    private static int getMatchCount(List<Integer> numbers, List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    private static String determinePrize(int matchCount, boolean hasBonus) {
        if (matchCount == 6) return "1등";
        if (matchCount == 5 && hasBonus) return "2등";
        if (matchCount == 5) return "3등";
        if (matchCount == 4) return "4등";
        if (matchCount == 3) return "5등";
        return "꽝";
    }

    private static void printResults(Map<String, Integer> results) {
        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + results.get("5등") + "개");
        System.out.println("4개 일치 (50,000원) - " + results.get("4등") + "개");
        System.out.println("5개 일치 (1,500,000원) - " + results.get("3등") + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + results.get("2등") + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + results.get("1등") + "개");
    }

    private static void calculateAndPrintProfit(Map<String, Integer> results, int purchaseAmount) {
        long totalPrizeMoney = 0;
        for (String prize : results.keySet()) {
            totalPrizeMoney += PRIZE_MONEY.get(prize) * results.get(prize);
        }
        double profitRate = ((double) totalPrizeMoney / purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}

