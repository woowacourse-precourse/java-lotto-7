package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import enums.InputRegix;
import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public int getNumberOfTickets(String purchase) {
        if (!purchase.matches(InputRegix.PURCHASE.getRegix())) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위의 숫자여야 합니다.");
        }

        return Integer.parseInt(purchase) / 1000;
    }

    public List<List<Integer>> getTickets(int numberOfTickets) {
        List<List<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }

        return tickets;
    }
}
