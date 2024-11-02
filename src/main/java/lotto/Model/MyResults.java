package lotto.Model;

public class MyResults {
    private Integer matches;//몇개 맞췄는지
    private Boolean isBonus;//보너스 맞췄는지

    public MyResults(Integer matches, Boolean bonusPoint) {
        this.matches = matches;
        this.isBonus = bonusPoint;
    }

    public Integer getMatches() {
        return matches;
    }

    public Boolean getIsBonus() {
        return isBonus;
    }
}
