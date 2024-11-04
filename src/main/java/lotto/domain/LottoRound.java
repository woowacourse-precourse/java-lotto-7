package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRound {
    private List<Lotto> lottos;

    private List<Integer> gradingNumbers;
    private int bonusNumbers;

    public LottoRound() {
        this.lottos = new ArrayList<>();
    }

    protected LottoRound(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottosCount() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    /**
     * 설정된 당첨번호를 비교하여 우승내역을 계산합니다
     *
     * @return 각 index를 등수로 하는 복권의 개수
     */
    public List<Integer> getWinHistory() {
        List<Integer> winHistory = new ArrayList<>(6);

        lottos.stream()
                .map(v -> v.grade(this.gradingNumbers, this.bonusNumbers))
                .forEach(i -> {
                    int wonHistoryCount = winHistory.get(i);
                    winHistory.set(i, wonHistoryCount + 1);
                });

        return winHistory;
    }

    public void setWinNumbers(List<Integer> gradingNumbers, int bonusNumbers) {
        this.gradingNumbers = gradingNumbers;
        this.bonusNumbers = bonusNumbers;
    }

    private void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    /**
     * 지정된 수량만큼 로또를 발행합니다
     *
     * @param count 발행할 로또 수
     */
    public void issueLottoes(int count) {
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(createLottoNumber());
            addLotto(lotto);
        }
    }

    /**
     * Randoms 라이브러리를 사용하여 랜덤한 로또번호를 뽑아 가져옵니다.
     *
     * @return 길이가 6인 로또번호를 담은 정수리스트
     */
    private List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstant.MIN_LOTTO_NUMBER,
                LottoConstant.MAX_LOTTO_NUMBER,
                LottoConstant.LOTTO_DIGITS
        );
    }
}
