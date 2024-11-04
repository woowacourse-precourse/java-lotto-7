package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateLottos{
    List<Lotto> lottos = new ArrayList<>();

    public Lotto generateLotto() {
        List<Integer> sixRandomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(sixRandomNumbers);
    }

    public List<Lotto> addLotto(Lotto lotto){
        lottos.add(lotto);
        return lottos;
    }

    public List<Lotto> getLottos(){
        return lottos;
    }
}
