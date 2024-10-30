package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/*
* 구입금액
* 당첨 번호
* 보너스 번호
* */
public class ConvertValidValue {
    public int purchaseAmount(String input){
        int purchaseAmount;

        try{
            purchaseAmount = Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 올바른 형태의 구매액을 입력해주세요.");
        }

        return purchaseAmount;
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
        if(input < 1 || input > 45)
            throw new IllegalArgumentException("[Error] 로또 번호는 1에서 45 사이 숫자만 가능합니다.");
    }
}
