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

    public List<Lotto> getLottoTicket() {
        return this.lottoTicket;
    }

    private List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                CompareInteger.LOTTO_NUMBER_MINIMUM.getNumber(),
                CompareInteger.LOTTO_NUMBER_MAXIMUM.getNumber(),
                CompareInteger.LOTTO_NUMBER_COUNT.getNumber());
    }

    public void setLottoResult(WinningNumber winningNumber) {
        for (Lotto lotto : lottoTicket) {
            // 한 로또(6개의 숫자)에서 당첨 번호와 일치하는 숫자의 개수를 lottoResult의 idx 값으로 취급하여 업데이트
            int count = lotto.getMatchingCount(winningNumber.getNumbers());
            lottoResult[count]++;

            // 5개이면 보너스 번호 일치 여부 확인하여 secondPlace++
            if (count == CompareInteger.LOTTO_MATCHING_COUNT_SECOND_PLACE.getNumber() && lotto.isMatchBonus(winningNumber.getBonus())) {
                secondPlace++;
            }
        }
    }
}
