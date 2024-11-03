package lotto.view;

public class LottoResultView implements View {

    private final int[] matchCnts;
    private final double rateOfReturn;

    public LottoResultView(int[] matchCnts, double calcRateOfReturn) {
        this.matchCnts = matchCnts;
        this.rateOfReturn = calcRateOfReturn;
    }

    @Override
    public String render() {
        return "\n당첨 통계" +
                "\n---" +
                "\n3개 일치 (5,000원) - " + matchCnts[5] + "개" +
                "\n4개 일치 (50,000원) - " + matchCnts[4] + "개" +
                "\n5개 일치 (1,500,000원) - " + matchCnts[3] + "개" +
                "\n5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCnts[2] + "개" +
                "\n6개 일치 (2,000,000,000원) - " + matchCnts[1] + "개" +
                "\n총 수익률은 " + rateOfReturn + "%입니다.";

    }
}
