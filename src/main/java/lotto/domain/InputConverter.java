package lotto.domain;

import static lotto.domain.Constant.LOTTO_PRICE;
import static lotto.domain.Constant.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.Constant.MINIMUM_LOTTO_NUMBER;
import static lotto.ui.ErrorMessage.ERROR_CONSTRAINTS_OF_LOTTO_NUMBER;
import static lotto.ui.ErrorMessage.ERROR_CONSTRAINTS_OF_MONEY;
import static lotto.ui.ErrorMessage.ERROR_INPUT_IS_NaN;
import static lotto.ui.ErrorMessage.ERROR_MINIMUM_OF_MONEY;
import static lotto.ui.ErrorMessage.ERROR_TYPE_OF_MONEY;

import java.util.ArrayList;
import java.util.List;

public class InputConverter {
    public int purchaseAmount(String input) throws IllegalArgumentException {
        int budget;
        int amount;

        try{
            budget = Integer.parseInt(input);
            isAvailableBuyLotto(budget);
            amount = divide(budget);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ERROR_TYPE_OF_MONEY);
        }catch(IllegalArgumentException e){
            throw e;
        }

        return amount;
    }

    private int divide(int budget) throws IllegalArgumentException{
        if(budget % LOTTO_PRICE != 0){
            throw new IllegalArgumentException(ERROR_CONSTRAINTS_OF_MONEY);
        }

        return budget/LOTTO_PRICE;
    }

    private void isAvailableBuyLotto(int budget) throws IllegalArgumentException{
        if(budget < LOTTO_PRICE){
            throw new IllegalArgumentException(ERROR_MINIMUM_OF_MONEY);
        }
    }

    public List<Integer> winningNumbers(String input){
        String[] numbers = input.trim().split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for(String number : numbers){
            int value = validLottoNumber(number);
            winningNumbers.add(value);
        }

        return winningNumbers;
    }

    public int bonusNumber(String input){
        return validLottoNumber(input);
    }

    private int validLottoNumber(String input){
        int number = 0;

        try{
            number = Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_INPUT_IS_NaN);
        }

        if(number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER)
            throw new IllegalArgumentException(ERROR_CONSTRAINTS_OF_LOTTO_NUMBER);

        return number;
    }
}
