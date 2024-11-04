package lotto.view;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.constant.ViewMessages;
import lotto.model.domain.LottoRank;
import lotto.model.domain.Pocket;

public class OutputView {
    private OutputView() {
    }

    public static void printRequestMoney() {
        System.out.println(ViewMessages.PRINT_REQUEST_MONEY.getMessage());
    }

    public static void printRequestLottoWinningNumbers() {
        System.out.println(ViewMessages.PRINT_REQUEST_LOTTO_WINNING_NUMBERS.getMessage());
    }

    public static void printRequestLottoBonusNumber() {
        System.out.println(ViewMessages.PRINT_REQUEST_LOTTO_BONUS_NUMBERS.getMessage());
    }

    public static void printPurchasedLottoCount(Pocket pocket) {
        int sizeOfLottos = pocket.getLottos().size();
        System.out.println(sizeOfLottos + ViewMessages.PRINT_PURCHASED_LOTTO_COUNT.getMessage());
        for (int i = 0; i < sizeOfLottos; i++) {
            List<Integer> numbers = new ArrayList<>(
                    pocket.getLottos().get(i).getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printRewardStatistic(Map<Integer, Integer> rewardRankResult) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        rewardRankResult.forEach((rank, count) -> {
            LottoRank lottoRank = LottoRank.findByRank(rank);

            if (lottoRank == LottoRank.DEFAULT) {
                return;
            } else if (lottoRank == LottoRank.SECOND) {
                printSecondRewardStatistic(
                        lottoRank.getMatchCount(),
                        numberFormat.format(lottoRank.getPrize()),
                        count
                );
                return;
            }
            printDefaultRewardStatistic(
                    lottoRank.getMatchCount(),
                    numberFormat.format(lottoRank.getPrize()),
                    count
            );
        });
    }

    public static void printProfitAtSecondDecimals(long reward, int money) {
        NumberFormat numberFormat = NumberFormat.getInstance();

        float profitRatio = getProfitRatio((float) reward, money);
        float profitRateAtSecondDecimals = getProfitRateAtSecondDecimals(profitRatio);

        System.out.println(
                ViewMessages.PRINT_PROFIT.getMessage() + numberFormat.format(profitRateAtSecondDecimals) + "%입니다.");
    }

    private static void printSecondRewardStatistic(int matchNumberCount, String prize, int count) {
        System.out.println(matchNumberCount +
                ViewMessages.PRINT_REWARD_SECOND_RANK_STATISTIC_FIRST.getMessage() +
                prize + ViewMessages.PRINT_REWARD_STATISTIC_SECOND.getMessage() +
                count + ViewMessages.PRINT_REWARD_STATISTIC_LAST.getMessage());
    }

    private static void printDefaultRewardStatistic(int matchNumberCount, String prize, int count) {
        System.out.println(matchNumberCount +
                ViewMessages.PRINT_REWARD_STATISTIC_FIRST.getMessage() +
                prize + ViewMessages.PRINT_REWARD_STATISTIC_SECOND.getMessage() +
                count + ViewMessages.PRINT_REWARD_STATISTIC_LAST.getMessage());
    }

    private static float getProfitRateAtSecondDecimals(float profitRatio) {
        return Math.round(profitRatio * 100) / 100.0f;
    }

    private static float getProfitRatio(float reward, int money) {
        return reward / money * 100;
    }

}
