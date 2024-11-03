package lotto.utils;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.constant.ErrorMessage.WINNING_NUMBER_FORMAT_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoUtilsTest {
    @DisplayName("입력 숫자만큼 로또 생성")
    @Test
    void 입력_숫자만큼_로또_생성() {
        List<Lotto> lottos = LottoUtils.lottoGenerator(8);
        assertThat(lottos.size()).isEqualTo(8);
    }

    @DisplayName("사용자 로또 당첨 번호 입력을 숫자로 변경한다.")
    @Test
    void 사용자_로또_당첨_번호_입력을_숫자로_변경한다() {
        List<Integer> lottoNumber = LottoUtils.generateWinningNumber("1,2,3,4,5,6");

        assertThat(lottoNumber.size()).isEqualTo(6);
        assertThat(lottoNumber.contains(1)).isTrue();
        assertThat(lottoNumber.contains(2)).isTrue();
        assertThat(lottoNumber.contains(3)).isTrue();
        assertThat(lottoNumber.contains(4)).isTrue();
        assertThat(lottoNumber.contains(5)).isTrue();
        assertThat(lottoNumber.contains(6)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,a,2,3,5,6",
            "1 ,2,3,4,5,6",
            "   ,   ,   ,3,4,5"
    })
    @DisplayName("숫자로 변경하지 못하면 에러 발생")
    void 숫자_변경_실패_에러_발생(final String userInput) {
        assertThatThrownBy(() -> LottoUtils.generateWinningNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBER_FORMAT_ERROR_MESSAGE);
    }

}