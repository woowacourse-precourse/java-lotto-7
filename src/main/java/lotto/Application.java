package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.stream.Collectors;

public class Application {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE_MULTIPLIER = 100;

    private final static String DELIMITER = ",";

    private static final String MESSAGE_ENTER_BUY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String MESSAGE_ENTER_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String MESSAGE_STATISTICS_HEADER = "\n당첨 통계\n---";
    private static final String TOTAL_PROFIT_RATE_MESSAGE_FORMAT = "총 수익률은 %.1f%s";

    private static final int NO_MATCH = 0;
    private static final int DEFAULT = 0;

    public static void main(String[] args) {
        try {
            int buyAmount = getBuyAmount();
            List<Lotto> lottoNumbers = lottoPurchase(buyAmount);
            List<Integer> winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber();
            Map<Rank, Integer> rankCount = lottoRankcalculation(lottoNumbers, winningNumbers, bonusNumber);
            statisticsOutput(rankCount, calculateProfit(rankCount, buyAmount));
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }

    private static int getBuyAmount() {
        System.out.println(MESSAGE_ENTER_BUY_AMOUNT);
        String buyAmountInput = Console.readLine();

        isEmptyInputValue(buyAmountInput);
        int buyAmount = dataTypeConversion(buyAmountInput);
        validateAmountUnit(buyAmount);

        return buyAmount;
    }

    private static void isEmptyInputValue(String inputValue) {
        if (inputValue == null || inputValue.isEmpty()) {
            throw new IllegalArgumentException(Error.EMPTY_INPUT.getMessage());
        }
    }

    private static int dataTypeConversion(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_INTEGER.getMessage());
        }
    }

    private static void validateAmountUnit(int buyAmount) {
        if (buyAmount % LOTTO_PRICE != NO_MATCH) {
            throw new IllegalArgumentException(Error.INVALID_AMOUNT_UNIT.getMessage());
        }
    }

    private static List<Lotto> lottoPurchase(int buyAmount) {
        int lottoCount = buyAmount / LOTTO_PRICE;
        System.out.println(lottoCount + MESSAGE_LOTTO_COUNT);

        List<Lotto> lottoNumbers = new ArrayList<>();

        for (int i = DEFAULT; i < lottoCount; i++) {
            lottoNumbers.add(lottoNumberGeneration());
        }

        return lottoNumbers;
    }

    private static Lotto lottoNumberGeneration() {
        List<Integer> pickedNumbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
        List<Integer> numbers = new ArrayList<>(pickedNumbers);
        Collections.sort(numbers);

        Lotto lotto = new Lotto(numbers);

        System.out.println(lotto.getNumbers());
        return lotto;
    }

    private static List<Integer> getWinningNumbers() {
        System.out.println(MESSAGE_ENTER_WINNING_NUMBERS);
        String winningNumberInput = Console.readLine();

        return splitWinningNumbersByComma(winningNumberInput);
    }

    private static List<Integer> splitWinningNumbersByComma(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int getBonusNumber() {
        System.out.println(MESSAGE_ENTER_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }

    private static Map<Rank, Integer> lottoRankcalculation(List<Lotto> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Lotto lotto : lottoNumbers) {
            Rank rank = determineRank(lotto, winningNumbers, bonusNumber);
            rankCount.put(rank, rankCount.getOrDefault(rank, DEFAULT) + 1);
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
        return ((double) totalPrize / buyAmount) * PERCENTAGE_MULTIPLIER;
    }

    private static void statisticsOutput(Map<Rank, Integer> rankCount, double profitRate) {
        System.out.println(MESSAGE_STATISTICS_HEADER);
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> System.out.println(rank.getDescription() + rankCount.getOrDefault(rank, DEFAULT) + "개"));
        System.out.printf(TOTAL_PROFIT_RATE_MESSAGE_FORMAT, profitRate, "%입니다.");
    }
}
