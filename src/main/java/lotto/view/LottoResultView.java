package lotto.view;

import lotto.model.LottoRank;

public class LottoResultView implements View {

    private final LottoRank rank;
    private final double rateOfReturn;

    public LottoResultView(LottoRank rank, double calcRateOfReturn) {
        this.rank = rank;
        this.rateOfReturn = calcRateOfReturn;
    }

    @Override
    public String render() {
        return "\n당첨 통계" +
                "\n---" +
                "\n3개 일치 (5,000원) - " + rank.getCnt(5)+ "개" +
                "\n4개 일치 (50,000원) - " + rank.getCnt(4) + "개" +
                "\n5개 일치 (1,500,000원) - " + rank.getCnt(3) + "개" +
                "\n5개 일치, 보너스 볼 일치 (30,000,000원) - " + rank.getCnt(2) + "개" +
                "\n6개 일치 (2,000,000,000원) - " + rank.getCnt(1) + "개" +
                "\n총 수익률은 " + rateOfReturn + "%입니다.";

    }
}
