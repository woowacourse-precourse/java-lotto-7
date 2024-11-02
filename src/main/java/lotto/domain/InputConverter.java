package lotto.domain;

import static lotto.domain.Constant.LOTTO_PRICE;
import static lotto.domain.Constant.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.Constant.MINIMUM_LOTTO_NUMBER;

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
            throw new IllegalArgumentException("[ERROR] 올바른 형태의 구매액을 입력해주세요.");
        }catch(IllegalArgumentException e){
            throw e;
        }

        return amount;
    }

    private int divide(int budget) throws IllegalArgumentException{
        if(budget % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
        }

        return budget/LOTTO_PRICE;
    }

    private void isAvailableBuyLotto(int budget) throws IllegalArgumentException{
        if(budget < LOTTO_PRICE){
            throw new IllegalArgumentException("[ERROR] 로또구매 금액은 최소 1,000원 이상이어야 합니다.");
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
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자만 가능합니다.");
        }

        if(number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER)
            throw new IllegalArgumentException("[Error] 로또 번호는 1에서 45 사이 숫자만 가능합니다.");

        return number;
    }
}
