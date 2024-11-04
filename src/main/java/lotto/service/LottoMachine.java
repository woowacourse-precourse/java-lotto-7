package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.PurchaseAmount;

public class LottoMachine {
    private static final int START_VALUE = 1;
    private static final int END_VALUE = 45;
    private static final int COUNT = 6;

    public LottoMachine() {

    }

    public LottoTicket createLottoTicket(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.getCountPerUnit();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = createNumbers();
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return new LottoTicket(lottos);
    }

    private List<Integer> createNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_VALUE, END_VALUE, COUNT);
        return new ArrayList<>(numbers);
    }
}
