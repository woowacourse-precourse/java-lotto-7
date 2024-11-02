package lotto;

import static lotto.Input.*;

import java.util.List;

public class LottoMachine {
    public static final int PRICE_OF_ONE_LOTTERY_TICKET = 1000;

    public LottoTicket generateLottoTicket(int amount) {
        int lottoCount = calculateLottoCount(amount);
        List<Lotto> lottos = LottoGenerator.generateLottos(lottoCount);
        return new LottoTicket(lottos);
    }

    private int calculateLottoCount(int amount) {
        return amount / PRICE_OF_ONE_LOTTERY_TICKET;
    }

}
