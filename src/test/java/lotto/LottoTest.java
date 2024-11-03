package lotto;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @CsvSource(value =
            {"3,4,12,15,26,34:6:false",
            "3,4,6,12,15,26:5:true",
            "3,4,12,15,26,35:5:false"},
            delimiter = ':')
    void 로또의_당첨을_확인한다(String numbers, int count, boolean bonus) {
        Lotto lotto = new Lotto(Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        InputValidator.winningNumberValidator("3,4,12,15,26,34");
        InputValidator.bonusNumberValidator("6");

        assertThat(lotto.confirmWinning().getMatchCount()).isEqualTo(count);
        assertThat(lotto.confirmWinning().getBonusMatch()).isEqualTo(bonus);
    }
}
