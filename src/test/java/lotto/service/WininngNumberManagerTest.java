package lotto.service;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.repository.InMemoryLottoRepository;
import lotto.repository.LottoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class WininngNumberManagerTest {

    private WininngNumberManager winningNumberManager;
    private LottoRepository lottoRepository;

    @BeforeEach
    void setUp() {
        winningNumberManager = new WininngNumberManager();
        lottoRepository = new InMemoryLottoRepository();
    }

    @Test
    void createWinningNumber_savesAndRetrievesWinningNumberSuccessfully() {
        // given
        String[] inputWinningNumber = {"1", "2", "3", "4", "5", "6"};

        // when
        winningNumberManager.createWinningNumber(inputWinningNumber, lottoRepository);

        // then
        Lotto winningLotto = lottoRepository.getWinningNumbers();
        assertNotNull(winningLotto, "로또 객체가 반환되지 않았습니다.");
    }

    @Test
    void createBonusNumber_savesBonusNumberToRepository() {
        // given
        String[] inputWinningNumber = {"1", "2", "3", "4", "5", "6"};
        int bonusNumber = 7;

        winningNumberManager.createWinningNumber(inputWinningNumber, lottoRepository);

        winningNumberManager.createBonusNumber(bonusNumber, lottoRepository);

        Bonus bonus = lottoRepository.getBonusNumber();
        assertNotNull(bonus);
        assertTrue(bonus.matching(List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    void createBonusNumber_throwsExceptionWhenBonusNumberIsDuplicated() {
        String[] inputWinningNumber = {"1", "2", "3", "4", "5", "6"};
        int duplicatedBonusNumber = 3;

        winningNumberManager.createWinningNumber(inputWinningNumber, lottoRepository);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> winningNumberManager.createBonusNumber(duplicatedBonusNumber, lottoRepository)
        );
        assertEquals("보너스 번호는 당첨 번호와 중복 될수 없습니다.", exception.getMessage());
    }
}
