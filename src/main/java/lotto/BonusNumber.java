package lotto;

import lotto.exception.ErrorCode;

public class BonusNumber {

    private int number;

    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_FINAL_NUM = 45;

    public BonusNumber(String number){
        validate(number);
        this.number = Integer.valueOf(number);
    }

    private void validate(String number){
        try{
            int num = Integer.valueOf(number);

            if(num>LOTTO_FINAL_NUM || num < LOTTO_START_NUM){
                throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorCode.FAILED_TO_PARSE_INTEGER.getMessage());
        }

    }

    public int getNumber(){
        return this.number;
    }
}