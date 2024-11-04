package lotto.io;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.RankCount;
import lotto.util.Constants;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Output {
    public void printPurchasePriceInputPrompt() {
        System.out.println(Constants.PURCHASE_PRICE_INPUT_PROMPT.getMessage());
    }

    public void printLottoCount(int lottoCount) {
        System.out.println("\n "+ lottoCount + Constants.LOTTO_COUNT_PROMPT.getMessage());
    }

    public void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            printLottoNumber(lotto);
        }
    }

    private void printLottoNumber(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        System.out.print(Constants.LOTTO_NUMBER_START.getMessage());
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            printCommaIfNotLast(i, numbers.size());
        }
        System.out.println(Constants.LOTTO_NUMBER_END.getMessage());
    }

    private void printCommaIfNotLast(int i, int size) {
        if (i < size - 1) {
            System.out.print(Constants.COMMA.getMessage() + " ");
        }
    }

    public void printWinningNumbersInputPrompt() {
        System.out.println(Constants.WINNING_NUMBERS_INPUT_PROMPT.getMessage());
    }

    public void printBonusNumberInputPrompt() {
        System.out.println(Constants.BONUS_NUMBER_INPUT_PROMPT.getMessage());
    }

    public void printWinningStatistics(List<RankCount> winningStatistics) {
        System.out.println(Constants.WINNING_STATISTICS.getMessage());
        for (RankCount rankCount : winningStatistics) {
            printWinningStatistic(rankCount);
        }
    }

    private void printWinningStatistic(RankCount rankCount) {
        int matchNumbersCount = rankCount.getRank().getMatchNumbersCount();
        int matchBonus = rankCount.getRank().getMatchBonus();
        String prize = getNumberFormat(rankCount.getRank().getPrize());
        int count = rankCount.getCount();

        if (matchBonus != 0) {
            System.out.printf((Constants.MATCH_COUNT_FORMAT_WITH_BONUS.getMessage()) + "%n", matchNumbersCount, prize, count);
            return;
        }
        System.out.printf((Constants.MATCH_COUNT_FORMAT.getMessage()) + "%n", matchNumbersCount, prize, count);
    }

    public void printProfitability(double profitability) {
        System.out.printf(Constants.PROFITABILITY_FORMAT.getMessage() + "%n", getNumberFormat(profitability));
    }

    private String getNumberFormat(int number) {
        NumberFormat formatter = NumberFormat.getInstance(Locale.US);
        return formatter.format(number);
    }

    private String getNumberFormat(double number) {
        NumberFormat formatter = NumberFormat.getInstance(Locale.US);
        formatter.setMaximumFractionDigits(1);
        formatter.setMinimumFractionDigits(1);
        return formatter.format(number);
    }
}
