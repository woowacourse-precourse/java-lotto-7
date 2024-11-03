package lotto.service;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("구입 금액에 따라 로또가 발행된다.")
    @Test
    void issueLotto() {
        // given
        int price = 5000;

        // when
        List<Lotto> lottoTickets = lottoService.issueLotto(price);

        // then
        assertEquals(5, lottoTickets.size());
    }

    @DisplayName("발행된 로또 번호는 6개다.")
    @Test
    void issueLotto_SizeIs6() {
        // given
        int price = 2000;

        // when
        List<Lotto> lottoTickets = lottoService.issueLotto(price);

        // then
        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = lotto.getNumbers();
            assertEquals(6, numbers.size());
        }
    }

    @DisplayName("발행된 로또 티켓의 각 번호는 중복되지 않는다.")
    @Test
    void issueLotto_GeneratesUniqueNumbers() {
        // given
        int price = 3000;

        // when
        List<Lotto> lottoTickets = lottoService.issueLotto(price);

        // then
        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = lotto.getNumbers();
            Set<Integer> uniqueNumbers = new HashSet<>(numbers);
            assertEquals(6, uniqueNumbers.size());
        }
    }
}
