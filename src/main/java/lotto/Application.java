package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            int buyAmount = getBuyAmount();
            List<Lotto> lottoNumbers = lottoPurchase(buyAmount);
            List<Integer> winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber();
            Map<Rank, Integer> rankCount = lottoRankcalculation(lottoNumbers, winningNumbers, bonusNumber);
            statisticsOutput(rankCount, calculateProfit(rankCount, buyAmount));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String buyAmountInput = Console.readLine();

        isEmptyInputValue(buyAmountInput);
        int buyAmount = dataTypeConversion(buyAmountInput);
        validateAmountUnit(buyAmount);

        return buyAmount;
    }

    private static void isEmptyInputValue(String inputValue) {
        if (inputValue == null || inputValue.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해야 합니다.");
        }
    }

    private static int dataTypeConversion(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력 가능합니다.");
        }
    }

    private static void validateAmountUnit(int buyAmount) {
        if (buyAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 천원 단위만 입력 가능합니다.");
        }
    }

    private static List<Lotto> lottoPurchase(int buyAmount) {
        int lottoCount = buyAmount / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");

        List<Lotto> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(lottoNumberGeneration());
        }

        return lottoNumbers;
    }

    private static Lotto lottoNumberGeneration() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);

        Lotto lotto = new Lotto(numbers);

        System.out.println(lotto.getNumbers());
        return lotto;
    }

    private static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumberInput = Console.readLine();

        return splitWinningNumbersByComma(winningNumberInput);
    }

    private static List<Integer> splitWinningNumbersByComma(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    private static Map<Rank, Integer> lottoRankcalculation(List<Lotto> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Lotto lotto : lottoNumbers) {
            Rank rank = determineRank(lotto, winningNumbers, bonusNumber);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }

    private static Rank determineRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
        return Rank.calculateRank(matchCount, matchBonus);
    }

    private static double calculateProfit(Map<Rank, Integer> rankCount, int buyAmount) {
        int totalPrize = rankCount.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return ((double) totalPrize / buyAmount) * 100;
    }

    private static void statisticsOutput(Map<Rank, Integer> rankCount, double profitRate) {
        System.out.println("\n당첨 통계\n---");
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> System.out.println(rank.getDescription() + " - " + rankCount.getOrDefault(rank, 0) + "개"));
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
