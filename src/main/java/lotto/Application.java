package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.machine.LottoMachine;
import lotto.domain.machine.impl.RandomNumberGenerator;
import lotto.domain.machine.Ticket;
import lotto.domain.machine.impl.SimpleNumberGenerator;
import lotto.domain.winning.Rank;
import lotto.domain.winning.WinningNumber;
import lotto.domain.winning.WinningStatistics;

public class Application {

    public static void main(String[] args) {
        int money = 2100000000;
        int count = new Ticket(money).getCount();
        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());
        List<Lotto> lottos = lottoMachine.issueLottos(count);

        // 당첨 번호
        SimpleNumberGenerator simpleNumberGenerator = new SimpleNumberGenerator();
        simpleNumberGenerator.setNumbers(List.of(11, 24, 23, 41, 35, 6));

        LottoMachine winningLottoMachine = new LottoMachine(simpleNumberGenerator);
        Lotto winningLotto = winningLottoMachine.issueLotto();
        int bonusNumber = 7;

        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusNumber);

        System.out.println("당첨 통계");
        System.out.println("---");
        WinningStatistics winningStatistics = new WinningStatistics();
        for (Lotto lotto : lottos) {
            Rank rank = winningNumber.match(lotto);
            winningStatistics.addWinCountByRank(rank);
        }
        for (Rank value: Rank.values()) {
            if (value == Rank.LAST) {
                continue;
            }
            if (value == Rank.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                        value.getMatchCount(),
                        value.getPrizeMoney(),
                        winningStatistics.getCountByRank(value));
            } else {
                System.out.printf("%d개 일치 (%d원) - %d개\n",
                        value.getMatchCount(),
                        value.getPrizeMoney(),
                        winningStatistics.getCountByRank(value));
            }
        }

        BigDecimal earningRate = winningStatistics.getTotalPrize()
                .divide(BigDecimal.valueOf(money), 2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100));

        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningRate);
    }

}
