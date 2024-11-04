package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {
    List<Grade> grades = new ArrayList<>();
    private int match3_count = 0;
    private int match4_count = 0;
    private int match5_count = 0;
    private int match5_bonus_count = 0;
    private int match6_count = 0;

    public LottoCalculator(List<Grade> grades) {
        this.grades = grades;
    }

    public LottoStatistics calculate(int price) {
        for (Grade grade : grades) {
            calculateCount(grade);
        }
        double rate = calculateReturnRate(price);
        return new LottoStatistics(match3_count, match4_count, match5_count, match5_bonus_count, match6_count, rate);
    }

    public void calculateCount(Grade grade){
        if(grade == Grade.MATCH3){
            match3_count++;
        }
        if(grade == Grade.MATCH4){
            match4_count++;
        }
        if(grade == Grade.MATCH5){
            match5_count++;
        }
        if(grade == Grade.MATCH5_BONUS){
            match5_bonus_count++;
        }
        if(grade == Grade.MATCH6){
            match6_count++;
        }
    }

    private double calculateReturnRate(int price) {
        int priceTotal = 0;
        priceTotal = priceTotal + match3_count * Grade.MATCH3.getPrice();
        priceTotal = priceTotal + match4_count * Grade.MATCH4.getPrice();
        priceTotal = priceTotal + match5_count * Grade.MATCH5.getPrice();
        priceTotal = priceTotal + match5_bonus_count * Grade.MATCH5_BONUS.getPrice();
        priceTotal = priceTotal + match6_count * Grade.MATCH6.getPrice();
        double result = (double) (priceTotal-price) / price;
        return Math.round(result * 10) / 10.0;
    }
}
