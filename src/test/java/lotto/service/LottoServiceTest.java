package lotto.service;

import lotto.exception.ErrorMessages;
import lotto.wrapper.Amount;
import lotto.wrapper.BonusNumber;
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
        Lotto winningNumber = lottoService.createWinningNumbers(input);

        Assertions.assertThat(winningNumber).isInstanceOf(Lotto.class);
    }

    @DisplayName("당첨 번호 입력시 1 ~ 45 사이의 자연수가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0,2,3,4,5,6", "1,2,3,4,5,46"})
    void 당첨_번호_입력시_범위_예외_발생_테스트(String input) {
        Assertions.assertThatThrownBy(() -> lottoService.createWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_LOTTO_RANGE.getMessage());
    }

    @DisplayName("보너스 번호 입력시 BonusNumber 객체로 생성되어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"34", "25", "36", "45", "15", "26"})
    void 보너스_번호_입력시_BonusNumber_객체로_생성되어야_한다(String input) {
        Lotto winningNumber = lottoService.createWinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = lottoService.createBonusNumber(input, winningNumber);

        Assertions.assertThat(bonusNumber).isInstanceOf(BonusNumber.class);
    }

    @DisplayName("보너스 번호 입력시 당첨 번호와 중복되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void 보너스_번호_입력시_당첨_번호와_중복_예외_발생_테스트(String input) {
        Lotto winningNumber = lottoService.createWinningNumbers("1,2,3,4,5,6");

        Assertions.assertThatThrownBy(() -> lottoService.createBonusNumber(input, winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.INVALID_BONUS_NUMBER.getMessage());
    }

}
