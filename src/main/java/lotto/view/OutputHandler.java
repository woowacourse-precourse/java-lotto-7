package lotto.view;

import lotto.constant.Constants;
import lotto.model.Prize;

import java.text.NumberFormat;
import java.util.*;

public class OutputHandler {

    public void promptForAmountInput() {
        System.out.println(Constants.PROMPT_PURCHASE_AMOUNT);
    }

    public void promptForLottoNumber() {
        System.out.println(Constants.NEXT_LINE + Constants.PROMPT_WINNING_LOTTO_NUMBER);
    }

    public void promptForBonusNumber() {
        System.out.println(Constants.NEXT_LINE + Constants.PROMPT_BONUS_LOTTO_NUMBER);
    }

    public void displayPurchasedLottoCount(int count) {
        System.out.println(Constants.NEXT_LINE + count + Constants.PROMPT_PURCHASED_LOTTO_COUNT);
    }

    public void displayPrizes(EnumMap<Prize, Integer> prizeCount) {
        System.out.println(Constants.NEXT_LINE + Constants.PRIZE_STATISTICS_HEADER + Constants.NEXT_LINE + Constants.PRIZE_STATISTICS_DIVIDER);

        for (Prize prize : Prize.values()) {

            long moneyWithoutComma = prize.getPrizeMoney();
            String moneyWithComma = formatCurrency(moneyWithoutComma);


            if (prize.equals(Prize.SECOND)) {
                System.out.println(String.format(Constants.SECOND_PRIZE_MESSAGE, prize.getRanking(), moneyWithComma, prizeCount.get(prize)));
                continue;
            }
            System.out.println(String.format(Constants.PRIZE_MESSAGE, prize.getRanking(), moneyWithComma, prizeCount.get(prize)));
        }
    }

    public void displayWinningRate(double winningRate) {
        String formattedValue = String.format(Constants.DECIMAL_FORMAT_ONE_PLACE, winningRate);
        System.out.println(String.format(Constants.WINNING_RATE_MESSAGE, formattedValue));
    }

    public void showLottos(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers.toString());
    }


    public static String formatCurrency(long amount) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);
        return numberFormat.format(amount);
    }
}
