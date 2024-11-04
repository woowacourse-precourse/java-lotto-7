package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoTicket {
    private final List<Integer> numbers;
    private LottoPlace place;

    public LottoTicket() {
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        this.place = LottoPlace.LOSE;
    }
    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
        this.place = LottoPlace.LOSE;
    }

    public void decideLottoPlaceBy(Lotto lotto, int bonusNumber) {
        int matchingNumberCount = lotto.compareNumberWithTicket(numbers);
        boolean hasBonusNumber = numbers.contains(bonusNumber);

        this.place = LottoPlaceDecider.findLottoPlaceBy(matchingNumberCount, hasBonusNumber);
    }

    public boolean doesContainBonusNumber(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public LottoPlace getPlace() {
        return place;
    }

    public int getWinningMoney() {
        return place.getWinningMoney();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
