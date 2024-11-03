package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.exception.message.Error;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    private static Stream<List<LottoNumber>> createOverSizeLotto() {
        return Stream.of(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(7))
        );
    }

    private static Stream<List<LottoNumber>> createDuplicatedLotto() {
        return Stream.of(
                List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(5))
        );
    }

    @ParameterizedTest
    @MethodSource("createOverSizeLotto")
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다(List<LottoNumber> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("createOverSizeLotto")
    @DisplayName("로또 번호의 갯수가 맞지 않으면, 해당 문구를 출력한다")
    void throw_when_lotto_size_is_incorrect(List<LottoNumber> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Error.NOT_FIX_SIZE.formatMessageOf(6));
    }

    @ParameterizedTest
    @MethodSource("createOverSizeLotto")
    @DisplayName("발생하는 예외 문구에는 캡션이 포함되어 있다")
    void message_has_caption(List<LottoNumber> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.CAPTION.getMessage());
    }

    @ParameterizedTest
    @MethodSource("createDuplicatedLotto")
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다(List<LottoNumber> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
