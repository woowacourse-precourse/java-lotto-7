package lotto.domain.view;

import lotto.domain.model.user.Lotto;
import lotto.domain.model.user.LottoRank;
import lotto.domain.model.lotto.result.LottoSummary;
import lotto.domain.model.user.User;

import java.util.List;

import static lotto.common.constant.PrintFormatConst.*;


public class OutputView {

    public void printLottos(List<Lotto> lottos) {
        System.out.printf(LOTTO_PURCHASE_COUNT_FORMAT, lottos.size());
        lottos.stream()
                .map(Lotto::print)
                .forEach(System.out::println);
    }

    public void printLottoSummary(LottoSummary summary) {
        for (LottoRank eachRank : LottoRank.getWinningRanks()) {
            Long winningCount = summary.getWinningCount(eachRank, 0L);
            System.out.printf(VIEW_PRINT_FORMAT, eachRank.getPrintFormat(), winningCount);
        }
    }

    public void printUserProfitRate(User user) {
        System.out.printf(VIEW_PROFIT_PRINT_FORMAT, user.getProfitRate());
    }
}
