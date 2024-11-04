package lotto.dto;

public class LottoResultDto {
    private int threeMatchCount = 0;
    private int fourMatchCount = 0;
    private int fiveMatchCount = 0;
    private int fiveAndBonusMatchCount = 0;
    private int sixMatchCount = 0;
    private  double profitRate;

    public LottoResultDto() {
    }

    public void plusThreeMatchCount() {
        threeMatchCount++;
    }

    public void plusFourMatchCount() {
        fourMatchCount++;
    }

    public void plusFiveAndBonusMatchCount() {
        fiveAndBonusMatchCount++;
    }

    public void plusFiveMatchCount() {
        fiveMatchCount++;
    }

    public void plusSixMatchCount() {
        sixMatchCount++;
    }

    public int getThreeMatchCount() {
        return threeMatchCount;
    }

    public int getFourMatchCount() {
        return fourMatchCount;
    }

    public int getFiveMatchCount() {
        return fiveMatchCount;
    }

    public int getFiveAndBonusMatchCount() {
        return fiveAndBonusMatchCount;
    }

    public int getSixMatchCount() {
        return sixMatchCount;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(double profitRate){
        this.profitRate = profitRate;
    }
}
