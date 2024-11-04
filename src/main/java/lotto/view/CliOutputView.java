package lotto.view;

import java.text.DecimalFormat;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.LottoStatisticsDto;

public class CliOutputView {

    void printLottos(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        Lotto sortedLotto = lotto.getSortedLotto();

        String numbers = convertLottoNumbersToString(sortedLotto);

        System.out.println("[" + numbers + "]");
    }

    private String convertLottoNumbersToString(Lotto sortedLotto) {
        return sortedLotto.getNumbers().stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", "));
    }

    public void printResult(LottoStatisticsDto lottoStatisticsDto) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5,000원) - " + lottoStatisticsDto.fifthCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoStatisticsDto.fourthCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoStatisticsDto.thirdCount() + "개");
        System.out.println(
            "5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoStatisticsDto.secondCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoStatisticsDto.firstCount() + "개");

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("총 수익률은 " + df.format(lottoStatisticsDto.profitRate()) + "%입니다.");
    }
}
