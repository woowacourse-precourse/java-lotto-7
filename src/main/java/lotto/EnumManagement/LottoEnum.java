package lotto.EnumManagement;

public enum LottoEnum {
    LOTTO_PRICE_5TH(5000),
    LOTTO_PRICE_4TH(50000),
    LOTTO_PRICE_3TH(1500000),
    LOTTO_PRICE_2ND(30000000),
    LOTTO_PRICE_1ST(2000000000),
    DIVIDE_100(100),
    LOTTO_WINNING_SIZE(5),
    EQUAL_LOTTO_NUMBER_5(5),
    NUMBER_TABLE_INDEX_3(3),
    NUMBER_TABLE_INDEX_6(6),
    LOTTO_WINNING(1);


    private final int number;

    LottoEnum(int number){
        this.number = number;
    }


    public int getNumber(){
        return number;
    }

}
