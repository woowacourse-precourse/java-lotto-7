package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto.Lotto;
import lotto.domain.Lotto.LottoFactory;

public class Lottos {
    private final static int START_LOTTO_INDEX = 0;
    private final int ticketCount;
    private final List<Lotto> lottos;


    public Lottos(Price price) {
        this.ticketCount = price.convertToTicket();
        this.lottos = createLottos();
    }

    public List<Lotto> createLottos() {
        List<Lotto> lottosNumber = new ArrayList<>();
        for (int i = START_LOTTO_INDEX; i < ticketCount; i++) {
            lottosNumber.add(LottoFactory.createAutoLotto());
        }
        return lottosNumber;
    }

    public String getLottosToString() {
        StringBuilder result = new StringBuilder();
        for (int i = START_LOTTO_INDEX; i < lottos.size(); i++) {
            result.append(lottos.get(i));
            if (i < lottos.size() - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getTicketCount() {
        return ticketCount;
    }
}
