package lotto.service;

import java.util.List;

public class CompareNumbers {
    public int checkSameCount(List<Integer> winningNumbers, List<Integer> yourNumbers) {
        int sameCount = 0;
        for(int number : yourNumbers) {
            if(winningNumbers.contains(number)) {
                sameCount++;
            }
        }
        if(sameCount < 3) {
            sameCount = 0;
        }
        return sameCount;
    }

    public boolean checkBonus(int bonusNumber, List<Integer> yourNumbers) {
        return yourNumbers.contains(bonusNumber);
    }
}
