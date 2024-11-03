package lotto;

import lotto.exception.ErrorCode;

public class SpecialNumber {

    private int specialNumber;

    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_FINAL_NUM = 45;

    public SpecialNumber(String specialNumber){
        validate(specialNumber);
        this.specialNumber = Integer.valueOf(specialNumber);
    }

    private void validate(String specialNumber){
        try{
            int specialNum = Integer.valueOf(specialNumber);

            if(specialNum>LOTTO_FINAL_NUM || specialNum < LOTTO_START_NUM){
                throw new IllegalArgumentException(ErrorCode.LOTTO_NUMBER_MUST_BE_IN_CORRECT_RANGE.getMessage());
            }
        } catch (Exception e){
            throw new IllegalArgumentException(ErrorCode.CANT_CONVERT_TO_INTEGER.getMessage());
        }

    }

    public int getSpecialNumber(){
        return this.specialNumber;
    }
}
