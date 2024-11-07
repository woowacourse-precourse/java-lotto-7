package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.config.LottoConfig;
import lotto.model.domain.Lotto;
import lotto.model.domain.Player;

public class LottoService {
    public Lotto generateLotto() {
        List<Integer> numbers;
        numbers = generateRandomNumbers();
        Lotto lotto = new Lotto(numbers);

        return lotto;
    }

    public void generateLottoTickets(Player player) {
        int ticketCount = calculateTicketCount(player.getPurchaseAmount());
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = generateLotto();
            player.addLotto(lotto);
        }
    }

    public int calculateTicketCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers = Randoms.pickUniqueNumbersInRange(LottoConfig.MIN_NUMBER,
                LottoConfig.MAX_NUMBER,
                LottoConfig.LOTTO_COUNT_NUMBER
        );

        return numbers;
    }
}
