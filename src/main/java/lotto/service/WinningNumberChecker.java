package lotto.service;

import lotto.Lotto;

import java.util.List;
import java.util.ArrayList;

public class WinningNumberChecker {
    private final List<Integer> winningSet;
    private int bonusNumber;

    public WinningNumberChecker() {
        this.winningSet = new ArrayList<>(); // 불변 리스트 생성
    }

    public void setBonusNumber(int number) {
        this.bonusNumber = number;
    }

    public void setWinningNumber(List<Integer> numbers){
        winningSet.addAll(numbers);
    }

    public int countMatchingNumbers(List<Integer> numbers) {
        int matchCount = 0;
        for(Integer number : numbers) {
            if(winningSet.contains(number)) matchCount++;
        }
        return matchCount;
    }

    public boolean doesContainBonusNumber(Lotto lotto){
        return new LottoConverter().LottoIntoNumber(lotto).contains(bonusNumber);
    }
}
