package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    private static final LottoRepository lottoRepository = LottoRepository.getInstance();

    public void generateLottoNumbers(int tryCount) {
        for (int cnt_i = 0; cnt_i < tryCount; cnt_i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoRepository.save(lotto);
        }
    }
}
