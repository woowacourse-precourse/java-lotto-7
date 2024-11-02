package lotto.utils;

public enum NumberConstants {
    LOTTO_PRICE(1000);
    private int number;
    NumberConstants(int number){
        this.number = number;
    }
    public int getNumber(){
        return number;
    }
}
