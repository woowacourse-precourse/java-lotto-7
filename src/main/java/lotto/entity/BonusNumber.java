package lotto.entity;

import lotto.validator.Validator;
import lotto.validator.entity.BonusNumberValidator;

public class BonusNumber {
    private final int value;
    private Validator validator;

    public BonusNumber(String inputValue){
        initializeValidator(inputValue);
        validate();
        
        this.value = parseData(inputValue);
    }

    public int getValue() {
        return value;
    }

    private void initializeValidator(String inputValue){
        this.validator = new BonusNumberValidator(inputValue);        
    }
    
    private void validate(){
        validator.validate();
    }
    
    private int parseData(String inputValue){
        return Integer.parseInt(inputValue);    
    }
}
