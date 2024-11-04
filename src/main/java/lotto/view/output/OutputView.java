package lotto.view.output;

import java.util.List;
import lotto.model.lotto.lottoNumber.Lotto;
import lotto.model.lotto.lottoNumber.Lottos;
import lotto.model.lotto.winningResult.rank.Rank;
import lotto.model.lotto.winningResult.WinningResults;

public class OutputView {
    public void outputExceptionMessage(String message) {
        System.out.println(message);
    }

    public void outputIssuedLottos(Lottos lottos) {
        outputLottoAmount(lottos);
        for (Lotto lotto : lottos.lottos()) {
            List<Integer> ascendingLotto = Sorter.sortAscending(lotto.getNumbers());
            System.out.println(Messages.ISSUED_LOTTO(ascendingLotto));
        }
    }

    private void outputLottoAmount(Lottos lottos) {
        System.out.println(System.lineSeparator() +
                String.format("%d개를 구매했습니다.", lottos.lottos().size()));
    }

    public void outputWinningResultStartLine() {
        System.out.println(System.lineSeparator() + "당첨 통계");
        System.out.println(System.lineSeparator() + "---");
    }

    public void outputWinningRanks(WinningResults winningResults) {
        List<Rank> descendingRanks = Sorter.sortDescending(Rank.findRanksExceptFail());
        for (Rank rank : descendingRanks) {
            System.out.println(String.format(
                    "%s (%s원) - %d개"
                    , Messages.MATCHING_CONDITION(rank)
                    , Messages.PRICE(rank.getPrice())
                    , winningResults.findLottoAmountByRank(rank)
            ));
        }
    }

    public void outputEarningsRate(double earningsRate) {
        System.out.println(String.format(
                "총 수익률은 %.1f%%입니다."
                , Math.round(earningsRate * 10) / 10.0
        ));
    }
}
