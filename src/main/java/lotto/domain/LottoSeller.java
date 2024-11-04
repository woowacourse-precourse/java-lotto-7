package lotto.domain;

import static lotto.MessageContainer.INVALID_PURCHASE_AMOUNT;

import java.math.BigInteger;
import java.util.List;

public class LottoSeller {
    private final int lottoPrice;
    private final LottoMachine lottoMachine;

    public LottoSeller(int lottoPrice, LottoMachine lottoMachine) {
        this.lottoPrice = lottoPrice;
        this.lottoMachine = lottoMachine;
    }

    public LottoReceipt sellAsMuchAs(BigInteger amount) {
        validateMultiplesOfLottoPrice(amount);
        LottoTicket lottoTicket = createLottoTicketFor(amount);
        return new LottoReceipt(amount, lottoTicket);
    }

    private void validateMultiplesOfLottoPrice(BigInteger amount) {
        BigInteger remainder = amount.remainder(BigInteger.valueOf(lottoPrice));
        if ((amount.equals(BigInteger.ZERO)) || (!remainder.equals(BigInteger.ZERO))) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT);
        }
    }

    public WinningLotto createWinningLotto(LottoTicket winningTicket, int bonusNumber) {
        return new WinningLotto(winningTicket, bonusNumber);
    }

    public LottoTicket createLottoTicketFor(List<Integer> numbers) {
        return new LottoTicket(lottoMachine.createLotto(numbers));
    }

    public LottoTicket createLottoTicketFor(BigInteger amount) {
        int quantity = calculateQuantityWith(amount);
        List<Lotto> lottos = lottoMachine.createLottos(quantity);
        return new LottoTicket(lottos);
    }

    private int calculateQuantityWith(BigInteger amount) {
        return amount.divide(BigInteger.valueOf(lottoPrice)).intValue();
    }
}
