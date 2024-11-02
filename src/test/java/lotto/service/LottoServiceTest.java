package lotto.service;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @DisplayName("로또_번호_컬렉션_생성_테스트")
    @Test
    void 로또_번호_컬렉션_생성_테스트() {
        Amount amount = Amount.of("10000");
        Amount amount2 = Amount.of("5000");
        Amount amount3 = Amount.of("15000");

        Lottos lottos = lottoService.createLottos(amount);
        Lottos lottos2 = lottoService.createLottos(amount2);
        Lottos lottos3 = lottoService.createLottos(amount3);

        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(10);
        Assertions.assertThat(lottos2.getLottos().size()).isEqualTo(5);
        Assertions.assertThat(lottos3.getLottos().size()).isEqualTo(15);
    }

    @DisplayName("당첨 번호 입력시 로또 객채로 생성되어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "10,11,12,13,14,15"})
    void 당첨_번호_입력시_로또_객체로_생성되어야_한다(String input) {
        Lotto winningNumber = lottoService.parseWinningNumberForLotto(input);

        Assertions.assertThat(winningNumber).isInstanceOf(Lotto.class);
    }

}
