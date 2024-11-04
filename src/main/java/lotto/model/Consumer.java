package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.CompareInteger;

import java.util.ArrayList;
import java.util.List;

public class Consumer {
    private final List<Lotto> lottoTicket = new ArrayList<>();
    private final int[] lottoResult = new int[CompareInteger.LOTTO_NUMBER_COUNT.getNumber() + CompareInteger.ONE.getNumber()];
    private int secondPlace = CompareInteger.ZERO.getNumber();

    public Consumer(int count) {
        for (int i = CompareInteger.ZERO.getNumber(); i < count; i++) {
            setLotto();
        }
    }

    private void setLotto() {
        Lotto lotto = new Lotto(getNumbers());
        this.lottoTicket.add(lotto);
    }

    public int[] getLottoResult() {
        return this.lottoResult;
    }

    public int getSecondPlace() {
        return this.secondPlace;
    }

    private List<Integer> getNumbers() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(
                CompareInteger.LOTTO_NUMBER_MINIMUM.getNumber(),
                CompareInteger.LOTTO_NUMBER_MAXIMUM.getNumber(),
                CompareInteger.LOTTO_NUMBER_COUNT.getNumber()));
    }

    public List<Lotto> getLottoTicket() {
        return this.lottoTicket;
    }

    public void setLottoResult(WinningNumber winningNumber) {
        for (Lotto lotto : lottoTicket) {
            int count = lotto.getMatchingCount(winningNumber.getNumbers());
            lottoResult[count]++;
            if (count == CompareInteger.LOTTO_MATCHING_COUNT_SECOND_PLACE.getNumber() && lotto.isMatchBonus(winningNumber.getBonus())) {
                secondPlace++;
            }
        }
    }
}
