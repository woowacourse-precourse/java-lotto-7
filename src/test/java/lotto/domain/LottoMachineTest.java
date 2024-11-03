package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.LottoValues.LOTTO_NUMBER_MAX;
import static lotto.constant.LottoValues.LOTTO_NUMBER_MIN;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("로또 번호의 범위는 1~45이다.")
    @Test
    public void lottoNumbersScope() {
        // given & when
        List<Integer> numbers = lottoMachine.generateNumbers();

        // then
        assertThat(numbers).allMatch(number -> number >= LOTTO_NUMBER_MIN.value() && number <= LOTTO_NUMBER_MAX.value());

    }

    @DisplayName("로또는 주어진 수량만큼 발급되어야 한다.")
    @Test
    public void lottoCount() {
        // given
        long lottoCount = 324;

        // when
        Lottos lottos = lottoMachine.issue(lottoCount);

        // then
        assertThat(lottos.getLottoCount()).isEqualTo(lottoCount);
    }

    @DisplayName("하나의 로또는 중복되지 않는 6개의 숫자로 이루어져야 한다.")
    @Test
    public void lottoNumbersDuplicate() {
        // given
        List<Integer> numbers = lottoMachine.generateNumbers();

        // when
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        // then
        assertThat(numbers.size()).isEqualTo(uniqueNumbers.size());
    }
}
