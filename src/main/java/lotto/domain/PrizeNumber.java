package lotto.domain;

import java.util.List;

public class PrizeNumber {
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

    private void decideRankNumber(int count, List<Integer> numbers, WinNumbers winNumbers) { //return 하는 식으로 개선해야하나봄
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

    public int getFirstPrizeLottoNumber() {
        return firstPrizeLottoNumber;
    }

    public int getSecondPrizeLottoNumber() {
        return secondPrizeLottoNumber;
    }

    public int getThirdPrizeLottoNumber() {
        return thirdPrizeLottoNumber;
    }

    public int getFourthPrizeLottoNumber() {
        return fourthPrizeLottoNumber;
    }

    public int getFifthPrizeLottoNumber() {
        return fifthPrizeLottoNumber;
    }
}
