package lotto;

public class MyResult {
    private Integer matches;//몇개 맞췄는지
    private Boolean bonusPoint;//보너스 맞췄는지
    private String price;//총 탄 금액

    public MyResult(Integer matches, Boolean bonusPoint) {
        this.matches = matches;
        this.bonusPoint = bonusPoint;
        if(this.matches == 1) this.price = "0";
        else if(this.matches == 2) this.price = "0";
        else if(this.matches == 3) this.price = "5,000";
        else if(this.matches == 4) this.price = "50,000";
        else if(this.matches == 5 && bonusPoint) this.price = "30,000,000";
        else if(this.matches == 5 && !bonusPoint) this.price = "1,500,000";
        else if(this.matches == 6) this.price = "2,000,000,000";
    }

    public Integer getMatches() {
        return matches;
    }
    public String getPrice() {
        return price;
    }
    public Boolean getBonusPoint() {
        return bonusPoint;
    }



}
