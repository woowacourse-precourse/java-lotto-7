package lotto.entity;

import java.util.ArrayList;
import java.util.List;
import lotto.configuration.LottoConfiguration;
import lotto.validator.LottoMachineValidator;

public class LottoMachine {
    private final WinningNumbers winningNumbers;
    private final List<Lotto> purchasedLottos;
    private final int paymentAmount;

    public LottoMachine(int paymentAmount, List<Integer> winningMainNumbers, int winningBonusNumber) {
        LottoMachineValidator.validate(paymentAmount, winningMainNumbers);
        this.winningNumbers = new WinningNumbers(winningMainNumbers, winningBonusNumber);
        this.purchasedLottos = createLottos();
        this.paymentAmount = paymentAmount;
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    private List<Lotto> createLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < calculateTicketCount(); i++) {
            lottos.add(Lotto.createRandomLotto());
        }
        return lottos;
    }

    private int calculateTicketCount() {
        return paymentAmount / LottoConfiguration.LOTTO_PRICE.getValue();
    }

}
