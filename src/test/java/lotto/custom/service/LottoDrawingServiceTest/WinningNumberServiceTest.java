package lotto.custom.service.LottoDrawingServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.custom.common.ErrorMessages;
import lotto.custom.service.LottoDrawingService;
import lotto.custom.validator.CustomErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberServiceTest {
    private final LottoDrawingService lottoDrawingService = new LottoDrawingService();

    @DisplayName("서비스_당첨번호입력_NULL일때_테스트")
    @Test
    void 서비스_당첨번호입력_NULL일때_테스트() {
        assertThatThrownBy(() -> lottoDrawingService.drawWinningNumbers(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.NULL_INPUT);
    }

    @DisplayName("서비스_당첨번호입력_빈문자열일때_테스트")
    @Test
    void 서비스_당첨번호입력_빈문자열일때_테스트() {
        assertThatThrownBy(() -> lottoDrawingService.drawWinningNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.EMPTY_STRING_INPUT);
    }

    @DisplayName("서비스_당첨번호입력_공백으로구성되어있을때_테스트")
    @Test
    void 서비스_당첨번호입력_공백으로구성되어있을때_테스트() {
        assertThatThrownBy(() -> lottoDrawingService.drawWinningNumbers("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.WHITESPACE_ONLY_INPUT);
    }

    @DisplayName("서비스_당첨번호입력_쉼표공백숫자를제외한문자가존재할때_테스트")
    @Test
    void 서비스_당첨번호입력_쉼표공백숫자를제외한문자가존재할때_테스트() {
        assertThatThrownBy(() -> lottoDrawingService.drawWinningNumbers("1, 2, 3*4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_CHARACTERS_INPUT);
    }

    @DisplayName("서비스_당첨번호입력_숫자와숫자사이에공백이존재할때_테스트")
    @Test
    void 서비스_당첨번호입력_숫자와숫자사이에공백이존재할때_테스트() {
        assertThatThrownBy(() -> lottoDrawingService.drawWinningNumbers("1, 2, 3, 4 5 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.SPACES_BETWEEN_NUMBERS);
    }

    @DisplayName("서비스_당첨번호입력_숫자가6개가아닐때_테스트")
    @Test
    void 서비스_당첨번호입력_숫자가6개가아닐때_테스트() {
        assertThatThrownBy(() -> lottoDrawingService.drawWinningNumbers("1, 2, 3, 4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CustomErrorMessages.LOTTO_NUMBER_COUNT);
    }

    @DisplayName("서비스_당첨번호입력_숫자가중복될때_테스트")
    @Test
    void 서비스_당첨번호입력_숫자가증복될때_테스트() {
        assertThatThrownBy(() -> lottoDrawingService.drawWinningNumbers("1, 2, 3, 4, 5, 5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CustomErrorMessages.LOTTO_NUMBERS_MUST_BE_UNIQUE);
    }

    @DisplayName("서비스_당첨번호입력_숫자의범위가1에서45가아닐때_테스트")
    @Test
    void 서비스_당첨번호입력_숫자의범위가1에서45가아닐때_테스트() {
        assertThatThrownBy(() -> lottoDrawingService.drawWinningNumbers("1, 2, 3, 4, 5, 46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CustomErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE);
    }

    @DisplayName("서비스_쉼표정리메소드_연속된쉼표제거_테스트")
    @Test
    void 서비스_쉼표정리메소드_연속된쉼표제거_테스트() {
        String input = "1,,,2,,,3,4,5,6";
        String result = lottoDrawingService.cleanConsecutiveCommas(input);
        assertThat(result).isEqualTo("1,2,3,4,5,6");
    }

    @DisplayName("서비스_쉼표정리메소드_앞뒤단일쉼표제거__테스트")
    @Test
    void 서비스_쉼표정리메소드_앞뒤단일쉼표제거_테스트() {
        String input = ",1,2,3,4,5,6,";
        String result = lottoDrawingService.cleanConsecutiveCommas(input);
        assertThat(result).isEqualTo("1,2,3,4,5,6");
    }

    @DisplayName("서비스_쉼표정리메소드_앞뒤연속된쉼표제거_테스트")
    @Test
    void 서비스_쉼표정리메소드_앞뒤연속된쉼표제거_테스트() {
        String input = ",,,1,2,3,4,5,6,,,";
        String result = lottoDrawingService.cleanConsecutiveCommas(input);
        assertThat(result).isEqualTo("1,2,3,4,5,6");
    }

    @DisplayName("서비스_문자열분리메소드_테스트")
    @Test
    void 서비스_문자열분리메소드_테스트() {
        String input = "1,2,3,4,5,6";
        List<String> result = lottoDrawingService.splitStringByComma(input);
        assertThat(result).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @DisplayName("서비스_앞뒤공백제거메소드_단일공백_테스트")
    @Test
    void 서비스_앞뒤공백제거메소드_단일공백_테스트() {
        List<String> input = Arrays.asList(" 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ");
        List<Integer> result = lottoDrawingService.trimWinningNumbers(input);
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("서비스_앞뒤공백제거메소드_연속공백_테스트")
    @Test
    void 서비스_앞뒤공백제거메소드_연속공백_테스트() {
        List<String> input = Arrays.asList("  1 ", "  2  ", "   3   ", "  4  ", "  5  ", "  6  ");
        List<Integer> result = lottoDrawingService.trimWinningNumbers(input);
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("서비스_전체실행_테스트")
    @Test
    void 서비스_전체실행_테스트() {
        List<Integer> result = lottoDrawingService.drawWinningNumbers("1, 2, 3, 4, 5, 6");
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }
}