package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.dto.UserLotto;
import lotto.dto.WinningResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoServiceTest {

    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "2000, 2", "10000, 10"})
    void 사용자_로또_발행_테스트(long buyAmount, int lottoCount) {
        //given
        LottoService service = new LottoService();

        //when
        UserLotto userLotto = service.getValidUserLotto(buyAmount);

        //then
        Assertions.assertThat(userLotto.getLottos().size()).isEqualTo(lottoCount);
    }

    @DisplayName("입력 받은 당첨 번호 문자열을 파싱해 WinningLotto 객체로 반환한다.")
    @Test
    void 당첨_번호_객체_변환_테스트() {
        //given
        LottoService service = new LottoService();
        String inputWinningNumbers = "1,11,12,14,36,25";

        //when
        Assertions.assertThatCode(() -> service.convertWinningNumbers(inputWinningNumbers))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,a", "1,,2,3,4,5,6", "1:2,3,4,5,6"})
    @DisplayName("입력 받은 당첨 번호에 숫자와 구분자가 아닌 문자가 존재하면 예외가 발생한다.")
    void 당첨_번호_객체_변환_예외_테스트(String inputWinningNumbers) {
        //given
        LottoService service = new LottoService();

        //when & then
        Assertions.assertThatThrownBy(() -> service.convertWinningNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_결과_계산_테스트() {
        //given
        LottoService service = new LottoService();

        UserLotto userLotto = new UserLotto(1, List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        long buyAmount = 1000;
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 11, 12)));
        int bonusNumber = 13;

        //when
        WinningResult result = service.calculateWinningResult(userLotto, buyAmount, winningLotto, bonusNumber);

        //then
        Assertions.assertThat(result.getResult()).isNotNull();
        Assertions.assertThat(result.getPrize()).isEqualTo(50_000L);
        Assertions.assertThat(result.getRateOfReturn()).isEqualTo(5000.0);

    }
}
