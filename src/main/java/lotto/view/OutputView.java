package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoRanks;
import lotto.domain.Lottos;
import lotto.domain.PurchasedPrice;
import lotto.utils.Calculate;

import javax.xml.transform.stream.StreamSource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {

    public static void printPurchasedLottos(Lottos purchasedLottos) {
        String output = "\n" + purchasedLottos.getLottoCount() + "개를 구매했습니다.\n" +
                purchasedLottos.getLottos().stream()
                                .map(lotto -> lotto.getNumbers().toString())
                                        .collect(Collectors.joining("\n"));

        System.out.println(output);
        System.out.println();
    }

    public static void printResult(LottoRanks lottoRanks, PurchasedPrice purchasedPrice) {
        StringBuilder output = new StringBuilder();
        output.append("\n당첨 통계\n---\n");

        for (LottoRank lottoRank : lottoRanks.getRanks()) {
            output.append(lottoRank.getRequiredMatchCount()).append("개 일치");

            if (lottoRank.getRequiresBonus()) {
                output.append(", 보너스 볼 일치");
            }

            output.append(String.format(" (%,d원) - %d개%n",
                    lottoRank.getPrize(),
                    lottoRank.getWinningCount()));
        }

        output.append(String.format("총 수익률은 %.1f%%입니다.%n", Calculate.profitRate(lottoRanks, purchasedPrice)));

        System.out.print(output);
    }
}
