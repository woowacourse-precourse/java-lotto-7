package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

//- 역할
//  - 받은 금액만큼 로또를 발행한다
//  - 로또 기계에서 당첨 번호를 뽑는다
//  - 로또 기계에서 보너스 번호를 뽑는다
//  - 로또 결과에서 발행된 로또들과 당첨 번호를 비교한다
public class LottoStore {
    private List<Lotto> lottos;
    private LottoMachine lottoMachine;
    private LottoResult lottoResult;

    public void buyLotto(int price) {
        for (int i = 0; i < price; i++) {
            lottos.add(new Lotto(generateRandomNumbers()));
        }
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void pickWinLottoNumbers() {

    }

    private void pickBonusNumber() {

    }

    public void showLottoResult() {

    }


}
