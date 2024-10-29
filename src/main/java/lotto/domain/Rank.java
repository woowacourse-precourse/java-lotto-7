package lotto.domain;

import java.util.List;

public class Rank {
    private int firstPrizeLottoNumber;
    private int secondPrizeLottoNumber;
    private int thirdPrizeLottoNumber;
    private int fourthPrizeLottoNumber;
    private int fifthPrizeLottoNumber;

    public void countMatchNumber(List<Integer> numbers, WinNumbers winNumbers) {
        List<Integer> compareNumbers = winNumbers.primaryWinNumbers();
        int count = 0;
        for (Integer number : numbers) {
            if (compareNumbers.contains(number)) {
                count++;
            }
        }
        decideRankNumber(count, numbers, winNumbers);
    }

    private void decideRankNumber(int count, List<Integer> numbers, WinNumbers winNumbers) {
        if (count == 6) {
            firstPrizeLottoNumber++;
        }
        if (count == 5 && decideSecondThird(winNumbers.bonusWinNumber(), numbers)) {
            secondPrizeLottoNumber++;
        }
        if (count == 5 && !decideSecondThird(winNumbers.bonusWinNumber(), numbers)) {
            thirdPrizeLottoNumber++;
        }
        if (count == 4) {
            fourthPrizeLottoNumber++;
        }
        if (count == 3) {
            fifthPrizeLottoNumber++;
        }
    }

    private boolean decideSecondThird(int bonusNumber, List<Integer> numbers) {
        return (numbers.contains(bonusNumber));
    }
}
