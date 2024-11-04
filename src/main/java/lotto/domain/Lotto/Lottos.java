package lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto.Lotto;
import lotto.domain.Lotto.LottoFactory;
import lotto.domain.TicketPrice;
import lotto.dto.LottosDto;

public class Lottos {
    private final static int START_LOTTO_INDEX = 0;
    private final int ticketCount;
    private final List<Lotto> lottos;


    public Lottos(TicketPrice ticketPrice) {
        this.ticketCount = ticketPrice.convertToTicket();
        this.lottos = createLottos();
    }

    public List<Lotto> createLottos() {
        List<Lotto> lottosNumber = new ArrayList<>();
        for (int i = START_LOTTO_INDEX; i < ticketCount; i++) {
            lottosNumber.add(LottoFactory.createAutoLotto());
        }
        return lottosNumber;
    }

    public LottosDto toDto() {
        return LottosDto.of(lottos, ticketCount);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
