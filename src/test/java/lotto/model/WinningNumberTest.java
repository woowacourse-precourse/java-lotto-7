package lotto.model;

import lotto.dto.LottoDto;
import lotto.dto.WinningNumberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    @DisplayName("당첨 번호 문자열이 쉼표로 구분되어 리스트로 올바르게 생성되었는지 확인")
    @Test
    public void 당첨_번호_생성_확인() {
        WinningNumberDto winningNumberDto = new WinningNumber("1,2,3,4,5,6", 8).toWinningNumberDto();
        LottoDto lottoDto = winningNumberDto.lotto().toLottoDto();

        assertThat(lottoDto.numbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호가 중복된 숫자이면 예외가 발생한다.")
    @Test
    void 보너스_번호가_중복된_숫자이면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 범위가 1에서 45사이가 아니면 예외가 발생한다.")
    @Test
    void 보너스_번호의_범위가_1에서_45사이가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,68", 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 형식이 올바르지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", ",", ",,,,,", "1,2,3,4,5,6,"})
    void 당첨_번호_입력_형식이_올바르지_않으면_예외가_발생한다(String numbers) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new WinningNumber(numbers, 7))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
