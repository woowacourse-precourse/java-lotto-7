package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    public int getLottoRank(List<Integer> winningLotto, Integer bonusNumber) {
        int countMatchingNumber = 0;
        boolean hasBonusNumber = false;
        for(Integer number : numbers) {
            if(winningLotto.contains(number)) {
                countMatchingNumber ++;
            }
        }
        if(numbers.contains(bonusNumber)) {
            hasBonusNumber = true;
        }
        if(countMatchingNumber == 6) {
            return LottoRank.FIRST_RANK.getRank();
        }
        if(countMatchingNumber == 5 && hasBonusNumber) {
            return LottoRank.SECOND_RANK.getRank();
        }
        if(countMatchingNumber == 5) {
            return LottoRank.THIRD_RANK.getRank();
        }
        if(countMatchingNumber == 4) {
            return LottoRank.FIRTH_RANK.getRank();
        }
        if(countMatchingNumber == 3) {
            return LottoRank.FIFTH_RANK.getRank();
        }
        return LottoRank.NONE_RANK.getRank();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
