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
            int bonusNumber = getBonusNumber(winningNumbers);
            Map<Rank, Integer> rankCount = lottoRankcalculation(lottoNumbers, winningNumbers, bonusNumber);
            statisticsOutput(rankCount, calculateProfit(rankCount, buyAmount));
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }

    private static int getBuyAmount() {
        System.out.println(Constants.MESSAGE_ENTER_BUY_AMOUNT.getMessageValue());
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
        if (buyAmount % Constants.LOTTO_PRICE.getNumberValue() != Constants.NO_MATCH.getNumberValue()) {
            throw new IllegalArgumentException(Error.INVALID_AMOUNT_UNIT.getMessage());
        }
    }

    private static List<Lotto> lottoPurchase(int buyAmount) {
        int lottoCount = buyAmount / Constants.LOTTO_PRICE.getNumberValue();
        System.out.println(lottoCount + Constants.MESSAGE_LOTTO_COUNT.getMessageValue());

        List<Lotto> lottoNumbers = new ArrayList<>();

        for (int i = Constants.DEFAULT.getNumberValue(); i < lottoCount; i++) {
            lottoNumbers.add(lottoNumberGeneration());
        }

        return lottoNumbers;
    }

    private static Lotto lottoNumberGeneration() {
        List<Integer> pickedNumbers = Randoms.pickUniqueNumbersInRange(
                Constants.LOTTO_MIN_NUMBER.getNumberValue(), Constants.LOTTO_MAX_NUMBER.getNumberValue(),
                Constants.LOTTO_NUMBER_COUNT.getNumberValue());
        List<Integer> numbers = new ArrayList<>(pickedNumbers);
        Collections.sort(numbers);

        Lotto lotto = new Lotto(numbers);

        System.out.println(lotto.getNumbers());
        return lotto;
    }

    private static List<Integer> getWinningNumbers() {
        System.out.println(Constants.MESSAGE_ENTER_WINNING_NUMBERS.getMessageValue());
        String winningNumberInput = Console.readLine();

        return splitWinningNumbersByComma(winningNumberInput);
    }

    private static List<Integer> splitWinningNumbersByComma(String input) {
        return Arrays.stream(input.split(Constants.DELIMITER.getDelimiter()))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println(Constants.MESSAGE_ENTER_BONUS_NUMBER.getMessageValue());
        int bonusNumber = Integer.parseInt(Console.readLine());

        checkBonusNumberDuplication(winningNumbers, bonusNumber);

        return bonusNumber;
    }

    private static void checkBonusNumberDuplication(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Error.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    private static Map<Rank, Integer> lottoRankcalculation(List<Lotto> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Lotto lotto : lottoNumbers) {
            Rank rank = determineRank(lotto, winningNumbers, bonusNumber);
            rankCount.put(rank, rankCount.getOrDefault(rank, Constants.DEFAULT.getNumberValue()) + 1);
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
        return ((double) totalPrize / buyAmount) * Constants.PERCENTAGE_MULTIPLIER.getNumberValue();
    }

    private static void statisticsOutput(Map<Rank, Integer> rankCount, double profitRate) {
        System.out.println(Constants.MESSAGE_STATISTICS_HEADER.getMessageValue());
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> System.out.println(rank.getDescription() + rankCount.getOrDefault(rank, Constants.DEFAULT.getNumberValue()) + "개"));
        System.out.printf(Constants.TOTAL_PROFIT_RATE_MESSAGE_FORMAT.getMessageValue(), profitRate, "%입니다.");
    }
}
