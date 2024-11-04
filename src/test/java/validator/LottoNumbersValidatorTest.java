package validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersValidatorTest {

    private List<Integer> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개일 때 예외가 발생하지 않는다.")
    void 로또_번호_개수가_6개여서_예외가_발생하지_않는다() {
        // when, then
        assertThatCode(() -> LottoNumbersValidator.validateLottoNumbers(lottoNumbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개가 아닐 때 예외가 발생한다.")
    void 로또_번호_개수가_5개여서_예외가_발생한다() {
        // given
        List<Integer> invalidLottoNumbers = List.of(1, 2, 3, 4, 5); // 5개 번호

        // when, then
        assertThatThrownBy(() -> LottoNumbersValidator.validateLottoNumbers(invalidLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
