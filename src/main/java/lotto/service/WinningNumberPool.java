package lotto.service;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberPool {
    private List<Integer> winningSet;
    private int bonusNumber;

    public WinningNumberPool() {
        winningSet = new ArrayList<Integer>();
    }

    public List<Integer> getWinningNumbers(){
        return winningSet;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

    public WinningNumberPool setWinningNumber(List<Integer> numbers){
        winningSet.addAll(numbers);
        return this;
    }

    public WinningNumberPool setBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
        return this;
    }
}
