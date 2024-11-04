package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoDrawer {
    private final int count;
    private final NumbersGenerator numbersGenerator;

    public LottoDrawer(PurchaseAmount purchaseAmount, NumbersGenerator numbersGenerator) {
        this.count = purchaseAmount.calculateLottoCount();
        this.numbersGenerator = numbersGenerator;
    }

    public LottoTicket generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = numbersGenerator.generate();
            lottos.add(new Lotto(numbers));
        }
        return new LottoTicket(lottos);
    }
}
