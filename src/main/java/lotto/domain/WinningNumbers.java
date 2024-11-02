package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.ExceptionHandler;

import java.util.Set;

public class WinningNumbers {

    private final Set<Integer> numbers;
    private int bonusNumber;

    public WinningNumbers(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setBonusNumber(int bonusNumber) {
        if (numbers.stream()
                .anyMatch(number -> number == bonusNumber)) {
            ExceptionHandler.inputException(ErrorMessage.DUPLICATED_NUMBER);
        }
        this.bonusNumber = bonusNumber;
    }

    public LottoPrize matchedResult(Lotto lotto){
        int matchCount = 0;
        boolean isMatchedBonusNumber = false;

        for (int number : this.numbers){
            if(lotto.getNumbersValue().contains(number)){
                matchCount++;
            }
        }
        if(lotto.getNumbersValue().contains(bonusNumber)){
            isMatchedBonusNumber = true;
        }
        return getResult(matchCount, isMatchedBonusNumber);
    }

    private LottoPrize getResult(int matchCount, boolean isMatchBonusNumber){

        if(matchCount == 6){
            return LottoPrize.FIRST;
        }
        if(matchCount == 5 && isMatchBonusNumber){
            return LottoPrize.SECOND;
        }
        if(matchCount == 5){
            return LottoPrize.THIRD;
        }
        if(matchCount == 4){
            return LottoPrize.FOURTH;
        }
        if(matchCount == 3) {
            return LottoPrize.FIFTH;
        }

        return LottoPrize.NONE;
    }

}
