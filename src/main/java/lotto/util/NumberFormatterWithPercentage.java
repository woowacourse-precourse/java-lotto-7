package lotto.util;

public class NumberFormatterWithPercentage implements NumberFormatter{

    @Override
    public String formatNumber(double number){
        return String.format("%,d", number);
    }
}
