package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.numbers.sort(Integer::compare);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public int calcLotteryPlace(List<Integer> lotteryWinningNumbers, int lotteryBonusNumber) {
        int matchCount = 0;
        boolean hasBonusNumber = false;

        int idx = 0;
        for(int i=0, iLen=numbers.size(); i<iLen; i++) {
            int num = numbers.get(i);
            for(int j=0, jLen=lotteryWinningNumbers.size(); j<jLen; j++) {
                if(num == lotteryWinningNumbers.get(j)) {
                    matchCount++;
                }
            }
            if(num == lotteryBonusNumber) {
                hasBonusNumber = true;
            }
        }
        if(matchCount == 6) {
            return 1;
        }
        if(matchCount == 5) {
            if(hasBonusNumber) {
                return 2;
            }
            return 3;
        }
        if(matchCount == 4) {
            return 4;
        }
        if(matchCount == 3) {
            return 5;
        }
        return 6;
    }
}
