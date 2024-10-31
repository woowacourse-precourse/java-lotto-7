package lotto;

import lotto.dto.LottoResultDto;
import lotto.exception.ErrorMessage;
import lotto.service.LottoService;
import lotto.validator.LottoValidator;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {5001, 45010, 6100, 1100})
    void 구입금액이_나누어_떨어지는지_확인한다(int input) {
        AssertionsForClassTypes.assertThatThrownBy(() -> LottoValidator.validateLottoPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_DIVISIBLE_BY_LOTTO_PRICE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 500, 900, 999})
    void 부족한_금액으로_로또구매가_가능한지_확인한다(int input) {
        AssertionsForClassTypes.assertThatThrownBy(() -> LottoValidator.validateLottoPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_NOT_DIVISIBLE_BY_LOTTO_PRICE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 5000, 7000})
    void 구입한금액만큼_로또장수가_맞는지_확인한다(int input){
        int purchaseQuantity = input / 1000;

        LottoService lottoService = new LottoService();
        LottoResultDto dto = lottoService.createLottoList(input);

        assertThat(dto.getLottoList().size() == purchaseQuantity).isTrue();
    }
}
