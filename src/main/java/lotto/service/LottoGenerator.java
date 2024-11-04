package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> generateLottos(int totalTickets) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < totalTickets; i++) {
            Lotto lotto = generateLotto(); // 로또 번호 생성 메서드 호출
            lottos.add(lotto);
        }
        return lottos;
    }

    public Lotto generateLotto() {
        // Randoms 클래스를 사용하여 중복되지 않는 로또 번호 생성
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, LottoConstants.LOTTO_SIZE));
    }
}