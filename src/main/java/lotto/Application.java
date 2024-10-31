package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.calculator.InvestmentReturnCalculator;
import lotto.domain.Lotto;
import lotto.domain.enums.LottoRank;
import lotto.domain.generator.RandomNumber;
import lotto.domain.generator.RandomNumbers;
import lotto.util.converter.PurchaseCountConverter;
import lotto.util.converter.WinningNumberConverter;

import java.util.EnumMap;
import java.util.List;

import static lotto.common.Message.*;
import static lotto.common.Number.*;
import static lotto.common.Symbol.*;

public class Application {
    public static void main(String[] args) {

        System.out.println(INPUT_PURCHASE_AMOUNT);
        int purchaseCount = getPurchaseCount(Console.readLine());

        System.out.printf(BUY, purchaseCount);
        RandomNumbers randomNumbers = getRandomNumbers(purchaseCount);
        printRandomNumbers(randomNumbers);

        System.out.println(CHECK_WINNING_NUMBER);
        WinningNumberConverter winningNumberConverter = new WinningNumberConverter(Console.readLine());
        List<Integer> winningNumbers = winningNumberConverter.convertWinningNumber();

        Lotto lotto = new Lotto(winningNumbers);

        System.out.println(INPUT_BONUS_NUMBER);
        int bonusNumber = winningNumberConverter.convertBonusNumber(Console.readLine());

        EnumMap<LottoRank, Integer> rankCountMap = lotto.checkWinning(randomNumbers, bonusNumber);
        printStatistics(purchaseCount, rankCountMap);
    }

    private static int getPurchaseCount(String inputPurchaseAmount) {
        PurchaseCountConverter purchaseCountConverter = new PurchaseCountConverter(inputPurchaseAmount);
        return purchaseCountConverter.convert();
    }

    private static RandomNumbers getRandomNumbers(int purchaseCount) {
        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumbers.addRandomNumber(purchaseCount);
        return randomNumbers;
    }

    private static void printRandomNumbers(RandomNumbers randomNumbers) {
        StringBuilder stringBuilder = new StringBuilder();
        for (RandomNumber randomNumber : randomNumbers.randomNumbers()) {
            stringBuilder.append(randomNumber.randomNumber()).append(NEW_LINE);
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

    private static void printInvestmentReturn(int purchaseCount, EnumMap<LottoRank, Integer> rankCountMap) {
        double percentage = InvestmentReturnCalculator.calculate(rankCountMap, purchaseCount);
        System.out.printf(PERCENTAGE, percentage);
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
}
