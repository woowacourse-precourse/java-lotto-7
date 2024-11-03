package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.Player;

public class LottoService {
    public Lotto generateLotto() {
        List<Integer> numbers = generateRandomNumbers();

        Lotto lotto = new Lotto(numbers);

        return lotto;
    }

    public List<Lotto> generateLottoTickets(Player player) {
        int ticketCount = calculateTicketCount(player.getPurchaseAmount());
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = generateLotto();
            tickets.add(lotto);
            player.addLotto(lotto);
        }
        return tickets;
    }

    public int calculateTicketCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }
}
