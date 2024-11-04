package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.util.LottoPrizeRankType;

//enum
public class LottoView {

    protected LottoView() {
    }

    public String purchaseLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public void displayPurchasedLotto(final List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매하셨습니다.");
        lottoTickets.forEach(lotto ->
                System.out.println(lotto.getNumbers()));
    }

    public String getWinningLottoNumbers() {
        System.out.println("당첨번호 6자리를 쉼표(,)로 구분하여 입력하세요");
        return Console.readLine();
    }

    public String getBonusLottoNumbers() {
        System.out.println("보너스 번호를 입력해주세요.");
        return Console.readLine();
    }

    public void displayLottoResults(final LottoResultDto lottoResult) {
        final Map<LottoPrizeRankType, Long> rankLotto = lottoResult.rankLotto();
        final float rateOfReturn = lottoResult.rateOfReturn();
        System.out.println("당첨 통계");
        System.out.println("-------");
        for (Entry<LottoPrizeRankType, Long> rank : rankLotto.entrySet()) {
            System.out.printf("%d개 일치 (%,d원) - %d개 %n",
                    rank.getKey().getMatchCount(), rank.getKey().getPrizeMoney(), rank.getValue());
        }
        System.out.printf("총 수익률은 %.1f%%", rateOfReturn);
    }
}
