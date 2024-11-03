package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningLottoTest {

    @CsvSource(value = {"7,SECOND", "8,THIRD"}, delimiter = ',')
    @ParameterizedTest
    void 로또보너스_번호가_존재확인(int bonusNumber, Rank rank) {
        Lotto lotto = Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6)), bonusNumber);

        assertThat(winningLotto.match(lotto)).isEqualTo(rank);
    }

    @Test
    void 로또번호에_당첨번호가_존해하면예외가_발생한다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(Lotto.fromIntegers(List.of(1, 2, 3, 4, 5, 6)), 6));
    }
}
