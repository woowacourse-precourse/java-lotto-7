package lotto.view;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.model.domain.LottoRank;
import lotto.model.domain.Pocket;

public class OutputView {
    private OutputView() {
    }

    public static void printRequestMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printRequestLottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printRequestLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printPurchasedLottoCount(Pocket pocket) {
        int sizeOfLottos = pocket.getLottos().size();
        System.out.println(sizeOfLottos + "개를 구매했습니다.");
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

        System.out.println("총 수익률은 " + numberFormat.format(profitRateAtSecondDecimals) + "%입니다.");
    }

    private static void printSecondRewardStatistic(int matchNumberCount, String prize, int count) {
        System.out.println(matchNumberCount + "개 일치, 보너스 볼 일치 (" +
                prize + "원) - " +
                count + "개");
    }

    private static void printDefaultRewardStatistic(int matchNumberCount, String prize, int count) {
        System.out.println(matchNumberCount + "개 일치 (" +
                prize + "원) - " +
                count + "개");
    }

    private static float getProfitRateAtSecondDecimals(float profitRatio) {
        return Math.round(profitRatio * 100) / 100.0f;
    }

    private static float getProfitRatio(float reward, int money) {
        return reward / money * 100;
    }

}
