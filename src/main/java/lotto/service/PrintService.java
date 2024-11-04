package lotto.service;

import java.util.List;
import lotto.message.LottoErrorMessages;
import lotto.message.LottoInfoMessages;
import lotto.message.StatisticsMessages;
import lotto.model.Lotto;
import lotto.model.LottoGroup;

public class PrintService {
    private static final int MATCHED_RESULT_LENGTH = 5;
    private static final int THREE = 0;
    private static final int FOUR = 1;
    private static final int FIVE = 2;
    private static final int FIVE_BONUS = 3;
    private static final int SIX = 4;
    private static final int ADJUST_NUMBER = 100;
    private static final int THREE_EARN = 5000;
    private static final int FOUR_EARN = 50000;
    private static final int FIVE_EARN = 1500000;
    private static final int FIVE_BONUS_EARN = 30000000;
    private static final int SIX_EARN = 2000000000;

    private PrintService() {

    }

    public static PrintService createPrintService() {
        return new PrintService();
    }

    public void printNoticeBuyAmount(int amount) {
        System.out.println(
                amount + LottoInfoMessages.NOTICE_BUY_AMOUNT_START.text());
        System.out.println();
    }

    public void printWinnerNumbers(Lotto winnerLotto) {
        System.out.println(LottoInfoMessages.WINNER_NUMBERS.text());
        System.out.println(winnerLotto.getString());
        System.out.println();
    }

    public void printWrongRange() {
        System.out.println(LottoErrorMessages.NUMBER_RANGE_ERROR.text());
    }

    public void printBonusNumbers(int bonusNumber) {
        System.out.println(LottoInfoMessages.BONUS_NUMBER.text());
        System.out.println(bonusNumber);
        System.out.println();
    }

    public void printWrongBonusNumber(int bonusNumber) {
        System.out.println(LottoErrorMessages.BONUS_NUMBER_IS_DUPLICATED_ERROR.text());
    }

    public void printWinnerNumbersInfo() {
        System.out.println(LottoInfoMessages.INSERT_WINNING_NUMBER.text());
    }

    public void printBonusNumbersInfo() {
        System.out.println(LottoInfoMessages.INSERT_BONUS_NUMBER.text());
    }

    public void printStatistics(List<int[]> matchedList, int pay) {
        int[] matchedResult = new int[MATCHED_RESULT_LENGTH];
        for (int[] i : matchedList) {
            matchedResult = addCountNumber(i, matchedResult);
        }
        float earningRate = calculateEarning(matchedResult, pay);
        System.out.printf((StatisticsMessages.STATISTICS_RESULT.text()),
                matchedResult[THREE],
                matchedResult[FOUR],
                matchedResult[FIVE],
                matchedResult[FIVE_BONUS],
                matchedResult[SIX],
                earningRate);
    }

    private float calculateEarning(int[] matchedResult, int pay) {
        int earnings = 0;
        earnings += matchedResult[THREE] * THREE_EARN;
        earnings += matchedResult[FOUR] * FOUR_EARN;
        earnings += matchedResult[FIVE] * FIVE_EARN;
        earnings += matchedResult[FIVE_BONUS] * FIVE_BONUS_EARN;
        earnings += matchedResult[SIX] * SIX_EARN;
        return (float) ADJUST_NUMBER * earnings / pay;
    }

    private int[] addCountNumber(int[] numbers, int[] matchedResult) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                matchedResult[i]++;
            }
        }
        return matchedResult;
    }

    public void printLottoGroup(LottoGroup lottoGroup) {
        int lottoGroupSize = lottoGroup.getSize();
        List<Lotto> lottos = lottoGroup.getLottos();
        printBuyLottoList();
        for (int i = 0; i < lottoGroupSize; i++) {
            System.out.println(lottos.get(i).getString());
        }
        System.out.println();
    }

    private void printBuyLottoList() {
        System.out.println(LottoInfoMessages.BUY_LOTTO_LIST.text());
    }


    public void printSyntaxError() {
        System.out.println(LottoErrorMessages.SYNTAX_NUMBER_ERROR.addErrorText());
    }

    public void printPayInputError() {
        System.out.println(LottoErrorMessages.PAY_INPUT_ERROR.addErrorText());
    }

    public void printNotThousand() {
        System.out.println(LottoErrorMessages.NOT_THOUSAND.addErrorText());
    }

    public void printInsertPay() {
        System.out.println(LottoInfoMessages.INSERT_PAY.text());
    }
}
