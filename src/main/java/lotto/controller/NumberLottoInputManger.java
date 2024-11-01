package lotto.controller;

import lotto.constants.message.InputError;
import lotto.constants.value.LottoRule;
import lotto.domain.BonusComponent;
import lotto.domain.Lotto;
import lotto.view.InputView;

public class NumberLottoInputManger implements LottoInputManger{

    private final InputView inputView;

    public NumberLottoInputManger(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public int getInputPrice() {
        String inputPrice = inputView.getInputPrice();
        return validateInputPrice(inputPrice);
    }

    @Override
    public Lotto getInputWinningComponent() {
        return null;
    }

    @Override
    public BonusComponent getInputBonusComponent() {
        return null;
    }

    private int validateInputPrice(String inputprice) {
        if (!isInteger(inputprice)) {
            throw new IllegalArgumentException(InputError.NONE_INTEGER_INPUT_PRICE.getInstance());
        }
        int inputMoney = Integer.parseInt(inputprice);
        if( inputMoney < LottoRule.LOTTO_PRICE.getInstance()){
            throw new IllegalArgumentException(InputError.NOT_ENOUGH_INPUT_PRICE.getInstance());
        }
        return inputMoney;
    }


    private  boolean isInteger(String input){
        try {
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

}
