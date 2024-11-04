package lotto.domain;

import static lotto.domain.Lotto.LOTTO_DUPLICATE_ERROR_MSG;
import static lotto.domain.Lotto.LOTTO_SIZE_ERROR_MSG;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_SIZE_ERROR_MSG);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_DUPLICATE_ERROR_MSG);
    }

    @Test
    public void 로또_로또번호_출력_정상테스트() throws Exception {
        //Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        String expected = "[1, 2, 3, 4, 5, 6]";

        //When
        String actual = lotto.retrieveLottoNumber();

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 로또_정렬_정상테스트() throws Exception {
        //Given
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        String expected = "[1, 2, 3, 4, 5, 6]";

        //When
        String actual = lotto.retrieveLottoNumber();

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }


    @Test
    public void 로또_발행_정상테스트() throws Exception {
        //Given

        //When, Then
        Assertions.assertThatCode(Lotto::issue).doesNotThrowAnyException();
    }
}
