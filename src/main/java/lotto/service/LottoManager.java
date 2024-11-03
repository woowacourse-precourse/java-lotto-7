package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Constants;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private final List<Lotto> lottos;


    public LottoManager() {
        this.lottos = new ArrayList<>();
    }

    private Lotto generateLotto() { //로또 자동선택
        return new Lotto(Randoms.pickUniqueNumbersInRange(Constants.MIN_LOTTO_RANGE, Constants.MAX_LOTTO_RANGE, Constants.MAX_LOTTO_COUNT));
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
