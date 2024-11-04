package lotto.ui;

import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.LottoResult;
import lotto.model.Rank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static lotto.constants.LottoConstants.ZERO;
import static lotto.constants.RankConstants.*;
import static lotto.constants.ResultConstants.*;

public class ResultViewImpl implements ResultView {
    @Override
    public void displayLottos(List<Lotto> lottos) {
        System.out.printf(LOTTO_PURCHASE_MESSAGE, lottos.size());
        System.out.println();
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    @Override
    public void printResult(LottoGame lottoGame) {
        System.out.println(LOTTO_WINNING_STATISTICS);
        System.out.println(LOTTO_STATISTICS_DIVIDER);
        printLottoResult(lottoGame.getLottoResult());
        printReturnRate(lottoGame);
    }

    private void printLottoResult(LottoResult lottoResult) {
        StringBuilder result = new StringBuilder();
        Map<Rank, Long> rankCount = lottoResult.getRankCount();
        appendRank(result, rankCount, Rank.FIFTH, FIFTH_RANK_MESSAGE);
        appendRank(result, rankCount, Rank.FOURTH, FOURTH_RANK_MESSAGE);
        appendRank(result, rankCount, Rank.THIRD, THIRD_RANK_MESSAGE);
        appendRank(result, rankCount, Rank.SECOND, SECOND_RANK_MESSAGE);
        appendRank(result, rankCount, Rank.FIRST, FIRST_RANK_MESSAGE);
        System.out.println(result.toString());
    }


    private void appendRank(StringBuilder result, Map<Rank, Long> rankCount, Rank rank, String description) {
        result.append(String.format(LOTTO_RESULT_FORMAT, description, rankCount.getOrDefault(rank, ZERO)));
    }

    private void printReturnRate(LottoGame lottoGame) {
        double rate = lottoGame.calculateRate();
        String formattedRate = formatRate(rate);
        System.out.printf(RETURN_RATE_MESSAGE, formattedRate);
    }

    public String formatRate(double rate) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        return decimalFormat.format(rate) + "%";
    }
}
