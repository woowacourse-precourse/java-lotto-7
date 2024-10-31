package lotto.model;

import static lotto.util.LottoConstants.LOTTO_TICKET_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoVendingMachine {

    private final int totalCost;
    private final List<Lotto> purchased;

    public LottoVendingMachine(int totalCost) {
        this.totalCost = totalCost;
        this.purchased = new ArrayList<>();
    }

    public List<Lotto> issueLotto() {
        for (int i = 1; i <= totalCost/LOTTO_TICKET_PRICE; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            purchased.add(new Lotto(numbers));
        }
        return Collections.unmodifiableList(purchased);
    }
}
