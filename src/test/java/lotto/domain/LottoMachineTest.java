package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    void testGetLottoTickets() {
        int inputAmount = 5000;
        lottoMachine.insertAmount(inputAmount);

        LottoTickets tickets = lottoMachine.getLottoTickets();

        assertSoftly(softly -> {
            softly.assertThat(tickets).isNotNull();
            softly.assertThat(tickets.getLottoTickets().size()).isEqualTo(inputAmount / 1000);
        });
    }

    @Test
    void testInsertAmount_validAmount() {
        int inputAmount = 3000;

        assertThatCode(() -> lottoMachine.insertAmount(inputAmount)).doesNotThrowAnyException();
    }

    @Test
    void testInsertAmount_invalidAmount() {
        int invalidAmount = 1500;

        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> lottoMachine.insertAmount(invalidAmount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        });
    }

    @Test
    void testGenerateLotto_withoutAmount() {
        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> lottoMachine.getLottoTickets())
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("[ERROR] 구입 금액을 넣지 않았습니다.");
        });

    }
}