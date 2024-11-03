package lotto.domain.purchase;

import lotto.domain.play.LottoInventory;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.RandomLottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoInventoryGenerator {
    private LottoInventoryGenerator() {

    }

    public static LottoInventory generateFrom(UserMoney money) {
        RandomLottoGenerator randomLottoGenerator = RandomLottoGenerator.getInstance();
        List<Lotto> randomLottos = new ArrayList<>();
        int size = money.calculateAvailableLottoCount();
        for (int i = 0; i < size; i++) {
            randomLottos.add(randomLottoGenerator.generate());
        }
        return new LottoInventory(randomLottos);
    }
}
