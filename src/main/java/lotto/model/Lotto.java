package lotto.model;

import lotto.io.ConsoleOutputHandler;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public void lottoNumberOut(){
        ConsoleOutputHandler.buyLottoNumberMessage(numbers);
    }

    public int matchingWinningNumber(WinningNumber winningNumber) {
        int count = 0;
        for (Integer number : numbers) {
            if (winningNumber.isContainsNumber(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean matchingBounsNumber(BonusNumber bonusNumber){
        for (Integer number : numbers) {
            if (bonusNumber.isContainsNumber(number)) {
                return true;
            }
        }
        return false;
    }
}
