package lotto.validator;

import lotto.constant.ErrorConstants;

import java.util.List;

public class WinningNumberValidator {

    public void validateWinningNumber(List<String> parsedInput){
        for(String element: parsedInput){
            checkElementIsEmpty(element);
            checkElementIsNull(element);
            checkElementIsNumber(element);
        }
    }

    private void checkElementIsEmpty(String element){
        if(element.isEmpty()){
            throw new IllegalArgumentException(ErrorConstants.INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }

    private void checkElementIsNull(String element){
        if(element == null){
            throw new IllegalArgumentException(ErrorConstants.INVALID_WINNING_NUMBER_FORMAT.getMessage());
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
