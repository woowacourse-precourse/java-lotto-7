package lotto.domain;

import java.util.List;
import lotto.utils.RandomPicker;

public class UserLottoTickets {
    private final List<Lotto> lottoTickets;

    public UserLottoTickets(List<Lotto> lottoTickets) {
        buyLotto();
        this.lottoTickets = lottoTickets;
    }

    private void buyLotto() {
        Lotto lotto = new Lotto(RandomPicker.getRandomNumbers());

    }
}
