package lotto.validator;

import lotto.constant.ErrorConstants;

import java.util.List;

public class WinningNumberValidator {

    public void validateWinningNumber(List<String> parsedInput){
        for(String element: parsedInput){
            checkElementIsNumber(element);
        }
    }

    private void checkElementIsNumber(String element){
        try{
            Integer.parseInt(element);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorConstants.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }




}
