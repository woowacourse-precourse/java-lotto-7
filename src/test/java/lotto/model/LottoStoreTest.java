package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoStoreTest {

    @DisplayName("구입 금액은 반드시 천원단위로 떨어져야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1_200, 10_400, 15_012, 50_001})
    void notThousandUnit(int purchaseAmount) {

        assertThatThrownBy(() -> LottoStore.purchaseLottoTicket(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구입 금액은 반드시 천원 단위로 떨어져야 합니다. 다시 입력해 주세요.");
    }

    @DisplayName("구입 금액은 10만원을 초과할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {100_001, 100_002, 200_000})
    void overOneHundredThousandPurchaseAmount(int purchaseAmount) {

        assertThatThrownBy(() -> LottoStore.purchaseLottoTicket(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("한번 구매할때 10만원 이하로 구매할 수 있습니다. 다시 시도해 주세요.");
    }

    @DisplayName("구입금액 / 1000 만큼의 로또가 들어가있는 로또 티켓이 생성되어야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "12000, 12", "100000, 100"})
    void purchaseLottoTicket(int purchaseAmount, int expected) {

        LottoTicket lottoTicket = LottoStore.purchaseLottoTicket(purchaseAmount);

        assertThat(lottoTicket.getLottoCount()).isEqualTo(expected);
    }
}