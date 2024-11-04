package lotto.enums;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Stream;

public enum LottoPrices {
    FIRST(6,2000000000),
    SECOND(5,30000000),
    THIRD(5,1500000),
    FOURTH(4,50000),
    FIFTH(3,5000),
    NOT_EARN(0,0);

    private final int price;
    private final int matchedCount;

    LottoPrices(int matchedCount, int price) {
        this.matchedCount = matchedCount;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
    public int getMatchedCount() {
        return this.matchedCount;
    }
    public String getString(){
        String price = new DecimalFormat("###,###").format(getPrice());
        String bonus = "";

        if(this.equals(SECOND)){
            bonus = ", 보너스 볼 일치";
        }

        return getMatchedCount()+"개 일치" +bonus+" ("+price+"원) - ";
    }
    public static List<LottoPrices> getPrices(){
        return Stream.of(LottoPrices.values()).sorted((o1,o2)->o1.price-o2.price).toList();
    }
    public static LottoPrices findPriceByMatchCount(int matchCount, boolean bonusMatched) {
        if (matchCount == 5 && bonusMatched) {
            return LottoPrices.SECOND;
        }

        return switch (matchCount) {
            case 6 -> LottoPrices.FIRST;
            case 5 -> LottoPrices.THIRD;
            case 4 -> LottoPrices.FOURTH;
            case 3 -> LottoPrices.FIFTH;
            default -> LottoPrices.NOT_EARN;
        };
    }

}
