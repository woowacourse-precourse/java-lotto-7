package lotto.entity;

import lotto.validator.Validator;
import lotto.validator.input.WinningNumberValidator;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final Lotto winningNumber;
    private Validator validator;

    public WinningNumber(String inputValue){
        initializeValidator(inputValue);
        validator.validate();

        this.winningNumber = new Lotto(parseData(inputValue));
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    private void initializeValidator(String inputValue){
        this.validator = new WinningNumberValidator(inputValue);
    }

    private void validate(){
        validator.validate();
    }

    private List<Integer> parseData(String inputValue){
        List<Integer> lottoNumber = new ArrayList<>();

        for(String number: inputValue.split(",")){
            lottoNumber.add(Integer.parseInt(number));
        }

        return lottoNumber;
    }
}
