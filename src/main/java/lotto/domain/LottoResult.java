package lotto.domain;

public enum LottoResult {

    SIX_MATCH(6, "2,000,000,000",2000000000,false),
    FIVE_MATCH_BONUS(5, "30,000,000",30000000,true),
    FIVE_MATCH(5, "1,500,000",1500000,false),
    FOUR_MATCH(4, "50,000",50000,false),
    THREE_MATCH(3, "5,000",5000,false),
    NO_MATCH(0, "0",0,false);


    private final Integer matchCount;
    private final String priceText;
    private final Integer price;
    private final boolean isBonusMatch;

    LottoResult(Integer matchCount, String priceText, Integer price, boolean isBonusMatch){
        this.matchCount = matchCount;
        this.priceText = priceText;
        this.price = price;
        this.isBonusMatch = isBonusMatch;
    }

    public int getMatchCount(){
        return matchCount;
    }

    public String getPriceText(){
        return priceText;
    }

    public Integer getPrice(){
        return price;
    }

    public static LottoResult of(Integer matchCount, boolean isBonusMatch){
        if (matchCount == 6) return SIX_MATCH;
        if (matchCount == 5 && isBonusMatch) return FIVE_MATCH_BONUS;
        if (matchCount == 5 && !isBonusMatch) return FIVE_MATCH;
        if (matchCount == 4) return FOUR_MATCH;
        if (matchCount == 3) return THREE_MATCH;

        return NO_MATCH;
    }
}
