package lotto.view;

import java.util.List;

public class OutputView {
    public static final String LINE_SEPARATOR = System.lineSeparator();

    public void printPurchasedLottoList(List<LottoDto> lottos) {
        int count = lottos.size();
        System.out.printf("%,d개를 구매했습니다." + LINE_SEPARATOR, count);
        for (LottoDto lotto : lottos) {
            System.out.print(lotto + LINE_SEPARATOR);
        }
    }

    public void printLottoStatistics(LottoStatisticsDto lottoStatistics) {
        System.out.print("당첨 통계" + LINE_SEPARATOR);
        System.out.print("---" + LINE_SEPARATOR);
        System.out.print(lottoStatistics.toString());
    }
}
