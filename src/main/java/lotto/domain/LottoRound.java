package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.List;

public class LottoRound {
    private List<Lotto> lottos;

    public LottoRound() {
        this.lottos = new ArrayList<>();
    }

    public LottoRound(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottosCount() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
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

    private void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
}
