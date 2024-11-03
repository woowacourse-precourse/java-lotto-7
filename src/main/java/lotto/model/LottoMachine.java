package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> exchangeLotto(LottoTickets lottoTickets) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        while (lottoTickets.hasTicketCount()) {
            lottos.add(new Lotto(numberGenerator.generateNumbersInRange()));
            lottoTickets.decreaseTicketCount();
        }
        return lottos;
    }
}
