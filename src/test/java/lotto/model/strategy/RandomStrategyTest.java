package lotto.model.strategy;

import static org.assertj.core.api.Assertions.*;

import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomStrategyTest {

    private RandomStrategy randomStrategy;

    @BeforeEach
    void beforeEach() {
        randomStrategy = RandomStrategy.of();
    }

    @Test
    void 로또_번호가_랜덤으로_선택되어_로또가_생성됩니다() {
        assertThat(randomStrategy.generateLotto()).isInstanceOf(Lotto.class);
    }

    @Test
    void 랜덤으로_생성된_로또는_6개의_숫자를_가집니다() {
        Lotto lotto = randomStrategy.generateLotto();
        assertThat(lotto.getSize()).isEqualTo(6);
    }

}