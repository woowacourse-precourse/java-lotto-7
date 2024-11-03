package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public List<Lotto> createLotto(int quantity){
        System.out.printf("\n%d개를 구매했습니다.\n", quantity);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            System.out.println(lotto);
            lottos.add(lotto);
        }

        return lottos;
    }
}
