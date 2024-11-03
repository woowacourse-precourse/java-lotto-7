package lotto.entity;

import lotto.validator.Validator;
import lotto.validator.input.BonusNumberValidator;

public class BonusNumber {
    private final int bonusNumber;
    private Validator validator;

    public BonusNumber(String inputValue){
        initializeValidator(inputValue);
        validate();
        
        this.bonusNumber = parseData(inputValue);
    }

    public int getBonusNumber() {
        return bonusNumber;
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
