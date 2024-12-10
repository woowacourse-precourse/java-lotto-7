package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.common.ErrorMessages;
import lotto.common.LottoConstants;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_허용_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.LOTTO_RANGE_MESSAGE);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.LOTTO_RANGE_MESSAGE);
    }

    @Test
    void 로또_번호는_자동으로_정렬되어_저장된다() {
        Lotto lotto = new Lotto(List.of(5, 3, 6, 1, 4, 2));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void from_메서드는_유효한_로또_객체를_생성한다() {
        Lotto lotto = Lotto.from();
        String[] lottoNumbers = lotto.toString()
                .replaceAll("[^0-9,]", "")
                .split(",");
        assertThat(lottoNumbers).hasSize(LottoConstants.LOTTO_SIZE);
    }

    @Test
    void 로또번호와_당첨번호의_일치_개수를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        int matchCount = lotto.getMatchCount(List.of(1, 2, 3, 4, 5, 6));
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    void 보너스번호가_포함되면_true를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("6", List.of(7, 8, 9, 10, 11, 12));
        assertThat(lotto.includesBonusNumber(bonusNumber)).isTrue();
    }

    @Test
    void 보너스번호가_포함되지_않으면_false를_반환한다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("7", List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.includesBonusNumber(bonusNumber)).isFalse();
    }
}
