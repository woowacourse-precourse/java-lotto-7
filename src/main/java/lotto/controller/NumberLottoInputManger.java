package lotto.controller;

import lotto.constants.string.Delimiter;
import lotto.constants.string.InputError;
import lotto.constants.value.LottoRule;
import lotto.domain.BonusComponent;
import lotto.domain.BonusComponentNumber;
import lotto.domain.ComponentNumber;
import lotto.domain.Lotto;
import lotto.view.InputView;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        String inputWinningComponent = inputView.getWinningComponent();
        return validateInputWinningNubmer(inputWinningComponent);
    }

    @Override
    public BonusComponent getInputBonusComponent(Lotto winningComponent) {
        String inputBonusComponent = inputView.getBonusComponent();
        return validateInputBonusComponent(winningComponent,inputBonusComponent);
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

    public Lotto validateInputWinningNubmer(String winningNumber) {

        if (winningNumber.isBlank()) {
            throw new IllegalArgumentException(InputError.BLANK_WINNING_NUMBER.getInstance());
        }

        boolean onlyAllowedNoneInteger = IntStream.range(0, winningNumber.length())
                .allMatch(i -> {
                    char currentChar = winningNumber.charAt(i);
                    String charAsString = Character.toString(currentChar);
                    return isInteger(charAsString) || charAsString.equals(Delimiter.DEFAULT.getInstance());
                });

        if (!onlyAllowedNoneInteger) {
            throw new IllegalArgumentException(InputError.NOT_ALLOWED_NONE_INTEGER.getInstance());
        }
        if(winningNumber.startsWith(Delimiter.DEFAULT.getInstance()) || winningNumber.endsWith(Delimiter.DEFAULT.getInstance())){
            throw new IllegalArgumentException(InputError.CANNOT_START_OR_END_WITH_DELIMETER.getInstance());
        }

        return new Lotto(Arrays.stream(winningNumber.split(Delimiter.DEFAULT.getInstance()))
                .map(Integer::parseInt)
                .map(ComponentNumber::new)
                .collect(Collectors.toList()));
    }

    private BonusComponent validateInputBonusComponent(Lotto winningComponent, String inputBonusComponent) {
        if(inputBonusComponent.isBlank()){
            throw new IllegalArgumentException(InputError.BLANK_BONUS_NUMBER.getInstance());
        }
        if(!isInteger(inputBonusComponent)){
            throw new IllegalArgumentException(InputError.NONE_INTEGER_BONUS_NUMBER.getInstance());
        }
        ComponentNumber number = new ComponentNumber(Integer.parseInt(inputBonusComponent));
        return new BonusComponentNumber(winningComponent,number);
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
