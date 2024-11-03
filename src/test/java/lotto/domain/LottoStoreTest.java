package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoStoreTest {
    LottoStore lottoStore;

    @BeforeEach
    void setUp() {
        lottoStore = new LottoStore();
    }

    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "7000, 7", "50000, 50", "100000, 100"})
    void 구입금액에_맞는_로또_구매_개수를_반환한다(int amount, int tickets) {
        //given
        Money money = Money.from(amount);
        //when
        int lottoTickets = lottoStore.calculateLottoQuantity(money);
        //then
        assertThat(lottoTickets).isEqualTo(tickets);
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 10010, 50500})
    void 구입금액이_천원단위가_아니면_예외가_발생한다(int amount) {
        //given
        Money money = Money.from(amount);
        //when
        //then
        assertThatThrownBy(() -> lottoStore.calculateLottoQuantity(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000원 단위로 구매해주세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {999, 0, -1000})
    void 구입금액이_최소금액을_못채우면_예외가_발생한다(int amount) {
        //given
        Money money = Money.from(amount);
        //when
        //then
        assertThatThrownBy(() -> lottoStore.calculateLottoQuantity(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 최소 1000원부터 최대 100000원까지 구매 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {100001, 101000})
    void 구입금액이_최대금액을_넘어가면_예외가_발생한다(int amount) {
        //given
        Money money = Money.from(amount);
        //when
        //then
        assertThatThrownBy(() -> lottoStore.calculateLottoQuantity(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 최소 1000원부터 최대 100000원까지 구매 가능합니다.");
    }
}