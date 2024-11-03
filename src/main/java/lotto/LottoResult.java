package lotto;

import static lotto.constant.ExtraText.NEW_LINE;
import static lotto.constant.LottoWinnings.FIFTH_PLACE;
import static lotto.constant.LottoWinnings.FIRST_PLACE;
import static lotto.constant.LottoWinnings.FOURTH_PLACE;
import static lotto.constant.LottoWinnings.SECOND_PLACE;
import static lotto.constant.LottoWinnings.THIRD_PLACE;
import static lotto.constant.PrintFormattedText.LOTTO_EARNING_RATES;
import static lotto.constant.PrintFormattedText.LOTT_WINNING_RESULT;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoWinnings;

public class LottoResult {
    private static final int INIT_SAME_COUNT = 0;
    private static final int MIN_WINNING_COUNT = 3;
    private static final int MAX_WINNING_COUNT = 6;
    private static final int BONUS_NUMBER_SAME = 1;
    private static final int PLUS_WINNING_COUNT = 1;
    private static final int WINNING_COUNT_FIVE = 5;
    private static final int WINNING_COUNT_FOUR = 4;
    private static final int FIFTH_PLACE_WINNINGS = 5_000;
    private static final int FOURTH_PLACE_WINNINGS = 50_000;
    private static final int THIRD_PLACE_WINNINGS = 1_500_000;
    private static final int SECOND_PLACE_WINNINGS = 30_000_000;
    private static final int FIRST_PLACE_WINNINGS = 2_000_000_000;
    private static final double INIT_EARNING_RATE = 0.0;
    private static final int PERCENT_VALUE = 100;
    private static final Map<LottoWinnings, Integer> LOTTO_WINNINGS = new HashMap<>();
    private static final Map<LottoWinnings, Integer> lottoSameCount = new EnumMap<>(LottoWinnings.class);

    public LottoResult() {
        lottoSameCount.put(FIRST_PLACE, INIT_SAME_COUNT);
        lottoSameCount.put(SECOND_PLACE, INIT_SAME_COUNT);
        lottoSameCount.put(THIRD_PLACE, INIT_SAME_COUNT);
        lottoSameCount.put(FOURTH_PLACE, INIT_SAME_COUNT);
        lottoSameCount.put(FIFTH_PLACE, INIT_SAME_COUNT);

        LOTTO_WINNINGS.put(FIFTH_PLACE, FIFTH_PLACE_WINNINGS);
        LOTTO_WINNINGS.put(FOURTH_PLACE, FOURTH_PLACE_WINNINGS);
        LOTTO_WINNINGS.put(THIRD_PLACE, THIRD_PLACE_WINNINGS);
        LOTTO_WINNINGS.put(SECOND_PLACE, SECOND_PLACE_WINNINGS);
        LOTTO_WINNINGS.put(FIRST_PLACE, FIRST_PLACE_WINNINGS);
    }

    public void calculateResult(int sameWinningCount, int sameBonusCount) {
        int sameTotalCount = sameWinningCount + sameBonusCount;
        if (sameTotalCount < MIN_WINNING_COUNT) {
            return;
        }
        saveResult(sameTotalCount, sameBonusCount);
    }

    private void saveResult(int sameTotalCount, int sameBonusCount) {
        if (sameTotalCount == MAX_WINNING_COUNT) {
            if (sameBonusCount == BONUS_NUMBER_SAME) {
                lottoSameCount.put(SECOND_PLACE,
                        lottoSameCount.get(SECOND_PLACE) + PLUS_WINNING_COUNT);
                return;
            }
            lottoSameCount.put(SECOND_PLACE,
                    lottoSameCount.get(SECOND_PLACE) + PLUS_WINNING_COUNT);
            return;
        }
        saveExceptSixSameCountResult(sameTotalCount);
    }

    private void saveExceptSixSameCountResult(int sameTotalCount) {
        if (sameTotalCount == WINNING_COUNT_FIVE) {
            lottoSameCount.put(LottoWinnings.THIRD_PLACE,
                    lottoSameCount.get(LottoWinnings.THIRD_PLACE) + PLUS_WINNING_COUNT);
            return;
        }
        saveExceptionTwoTopSameCountResult(sameTotalCount);
    }

    private void saveExceptionTwoTopSameCountResult(int sameTotalCount) {
        if (sameTotalCount == WINNING_COUNT_FOUR) {
            lottoSameCount.put(LottoWinnings.FOURTH_PLACE,
                    lottoSameCount.get(LottoWinnings.FOURTH_PLACE) + PLUS_WINNING_COUNT);
            return;
        }
        lottoSameCount.put(LottoWinnings.FIFTH_PLACE,
                lottoSameCount.get(LottoWinnings.FIFTH_PLACE) + PLUS_WINNING_COUNT);
    }

    public String printTotalWinningCount() {
        StringBuilder sb = new StringBuilder();
        List<LottoWinnings> lottoWinnings = new ArrayList<>(lottoSameCount.keySet());
        lottoWinnings.sort(Comparator.comparing(LottoWinnings::getLottoWinnings));
        for (LottoWinnings lottoWinning : lottoWinnings) {
            sb.append(LOTT_WINNING_RESULT.format(lottoWinning.getLottoWinnings(), lottoSameCount.get(lottoWinning)));
            sb.append(NEW_LINE.getText());
        }
        return sb.toString();
    }

    public String calculateEarningRate(int purchasePrice) {
        double earningRate = INIT_EARNING_RATE;
        for (Map.Entry<LottoWinnings, Integer> winnings : LOTTO_WINNINGS.entrySet()) {
            earningRate += winnings.getValue() * lottoSameCount.get(winnings.getKey());
        }
        earningRate = earningRate / purchasePrice;
        earningRate *= PERCENT_VALUE;
        return LOTTO_EARNING_RATES.format(earningRate);
    }

}
