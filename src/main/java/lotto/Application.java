package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.enums.LottoRank;
import lotto.domain.generator.RandomNumberGenerator;
import lotto.util.calculator.InvestmentReturnCalculator;
import lotto.util.converter.PurchaseCountConverter;
import lotto.util.converter.WinningNumberConverter;
import lotto.validator.type.InputType;
import lotto.validator.InputValidator;
import lotto.validator.factory.InputValidatorStrategyFactory;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static lotto.common.Message.*;
import static lotto.common.Number.ONE;
import static lotto.common.Number.ZERO;
import static lotto.common.Symbol.NEW_LINE;
import static lotto.common.Symbol.TRIPLE_DASH;
import static lotto.validator.type.InputType.*;

public class Application {

    private static final InputValidatorStrategyFactory validateFactory = new InputValidatorStrategyFactory();

    public static void main(String[] args) {

        String inputPurchaseAmount = checkInputFormat(INPUT_PURCHASE_AMOUNT, PURCHASE_AMOUNT);
        int purchaseCount = PurchaseCountConverter.convert(inputPurchaseAmount);

        System.out.printf(BUY, purchaseCount);
        List<List<Integer>> randomNumbers = addRandomNumbers(purchaseCount);
        printRandomNumbers(randomNumbers);

        String inputWinningNumber = checkInputFormat(CHECK_WINNING_NUMBER, WINNING_NUMBER);
        List<Integer> winningNumbers = WinningNumberConverter.convertWinningNumber(inputWinningNumber);

        Lotto lotto = new Lotto(winningNumbers);

        String inputBonusNumber = checkInputFormat(INPUT_BONUS_NUMBER, BONUS_NUMBER);
        int bonusNumber = WinningNumberConverter.convertBonusNumber(inputWinningNumber, inputBonusNumber);

        EnumMap<LottoRank, Integer> rankCountMap = lotto.checkWinning(randomNumbers, bonusNumber);
        printStatistics(purchaseCount, rankCountMap);
    }

    private static String checkInputFormat(String message, InputType inputType) {
        System.out.println(message);
        InputValidator inputValidator = validateFactory.getValidator(inputType);
        return getValidInput(inputValidator);
    }

    private static String getValidInput(InputValidator inputValidator) {
        while (true) {
            try {
                String input = Console.readLine();
                inputValidator.validate(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<List<Integer>> addRandomNumbers(int purchaseCount) {
        List<List<Integer>> randomNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            randomNumbers.add(RandomNumberGenerator.generate());
        }
        return randomNumbers;
    }

    private static void printRandomNumbers(List<List<Integer>> randomNumbers) {
        StringBuilder stringBuilder = new StringBuilder();

        for (List<Integer> randomNumber : randomNumbers) {
            stringBuilder.append(randomNumber).append(NEW_LINE);
        }
        System.out.println(stringBuilder);
    }

    private static void printStatistics(int purchaseCount, EnumMap<LottoRank, Integer> rankCountMap) {
        printStatisticsPrefix();
        printWinningResult(rankCountMap);
        printInvestmentReturn(purchaseCount, rankCountMap);
    }

    private static void printStatisticsPrefix() {
        System.out.println(WINNING_STATISTICS);
        System.out.println(TRIPLE_DASH);
    }

    private static void printWinningResult(EnumMap<LottoRank, Integer> rankCountMap) {
        List<LottoRank> lottoRankList = List.of(LottoRank.values());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = lottoRankList.size() - ONE; i >= ZERO; i--) {
            LottoRank lottoRank = lottoRankList.get(i);
            if (lottoRank.equals(LottoRank.UN_RANK)) {
                continue;
            }
            stringBuilder.append(getResultMessage(lottoRank, rankCountMap.get(lottoRank)));
        }
        System.out.println(stringBuilder);
    }

    private static String getResultMessage(LottoRank lottoRank, int winningCount) {
        int matchCount = lottoRank.matchCount();
        int lotteryPrize = lottoRank.lotteryPrize();

        if (lottoRank.equals(LottoRank.SECOND_RANK)) {
            return String.format(BONUS_WINNING_MESSAGE, matchCount, lotteryPrize, winningCount);
        }
        return String.format(WINNING_MESSAGE, matchCount, lotteryPrize, winningCount);
    }

    private static void printInvestmentReturn(int purchaseCount, EnumMap<LottoRank, Integer> rankCountMap) {
        double percentage = InvestmentReturnCalculator.calculate(rankCountMap, purchaseCount);
        System.out.printf(PERCENTAGE, percentage);
    }
}
