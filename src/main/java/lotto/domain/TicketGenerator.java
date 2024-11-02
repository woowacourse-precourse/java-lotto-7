package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TicketGenerator {

    private static final int TICKET_PRICE = 1000;
    private final int ticketCount;

    public TicketGenerator(int purchaseAmount) {
        this.ticketCount = purchaseAmount/TICKET_PRICE;
    }

    public List<Lotto> generateTickets() {
        List<Lotto> tikets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tikets.add(new Lotto(generateLottoNumbers()));
        }
        return tikets;
    }

    private List<Integer> generateLottoNumbers() {
        TreeSet<Integer> uniqueNumbers = new TreeSet<>();
        while (uniqueNumbers.size() < 6) {
            uniqueNumbers.add(Randoms.pickNumberInRange(1, 45));
        }
        return new ArrayList<>(uniqueNumbers);
    }
}
