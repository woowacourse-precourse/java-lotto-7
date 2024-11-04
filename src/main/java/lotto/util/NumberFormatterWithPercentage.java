package lotto.util;

public class NumberFormatterWithPercentage implements NumberFormatter{

    @Override
    public String formatNumber(double number){
        return String.format("%.1f", number);
    }
}
