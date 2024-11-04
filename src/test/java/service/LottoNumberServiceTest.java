package service;

import lotto.service.LottoNumberService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

public class LottoNumberServiceTest {

    @Test
    void createLottoNumbers_ShouldReturnUniqueNumbers() {
        // when
        List<Integer> lottoNumbers = LottoNumberService.createLottoNumbers();

        // then
        assertThat(lottoNumbers).hasSize(6); // 로또 번호의 개수는 6개여야 함
        assertThat(lottoNumbers).doesNotHaveDuplicates(); // 중복 숫자가 없어야 함
        assertThat(lottoNumbers).allMatch(number -> number >= 1 && number <= 45); // 모든 번호가 1부터 45 사이여야 함
    }

    @Test
    void splitLottoNumbers_ShouldReturnCorrectList_WhenValidInput() {
        // given
        String input = "1, 2, 3, 4, 5, 6";

        // when
        List<Integer> lottoNumbers = LottoNumberService.splitLottoNumbers(input);

        // then
        assertThat(lottoNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void splitLottoNumbers_ShouldThrowException_WhenInputIsInvalid() {
        // given
        String input = "1, 2, a, 4, 5, 6"; // 'a'는 숫자가 아님

        // when & then
        assertThatThrownBy(() -> LottoNumberService.splitLottoNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호를 다시 확인해 주세요.");
    }

    @Test
    void splitLottoNumbers_ShouldIgnoreEmptySpaces() {
        // given
        String input = "1, 2,  , 4, 5, 6, 7"; // 빈칸 포함

        // when
        List<Integer> lottoNumbers = LottoNumberService.splitLottoNumbers(input);

        // then
        assertThat(lottoNumbers).containsExactly(1, 2, 4, 5, 6, 7);
    }
}
