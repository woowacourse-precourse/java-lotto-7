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

    public static void printResults(GradeSaver grades){
        System.out.println("당첨 통계\n" + "---");
        System.out.println("3개 일치 (5,000원) - " + grades.getThird() + "개");
        System.out.println("4개 일치 (50,000원) - " + grades.getFourth() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + grades.getFifth() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " +grades.getFifthBonus() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + grades.getSixth() + "개");
    }

    public static Integer getRevenue(GradeSaver grades){
        int revenue = 0;
        revenue += grades.getThird() * 5000;
        revenue += grades.getFourth() * 50000;
        revenue += grades.getFifth() * 1500000;
        revenue += grades.getFifthBonus() * 30000000;
        revenue += grades.getSixth() * 2000000000;
        return revenue;
    }
}
