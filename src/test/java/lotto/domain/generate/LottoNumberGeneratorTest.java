package lotto.domain.generate;

import lotto.domain.entity.Lotto;
import lotto.domain.exception.LottoException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberGeneratorTest {

    @Test
    void 로또_넘버_생성_테스트() {
        // given
        final LottoNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(List.of(1,2,3,4,5,6));

        // when
        final Lotto lotto = fixedNumberGenerator.generateLotto();

        // then
        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    void 로또_넘버_생성시_숫자가_범위보다_크다면_예외처리() {
        // given & when & then
        assertThatThrownBy(() -> new FixedNumberGenerator(List.of(1,2,3,4,5,46))).isInstanceOf(LottoException.class);
    }

    @Test
    void 로또_넘버_생성시_숫자가_범위보다_작으면_예외처리() {
        // given & when & then
        assertThatThrownBy(() -> new FixedNumberGenerator(List.of(-1,2,3,4,5,6))).isInstanceOf(LottoException.class);
    }

    @Test
    void 로또_넘버_생성시_숫자가_6자리가_아니면_예외처리() {
        // given & when & then
        assertThatThrownBy(() -> new FixedNumberGenerator(List.of(1,2,3,4,5))).isInstanceOf(LottoException.class);
    }

    @Test
    void 로또_넘버_생성시_숫자가_중복이라면_예외처리() {
        // given & when & then
        assertThatThrownBy(() -> new FixedNumberGenerator(List.of(1,2,3,4,5,5))).isInstanceOf(LottoException.class);
    }
}
