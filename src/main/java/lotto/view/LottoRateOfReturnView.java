package lotto.view;

public class LottoRateOfReturnView {

    public LottoRateOfReturnView() {
    }

    public void announce(double rateOfReturn) {
        double percent = rateToPercent(rateOfReturn);

        System.out.println("총 수익률은 " + Math.round(percent * 100.0) / 100.0 + "%입니다.");
    }

    private double rateToPercent(double rateOfReturn) {
        return rateOfReturn * 100;
    }
}
