package lotto.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;

public class LottoService {
    private final LottoNumberGenerator numberGenerator;

    public LottoService(LottoNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lotto createLottoTicket() {
        List<Integer> numbers = numberGenerator.generateNumbers();
        return new Lotto(numbers);
    }

    public void provideLottoTickets(User user, int tickets) {
        for (int ticket = 0; ticket < tickets; ticket++) {
            user.addLottoTicket(createLottoTicket());
        }
    }

}
