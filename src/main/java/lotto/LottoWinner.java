package lotto;


public class LottoWinner {
    private Integer amountCriteria;
    private Integer winPrize;
    private String bonusBallMent = "개 일치";
    private Integer winAmount;

    public Integer getAmountCriteria() {
        return amountCriteria;
    }

    public Integer getWinPrize() {
        return winPrize;
    }

    public Integer getWinAmount() {
        return winAmount;
    }

    public String getBonusBallMent() {
        return bonusBallMent;
    }

    public void setAmountCriteria(Integer amountCriteria) {
        this.amountCriteria = amountCriteria;
    }

    public void setWinPrize(Integer winPrize) {
        this.winPrize = winPrize;
    }

    public void setBonusBallMent(String ment) {
        this.bonusBallMent = ment;
    }

    public void setWinAmount(Integer winAmount) {
        this.winAmount = winAmount;
    }
}
