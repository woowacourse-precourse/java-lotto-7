package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("구입 금액에 따라 로또가 발행된다.")
    @Test
    void issueLotto() {
        int price = 5000;
        List<Lotto> lottoTickets = lottoService.issueLotto(price);
        assertEquals(5, lottoTickets.size());
    }

    @DisplayName("발행된 로또 번호는 6개다.")
    @Test
    void issueLotto_SizeIs6() {
        int price = 2000;
        List<Lotto> lottoTickets = lottoService.issueLotto(price);
        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = lotto.getNumbers();
            assertEquals(6, numbers.size());
        }
    }

    @DisplayName("발행된 로또 티켓의 각 번호는 중복되지 않는다.")
    @Test
    void issueLotto_GeneratesUniqueNumbers() {
        int price = 3000;
        List<Lotto> lottoTickets = lottoService.issueLotto(price);
        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = lotto.getNumbers();
            Set<Integer> uniqueNumbers = new HashSet<>(numbers);
            assertEquals(6, uniqueNumbers.size());
        }
    }

    @DisplayName("발행된 로또 번호는 1부터 45 사이의 값이다.")
    @Test
    void issueLotto_NumbersInRange() {
        int price = 4000;
        List<Lotto> lottoTickets = lottoService.issueLotto(price);
        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = lotto.getNumbers();
            for (Integer number : numbers) {
                assertTrue(number >= 1 && number <= 45, "로또 번호는 1부터 45 사이여야 합니다.");
            }
        }
    }

    @DisplayName("당첨 번호와 보너스 번호를 포함한 WinningLotto를 올바르게 생성한다.")
    @Test
    void issueWinningLotto() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        WinningLotto winningLotto = lottoService.issueWinningLotto(winningNumbers, bonusNumber);

        assertEquals(winningNumbers, winningLotto.getLotto().getNumbers());
        assertEquals(bonusNumber, winningLotto.getBonusNumber());
    }

    @DisplayName("WinningLotto 생성 시 당첨 번호는 오름차순으로 정렬되어야 한다.")
    @Test
    void issueWinningLotto_SortedWinningNumbers() {
        List<Integer> winningNumbers = List.of(6, 5, 4, 3, 2, 1);
        int bonusNumber = 7;

        WinningLotto winningLotto = lottoService.issueWinningLotto(winningNumbers, bonusNumber);
        List<Integer> sortedWinningNumbers = winningLotto.getLotto().getNumbers();

        assertEquals(List.of(1, 2, 3, 4, 5, 6), sortedWinningNumbers);
    }
}
