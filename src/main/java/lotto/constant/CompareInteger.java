package lotto.constant;

public enum CompareInteger {
    PRICE_LOTTO(1000),
    PRICE_MINIMUM(1000),
    PRICE_MAXIMUM(100000),
    ZERO(0);

    private final Integer number;

    CompareInteger(Integer number){
        this.number = number;
    }

    public Integer getNumber(){
        return number;
    }
}
