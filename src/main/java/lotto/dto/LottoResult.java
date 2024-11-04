package lotto.dto;

public class LottoResult {
    private final double returnOnInvestment;
    private final String winningResult;

    public LottoResult(double returnOnInvestment, String winningResult) {
        this.returnOnInvestment = returnOnInvestment;
        this.winningResult = winningResult;
    }

    public double getReturnOnInvestment() {
        return returnOnInvestment;
    }

    public String getWinningResult() {
        return winningResult;
    }
}
