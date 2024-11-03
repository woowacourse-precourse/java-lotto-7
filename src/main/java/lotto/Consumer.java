package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.CompareInteger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Consumer {
    private List<Lotto> lottoTicket = new ArrayList<>();
    private int[] lottoResult = new int[CompareInteger.LOTTO_NUMBER_COUNT.getNumber() + 1];
    private int secondPlace = CompareInteger.ZERO.getNumber();

    public Consumer(int count) {
        for (int i = 0; i < count; i++) {
            setLotto();
        }
    }

    private void setLotto() {
        Lotto lotto = new Lotto(getNumbers());
        this.lottoTicket.add(lotto);
    }

    private List<Integer> getNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
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

    public int[] getLottoResult() {
        return this.lottoResult;
    }

    public int getSecondPlace() {
        return this.secondPlace;
    }
}
