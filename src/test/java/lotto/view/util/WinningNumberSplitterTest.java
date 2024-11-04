package lotto.view.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberSplitterTest {

    private WinningNumberSplitter winningNumberSplitter;

    @BeforeEach
    void setUp() {
        winningNumberSplitter = new WinningNumberSplitter();
    }

    @Test
    void 유효한_형식의_당첨번호를_입력하면_구분자_콤마로_파싱한다() {
        //given
        String input = "1,2,3,4,5,6";
        //when
        List<String> winningNumbers = winningNumberSplitter.splitWinningNumber(input);
        //then
        assertThat(winningNumbers).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @Test
    void 입력된_당첨번호가_콤마로_끝나면_예외가_발생한다() {
        //given
        //when
        String input = "1,2,3,4,5,6,";
        //then
        assertThatThrownBy(() -> winningNumberSplitter.splitWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 잘못된 입력 형식입니다: ,다음 숫자를 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.2.3.4.5.6", "1&2&3&4&5&6", "1,2.3,4.5,6", "1!2,3,4,5,6"})
    void 입력된_당첨번호에_숫자와_콤마외_다른_문자가_존재하면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> winningNumberSplitter.splitWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력할 수 있으며, 구분자는 ,만 사용할 수 있습니다.");
    }
}