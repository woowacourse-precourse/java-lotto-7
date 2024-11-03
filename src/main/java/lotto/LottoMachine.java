package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static List<Lotto> issueLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int numberOfTickets = purchaseAmount / 1000;
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }
}
