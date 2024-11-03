package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private List<Lotto> lottos;

    public LottoManager() {
        this.lottos = new ArrayList<>();
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public void buyLottos(int lottoCount){

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = generateLotto();
            this.lottos.add(lotto);
        }
    }
    public Lotto generateLottoWithNumbers(List<Integer> numbers){
        return new Lotto(numbers);
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }

}
