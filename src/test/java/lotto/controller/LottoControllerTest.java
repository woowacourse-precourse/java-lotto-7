package lotto.controller;

import lotto.model.Lotto;
import lotto.model.ResultCalculator;
import lotto.model.WinningNumbers;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.constants.Constants.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoControllerTest {

    private LottoController lottoController;
    private PurchaseAmountValidator purchaseAmountValidator;
    private WinningNumberValidator winningNumberValidator;
    private ResultCalculator resultCalculator;

    @BeforeEach
    void setUp() {
        purchaseAmountValidator = new PurchaseAmountValidator();
        winningNumberValidator = new WinningNumberValidator();
        resultCalculator = new ResultCalculator();
        lottoController = new LottoController(purchaseAmountValidator, winningNumberValidator, resultCalculator);
    }

    @Test
    @DisplayName("구입 금액을 10000원 입력시, 생성되는 로또 수가 10개인지 테스트")
    void 구매_금액에_맞는_로또_생성_테스트() {
        int purchaseAmount = 10000;
        List<Lotto> lottos = new ArrayList<>();
        lottoController.generateLottos(lottos, purchaseAmount / LOTTO_PRICE.getValue());

        assertThat(lottos).hasSize(10);
    }

    @Test
    @DisplayName("올바른 당첨 번호와 보너스 번호 입력 시, 예외가 발생하지 않고 정상적으로 처리되는지 테스트")
    void 올바른_기능_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        WinningNumbers winningLotto = new WinningNumbers(new Lotto(winningNumbers), bonusNumber);

        assertThat(winningLotto.getWinningLotto().getNumbers()).isEqualTo(winningNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    @DisplayName("로또 범위가 넘어가는 당첨 번호 입력 시, IllegalArgumentException이 발생하는지 테스트")
    void 로또_번호_범위_검증_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 3000);

        assertThatThrownBy(() -> winningNumberValidator.validateWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 시, IllegalArgumentException이 발생하는지 테스트")
    void 로또_번호와_보너스_번호_중복_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 5;

        assertThatThrownBy(() -> winningNumberValidator.validateNotDuplication(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("범위가 넘어가는 보너스 번호 입력 시, IllegalArgumentException이 발생하는지 테스트")
    void 보너스_번호_범위_검증_테스트() {
        int bonusNumber = 3000;

        assertThatThrownBy(() -> winningNumberValidator.validateBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액이 유효하지 않을 경우, 예외가 발생하는지 테스트")
    void 유효하지_않은_구입_금액_테스트() {
        int invalidAmount = -5000;

        assertThatThrownBy(() -> purchaseAmountValidator.validatePurchaseAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}