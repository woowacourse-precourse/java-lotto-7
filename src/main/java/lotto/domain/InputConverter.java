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

    public List<Integer> winningNumbers(String input){
        String[] numbers = input.trim().split(",");
        List<Integer> winningNumbers = new ArrayList<>();

        for(String number : numbers){
            int value = Integer.parseInt(number);
            validLottoNumber(value);
            winningNumbers.add(value);
        }

        return winningNumbers;
    }

    public int bonusNumber(String input){
        int bonusNumber;

        try{
            bonusNumber = Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 올바른 형태의 보너스 번호를 입력해주세요.");
        }

        validLottoNumber(bonusNumber);

        return bonusNumber;
    }

    private void validLottoNumber(int input){
        if(input < MINIMUM_LOTTO_NUMBER || input > MAXIMUM_LOTTO_NUMBER)
            throw new IllegalArgumentException("[Error] 로또 번호는 1에서 45 사이 숫자만 가능합니다.");
    }
}
