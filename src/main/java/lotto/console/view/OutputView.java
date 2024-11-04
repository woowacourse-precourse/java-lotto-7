package lotto.console.view;

import java.math.BigDecimal;
import java.util.List;
import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.LottoResult;
import lotto.user.domain.User;

public class OutputView {


    public void printUserLottos(User user) {
        List<Lotto> lottos = user.getLottos();
        System.out.println(lottos.size() + "개를 구매했습니다.");

        lottos.forEach(this::printLotto);
    }

    private void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }

    public void printResults(List<LottoResult> result) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println(
                "3개 일치 (5,000원) - " + result.stream().filter(lottoResult -> lottoResult == LottoResult.FIFTH).count()
                        + "개");
        System.out.println(
                "4개 일치 (50,000원) - " + result.stream().filter(lottoResult -> lottoResult == LottoResult.FOURTH).count()
                        + "개");
        System.out.println(
                "5개 일치 (1,500,000원) - " + result.stream().filter(lottoResult -> lottoResult == LottoResult.THIRD)
                        .count()
                        + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.stream()
                .filter(lottoResult -> lottoResult == LottoResult.SECOND).count() + "개");
        System.out.println(
                "6개 일치 (2,000,000,000원) - " + result.stream().filter(lottoResult -> lottoResult == LottoResult.FIRST)
                        .count() + "개");
    }

    public void printProfitRation(BigDecimal ratio) {
        System.out.println("총 수익률은 " + ratio + "%입니다.");
    }
}
