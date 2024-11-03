package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private final gList<Lotto> lottos;

    public LottoManager() {
        this.lottos = new ArrayList<>();
    }

    private Lotto generateLotto() { //로또 자동선택
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public void buyLottos(int lottoCount){

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = generateLotto();
            this.lottos.add(lotto);
        }
    }
    public Lotto generateLottoWithNumbers(List<Integer> numbers){ //로또 수동 번호 선택
        return new Lotto(numbers);
    }

    public List<Lotto> getLottos(){
        return new ArrayList<>(this.lottos);
    }

}
