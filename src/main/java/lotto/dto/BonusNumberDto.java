package lotto.dto;

import lotto.exception.LottoExceptionStatus;

public record BonusNumberDto(
        int bonusNumber
) {

    public BonusNumberDto{
        validate(bonusNumber);
    }

    private void validate(int bonusNumber){
        if(isOutOfRange(bonusNumber)){
            throw new IllegalArgumentException(LottoExceptionStatus.INVALID_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(int number){
        return number < 1 || number > 45;
    }

    public static BonusNumberDto from(String input){
        return new BonusNumberDto(Integer.parseInt(input));
    }
}
