package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = LottoMachine.create();
    }

    @Test
    void 로또_번호가_정상적으로_생성된다() {
        // when
        Lotto lotto = lottoMachine.generateLotto();

        // then
        List<Integer> numbers = lotto.getNumbers();
        assertThat(numbers).hasSize(6);
        assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
        assertThat(numbers).doesNotHaveDuplicates();
    }
}