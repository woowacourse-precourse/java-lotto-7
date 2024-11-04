package lotto.model.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LottoBuyerTest {

    private LottoBuyer lottoBuyer;
    private LottoStore lottoStore;

    @BeforeEach
    void setUp() {
        lottoBuyer = new LottoBuyer();
        lottoStore = new LottoStore();
    }

    @Nested
    @DisplayName("정상 케이스")
    class ValidCases {
        @Test
        @DisplayName("예산이 8,000원일 때 소유한 티켓 개수는 8개")
        void buyTickets_WithValidBudget() {
            int budget = 8_000;
            int expectedOwnedTickets = 8;

            lottoBuyer.buyTickets(budget, lottoStore);
            assertEquals(expectedOwnedTickets, lottoBuyer.getOwnedTickets());
        }

        @Test
        @DisplayName("예산이 5,000원일 때 소유한 티켓 개수는 5개")
        void buyTickets_WithAnotherValidBudget() {
            int budget = 5_000;
            int expectedOwnedTickets = 5;

            lottoBuyer.buyTickets(budget, lottoStore);
            assertEquals(expectedOwnedTickets, lottoBuyer.getOwnedTickets());
        }
    }
}