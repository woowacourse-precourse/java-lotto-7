package lotto.domain.money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMoneyTest {

    @DisplayName("로또 가격 테스트")
    @Test
    void lottoMoneyTest() {
        LottoMoney lottoMoney = new LottoMoney(50000);
        assertAll(() -> assertThat(lottoMoney.getPurchasedAmount()).isEqualTo(50000),
                () -> assertThat(lottoMoney.getLottoCount()).isEqualTo(50)
        );
    }
}
