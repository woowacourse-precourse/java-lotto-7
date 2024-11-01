package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private List<Lotto> lottos = new ArrayList<>();

    public void issue(int count){
        for(int i=0;i<count;i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange
                    (1,45,6);
            lottos.add(new Lotto(numbers));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
