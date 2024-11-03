package lotto.data;

public class Result {
    private Integer threeNumberMatch;
    private Integer fourNumberMatch;
    private Integer fiveNumberMatch;
    private Integer bonusNumberMatch;
    private Integer sixNumberMatch;

    public Result() {
        this.threeNumberMatch = 0;
        this.fourNumberMatch = 0;
        this.fiveNumberMatch = 0;
        this.bonusNumberMatch = 0;
        this.sixNumberMatch = 0;
    }

    public void addThreeNumberMatch() {
        this.threeNumberMatch++;
    }

    public void addFourNumberMatch() {
        this.fourNumberMatch++;
    }

    public void addFiveNumberMatch() {
        this.fiveNumberMatch++;
    }

    public void addBonusNumberMatch() {
        this.bonusNumberMatch++;
    }

    public void addSixNumberMatch() {
        this.sixNumberMatch++;
    }

    public Integer getThreeNumberMatch() {
        return threeNumberMatch;
    }

    public Integer getFourNumberMatch() {
        return fourNumberMatch;
    }

    public Integer getFiveNumberMatch() {
        return fiveNumberMatch;
    }

    public Integer getBonusNumberMatch() {
        return bonusNumberMatch;
    }

    public Integer getSixNumberMatch() {
        return sixNumberMatch;
    }
}
