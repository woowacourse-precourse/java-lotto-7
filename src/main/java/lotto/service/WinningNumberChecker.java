package lotto.service;

import lotto.Lotto;

import java.util.List;
import java.util.ArrayList;

public class WinningNumberChecker {
    private WinningNumberPool winningNumberPool;

    public WinningNumberChecker(WinningNumberPool winningNumberPool) {
        this.winningNumberPool = winningNumberPool;
    }

    public int countMatchingNumbers(List<Integer> numbers) {
        int matchCount = 0;
        for(Integer number : numbers) {
            if(winningNumberPool.getWinningNumbers().contains(number)) matchCount++;
        }
        return matchCount;
    }

    public boolean doesContainBonusNumber(Lotto lotto){
        return new LottoConverter().LottoIntoNumber(lotto).contains(winningNumberPool.getBonusNumber());
    }
}
