package lotto.view;

import lotto.model.domain.Lotto;
import lotto.model.domain.Lottos;
import lotto.model.domain.Rate;

import java.util.Map;

public class LottoView implements LottoViewInterface{

    @Override
    public void printTotalLottoCount(int LottoCount) {
        System.out.println("\n"+LottoCount +"개를 구매했습니다.");
    }

    @Override
    public void printCreatedLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    @Override
    public void printRateStatus(Rate rate) {
        StringBuilder rateOutput = new StringBuilder();
        Map<String, Integer> matchStatus = rate.getMatchStatus();

        rateOutput.append("\n당첨 통계\n");
        rateOutput.append("---\n");

        rateOutput.append("3개 일치 (5,000원) - ").append(matchStatus.get("three_match")).append("개\n");
        rateOutput.append("4개 일치 (50,000원) - ").append(matchStatus.get("four_match")).append("개\n");
        rateOutput.append("5개 일치 (1,500,000원) - ").append(matchStatus.get("five_match")).append("개\n");
        rateOutput.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(matchStatus.get("five_bonus_match")).append("개\n");
        rateOutput.append("6개 일치 (2,000,000,000원) - ").append(matchStatus.get("six_match")).append("개");

        System.out.println(rateOutput);
    }

    @Override
    public void printRateReturn(double returnPrize) {
        System.out.println("총 수익률은 " + returnPrize + "%입니다.");
    }


}
