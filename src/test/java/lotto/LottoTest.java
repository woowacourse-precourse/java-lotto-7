package lotto;

import lotto.collection.Lotto;
import lotto.collection.WinningNumber;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @ParameterizedTest
    @MethodSource("provideInvalidLottoNumbers")
    void 로또_번호의_개수가_기준과_다르면_예외가_발생한다(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<Integer>> provideInvalidLottoNumbers() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 6, 7), // 7개
                List.of(1, 2, 3),             // 3개
                List.of(1, 2),                // 2개
                List.of()                     // 0개
        );
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호에_문자가_있으면_예외가_발생한다() {
        String[] array = {"1", "2", "3", "a", "5", "6"};
        assertThatThrownBy(() -> new WinningNumber(array))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"6", "", " ", "a", "0", "46"})
    void 보너스_번호_유효성_검사_예외테스트(String bonusNumber) {
        String[] array = {"1", "2", "3", "4", "5", "6"};
        WinningNumber winningNumbers = new WinningNumber(array);

        assertThatThrownBy(() -> new LottoResult(winningNumbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
