package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.config.AppConfig;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void init() {
        AppConfig appConfig = AppConfig.getAppConfig();
        lottoService = appConfig.lottoService();
    }

    @DisplayName("지불액 입력 시, 빈칸이 포함되어 입력되는 경우")
    @Test
    void 지불액_빈칸_입력_테스트() {
        // given
        String input = "50 00";

        // when
        int payment = lottoService.parsePayment(input);

        //then
        assertThat(payment).isEqualTo(5000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5500", "6500", "7500"})
    void 지불액_예외_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> lottoService.parsePayment(input));
    }

    @DisplayName("당첨번호 입력 시, 맨 뒤에 쉼표가 입력되는 경우")
    @Test
    void 당첨번호_쉼표_입력_테스트() {
        // given
        String input = "1,2,3,4,5,6,";

        // when
        List<Integer> winningNumbers = lottoService.parseWinningNumbers(input);

        // then
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨번호 입력 시, 빈칸이 포함되어 입력되는 경우")
    @Test
    void 당첨번호_빈칸_입력_테스트() {
        // given
        String input = "1, 2, 3,4 ,5 ,6 ";

        // when
        List<Integer> winningNumbers = lottoService.parseWinningNumbers(input);

        // then
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,2,2,3,4,5",
            "1,2,3,4,5,6,7",
            "1,2,3,4,5,46"
    })
    void 당첨번호_예외_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> lottoService.parseWinningNumbers(input));
    }

    @DisplayName("보너스 번호 입력 시, 빈칸이 포함되어 입력되는 경우")
    @Test
    void 보너스_번호_빈칸_입력_테스트() {
        // given
        String input = "7 ";

        // when
        int bonus = lottoService.parseBonus(input);

        //then
        assertThat(bonus).isEqualTo(7);
    }

    @DisplayName("로또 발행 시, 중복이 포함되지 않는지 검증")
    @ParameterizedTest
    @ValueSource(ints = {3000, 4000, 5000})
    void 로또_발행_테스트(int payment) {
        // when
        List<Lotto> lottos = lottoService.issueLottos(payment);
        List<Lotto> distinctLottos = lottos.stream().distinct().toList();

        // then
        assertThat(lottos).isEqualTo(distinctLottos);
    }
}