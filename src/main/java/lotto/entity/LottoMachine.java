package lotto.entity;

import java.util.ArrayList;
import java.util.List;
import lotto.validator.LottoMachineValidator;

public class LottoMachine {
    private final WinningNumbers winningNumbers;
    private final List<Lotto> purchasedLottos;
    private final PaymentAmount paymentAmount;

    // constructor

    public LottoMachine(int amount, List<Integer> winningMainNumbers, int winningBonusNumber) {
        LottoMachineValidator.validate(amount, winningMainNumbers);
        this.winningNumbers = new WinningNumbers(winningMainNumbers, winningBonusNumber);
        this.paymentAmount = new PaymentAmount(amount);
        this.purchasedLottos = createLottos(paymentAmount.calculateTicketCount());
    }

    // public methods

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    // private methods

    private List<Lotto> createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.createRandomLotto());
        }
        return lottos;
    }
}
