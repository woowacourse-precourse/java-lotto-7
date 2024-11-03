package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineUnitTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("로또 번호가 중복 없이 6개의 숫자로 구성된다.")
    @Test
    void 로또_번호_중복_없이_6개_생성() {
        // when
        Lotto lotto = lottoMachine.generateLotto();

        // then
        List<Integer> numbers = lotto.getNumbers();
        assertThat(numbers).hasSize(6);
        assertThat(numbers.stream().distinct().count()).isEqualTo(6);
    }

    @DisplayName("로또 번호는 1에서 45 사이의 숫자로 구성된다.")
    @Test
    void 로또_번호_범위_확인() {
        // when
        Lotto lotto = lottoMachine.generateLotto();

        // then
        List<Integer> numbers = lotto.getNumbers();
        assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
    }

}
