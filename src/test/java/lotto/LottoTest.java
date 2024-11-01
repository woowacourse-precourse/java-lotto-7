package lotto;

import lotto.basic.NumbersGeneratorStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private NumbersGeneratorStub generatorStub;

    @BeforeEach
    void beforeEach() {
        generatorStub = new NumbersGeneratorStub();
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void test1() {
        generatorStub.setTestRandomNumbers(List.of(1, 2, 3, 4, 5, 6, 7));

        assertThatThrownBy(() -> Lotto.generate(generatorStub))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void test2() {
        generatorStub.setTestRandomNumbers(List.of(1, 2, 3, 4, 5, 5));

        assertThatThrownBy(() -> Lotto.generate(generatorStub))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 범위 밖에 있다면 예외가 발생한다.")
    @Test
    void test3() {
        generatorStub.setTestRandomNumbers(List.of(1, 2, 3, 999, 5, 6));

        assertThatThrownBy(() -> Lotto.generate(generatorStub))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
