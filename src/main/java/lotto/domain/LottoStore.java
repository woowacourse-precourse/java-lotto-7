package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

//- 역할
//  - 받은 금액만큼 로또를 발행한다
public class LottoStore {

    public List<Lotto> buyLotto(int lottoAmount) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            purchasedLottos.add(generateLottoByNumbers(generateRandomNumbers()));
        }
        return purchasedLottos;
    }

    private Lotto generateLottoByNumbers(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
