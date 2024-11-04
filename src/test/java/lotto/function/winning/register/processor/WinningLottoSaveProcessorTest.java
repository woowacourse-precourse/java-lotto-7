package lotto.function.winning.register.processor;

import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import lotto.domain.BonusLotto;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.repository.WinningLottoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningLottoSaveProcessorTest {

    WinningLottoSaveProcessor winningLottoSaveProcessor;

    @BeforeEach
    void setUp() {
        WinningLottoRepository winningLottoRepository = new WinningLottoRepository() {
            @Override
            public void save(WinningLotto winningLotto) {
            }

            @Override
            public WinningLotto findLast() {
                return null;
            }
        };
        winningLottoSaveProcessor = new WinningLottoSaveProcessor(winningLottoRepository);
    }

    @Test
    void 당첨_번호를_저장한다() {
        assertThatNoException().isThrownBy(() ->
                winningLottoSaveProcessor.saveWinningLotto(
                        new WinningLotto(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new BonusLotto(9))));
    }
}