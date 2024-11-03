package lotto.controller.lottoController;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.numberPicker.NumberPicker;
import lotto.dto.PurchasedLottos;
import lotto.io.OutputHandler;

public class LottoController {

    private final OutputHandler outputHandler;
    private final NumberPicker numberPicker;

    public LottoController(OutputHandler outputHandler, NumberPicker numberPicker) {
        this.outputHandler = outputHandler;
        this.numberPicker = numberPicker;
    }

    public List<Lotto> purchaseLottos(final Money money) {
        List<Lotto> purchasedLottos = Lotto.purchase(money, numberPicker);
        outputHandler.handlePurchasedLottos(PurchasedLottos.from(purchasedLottos));
        return purchasedLottos;
    }
}
