package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.Message;
import lotto.domain.Lotto;
import lotto.domain.enums.LottoRank;
import lotto.domain.generator.RandomNumber;
import lotto.domain.generator.RandomNumbers;
import lotto.util.converter.PurchaseCountConverter;
import lotto.util.converter.WinningNumberConverter;

import java.util.EnumMap;
import java.util.List;

import static lotto.common.Message.*;
import static lotto.common.Symbol.NEW_LINE;
import static lotto.common.Symbol.TRIPLE_DASH;

public class Application {
    public static void main(String[] args) {

        System.out.println(INPUT_PURCHASE_AMOUNT);
        String inputPurchaseAmount = Console.readLine();
        System.out.println();

        PurchaseCountConverter purchaseCountConverter = new PurchaseCountConverter(inputPurchaseAmount);
        int purchaseCount = purchaseCountConverter.convert();
        System.out.printf(BUY + NEW_LINE, purchaseCount);

        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumbers.addRandomNumber(purchaseCount);
        printRandomNumbers(randomNumbers);

        System.out.println(CHECK_WINNING_NUMBER);
        String inputWinningNumber = Console.readLine();
        WinningNumberConverter winningNumberConverter = new WinningNumberConverter(inputWinningNumber);
        List<Integer> winningNumbers = winningNumberConverter.convertWinningNumber();
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
        String inputBonusNumber = Console.readLine();
        int bonusNumber = winningNumberConverter.convertBonusNumber(inputBonusNumber); // TODO winningNumber 예외가 먼저 발생하도록 변경

        Lotto lotto = new Lotto(winningNumbers);
        EnumMap<LottoRank, Integer> rankCount = lotto.checkWinning(randomNumbers, bonusNumber);
        printWinningStatistics(rankCount, purchaseCount);
    }

    private static void printRandomNumbers(RandomNumbers randomNumbers) {
        StringBuilder stringBuilder = new StringBuilder();
        for (RandomNumber randomNumber : randomNumbers.randomNumbers()) {
            stringBuilder.append(randomNumber.randomNumber()).append(NEW_LINE);
        }
        System.out.println(stringBuilder);
    }

    private static void printWinningStatistics(EnumMap<LottoRank, Integer> rankCount, int purchaseCount) {
        List<LottoRank> list = List.of(LottoRank.values());

        System.out.println(WINNING_STATISTICS);
        System.out.println(TRIPLE_DASH + NEW_LINE);

        double result = 0L;

        for (int i = list.size() - 1; i >= 0; i--) {
            LottoRank lottoRank = list.get(i);
            if (lottoRank.equals(LottoRank.SECOND_RANK)) {
                System.out.printf(BONUS_WINNING_MESSAGE + NEW_LINE, lottoRank.matchCount(), lottoRank.lotteryPrize(), rankCount.get(lottoRank));
                result += lottoRank.lotteryPrize() * rankCount.get(lottoRank);
                continue;
            }
            if (!lottoRank.equals(LottoRank.UN_RANK)) {
                System.out.printf(WINNING_MESSAGE + NEW_LINE, lottoRank.matchCount(), lottoRank.lotteryPrize(), rankCount.get(lottoRank));
                result += lottoRank.lotteryPrize() * rankCount.get(lottoRank);
            }
        }

        double percentage = (result / (purchaseCount * 1000L)) * 100;
        System.out.printf(PERCENTAGE, percentage);
    }
}
