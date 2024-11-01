package lotto;

public class MyResult {
    private Integer matches;//몇개 맞췄는지
    private Boolean bonusPoint;//보너스 맞췄는지

    public MyResult(Integer matches, Boolean bonusPoint) {
        this.matches = matches;
        this.bonusPoint = bonusPoint;
    }

    public Integer getMatches() {
        return matches;
    }

    public Boolean getBonusPoint() {
        return bonusPoint;
    }

    public static Integer getMyRevenue(WinningDetails grades){
        int revenue = 0;
        revenue += grades.getThird() * 5000;
        revenue += grades.getFourth() * 50000;
        revenue += grades.getFifth() * 1500000;
        revenue += grades.getFifthBonus() * 30000000;
        revenue += grades.getSixth() * 2000000000;
        return revenue;
    }

    public static double getReturn(Integer purchasePrice, Integer revenue){
        double myReturn = (double)revenue / (double)purchasePrice * 100;
        return Math.round(myReturn * 100)/100.0;
    }
}
