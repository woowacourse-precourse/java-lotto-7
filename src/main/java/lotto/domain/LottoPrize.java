package lotto.domain;

public enum LottoPrize {

    FIRST( "2,000,000,000"),
    SECOND("30,000,000"),
    THIRD("1,500,000"),
    FOURTH("50,000"),
    FIFTH("5,000"),
    NONE("0");



    private final String price;

    LottoPrize(String price){
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public long getPriceValue(){
        try {
            return Long.valueOf(price.replace(",",""));
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR]: 처리 중 오류가 발생했습니다.");
        }
    }
}
