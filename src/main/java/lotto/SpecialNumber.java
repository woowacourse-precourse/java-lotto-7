package lotto;

import lotto.exception.ErrorCode;

public class SpecialNumber {

    private int number;

    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_FINAL_NUM = 45;

    public SpecialNumber(String number){
        validate(number);
        this.number = Integer.valueOf(number);
    }

    private void validate(String number){
        try{
            int num = Integer.valueOf(number);

            if(num>LOTTO_FINAL_NUM || num < LOTTO_START_NUM){
                throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_MUST_BE_IN_CORRECT_RANGE.getMessage());
            }
        } catch (Exception e){
            throw new IllegalArgumentException(ErrorCode.CANT_CONVERT_TO_INTEGER.getMessage());
        }

    }

    public int getNumber(){
        return this.number;
    }
}
