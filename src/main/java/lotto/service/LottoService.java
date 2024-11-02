package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;

public class LottoService {
    // 이건 분리해도 될 듯
    private static final int START_VALUE = 1;
    private static final int END_VALUE = 45;
    private static final int COUNT = 6;

    public LottoService() {

    }

    public LottoTicket createLottoTicket(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.getCountPerUnit();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = createNumbers();
            lottos.add(new Lotto(numbers));
        }
        return new LottoTicket(lottos);
    }

    private List<Integer> createNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_VALUE, END_VALUE, COUNT);
        Collections.sort(numbers);
        return numbers;
    }
}
