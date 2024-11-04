package lotto.utils;

public enum NumberConstants {
    LOTTO_PRICE(1000),
    LOTTO_COUNT(6),
    START_NUMBER(1),
    END_NUMBER(45);
    private int number;
    NumberConstants(int number){
        this.number = number;
    }
    public int getNumber(){
        return number;
    }
}
