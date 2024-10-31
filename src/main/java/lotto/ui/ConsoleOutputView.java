package lotto.ui;

import lotto.domain.entity.Lottos;
import lotto.domain.type.LottoRank;

import java.util.List;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printLottos(final Lottos lottos) {
        System.out.println(lottos.getLottos().size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> {
            System.out.println(lotto.toString());
        });
    }

    @Override
    public void winningStats(final List<LottoRank> ranks) {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
