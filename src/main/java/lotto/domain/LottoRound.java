package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRound {
    private int issuedCount;
    private List<Lotto> lottos;

    private List<Integer> gradingNumbers;
    private int bonusNumbers;

    private List<Integer> winHistory;

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

        this.winHistory = winHistory;
        return winHistory;
    }

    /**
     * 계산된 우승내역을 토대로 수익률을 계산합니다
     *
     * @return 소수점 둘째자리에서 반올림된 수익률
     */
    public float getProfitRate() {
        int profit = 0;
        int totalIssuePrice = issuedCount * LottoConstant.LOTTO_PRICE;

        for (int i = 4; i >= 0; i--) {
            int wonHistoryCount = this.winHistory.get(5 - i);
            profit += LottoConstant.WINNING_PRIZE_VALUES[i] * wonHistoryCount;
        }

        return roundRate((float) profit / totalIssuePrice);
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
        this.issuedCount = count;
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

    /**
     * 값을 소수 둘째자리에서 반올림합니다
     * @param rate 반올림할 값
     * @return 소수 둘째자리에서 반올림된 값
     */
    private float roundRate(float rate) {
        return (float) Math.round(rate * 10) / 10;
    }
}
