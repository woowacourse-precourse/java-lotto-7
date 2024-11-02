package lotto.model.lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {
    private LottoStore lottoStore;

    @BeforeEach
    void setUp() {
        lottoStore = new LottoStore();
    }

    @Nested
    @DisplayName("정상 케이스")
    class ValidCases {
        @Test
        @DisplayName("예산이 8,000원일 때 티켓 개수는 8개")
        void calculateTicketsCount_WithValidBudget() {
            int budget = 8_000;
            int expectedTicketCount = 8;
            assertEquals(expectedTicketCount, lottoStore.calculateTicketsCount(budget));
        }

        @Test
        @DisplayName("예산이 10,000원일 때 티켓 개수는 10개")
        void calculateTicketsCount_WithAnotherValidBudget() {
            int budget = 10_000;
            int expectedTicketCount = 10;
            assertEquals(expectedTicketCount, lottoStore.calculateTicketsCount(budget));
        }
    }

}
