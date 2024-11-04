package lotto.models;

import lotto.dto.PurchaseMoneyRequestDTO;
import lotto.generator.NumberGenerator;
import lotto.model.LottoStore;
import lotto.model.Lottos;
import lotto.model.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {
    private final LottoStore store = new LottoStore(NumberGenerator.RANDOM);

    @Test
    @DisplayName("구입 금액에 맞추어 정확한 개수의 로또를 판매한다.")
    public void sellLotto() {
        // GIVEN
        Money money = new Money(new PurchaseMoneyRequestDTO("10000"));

        // WHEN
        Lottos lottos = store.sellLotto(money);

        // THEN
        Assertions.assertThat(lottos.getLottos()).hasSize(10);
    }
}
