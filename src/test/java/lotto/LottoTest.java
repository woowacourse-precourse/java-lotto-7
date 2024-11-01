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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void 구입한금액만큼_로또장수가_맞는지_확인한다(int input) {
        int purchaseQuantity = input / 1000;

        LottoService lottoService = new LottoService();
        LottoResultDto dto = lottoService.createLottoList(input);

        assertThat(dto.getLottoList().size() == purchaseQuantity).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,15,26,27,30,41,44", "5,25,31,37,40", "1,2,4,5,6,7,25", "35"})
    void 당첨번호가_6개_이하_또는_이상일때(String input) {
        List<Integer> list = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        AssertionsForClassTypes.assertThatThrownBy(() -> new Lotto(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,4,16,25,30", "5,25,31,37,40,37", "1,2,4,4,6,7"})
    void 중복된_당첨번호가_있는지_확인한다(String input) {
        List<Integer> list = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        AssertionsForClassTypes.assertThatThrownBy(() -> new Lotto(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_DUPLICATE_LOTTO_NUMBERS.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 12, 15, 24, 36})
    void 당첨번호와_보너스번호가_중복되는지_확인한다(int input) {
        LottoService lottoService = new LottoService();
        Lotto winningNumbers = new Lotto(List.of(1, 5, 12, 15, 24, 36));

        AssertionsForClassTypes.assertThatThrownBy(() ->
                        lottoService.checkBonusNumberValidity(input, winningNumbers.getNumbers()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_BONUS_NUMBER_MUST_BE_UNIQUE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -5, 46, 150, 124, 536})
    void 당첨번호와_로또번호_범위인지_확인한다(int input) {
        LottoService lottoService = new LottoService();
        Lotto winningNumbers = new Lotto(List.of(1, 5, 12, 15, 24, 36));

        AssertionsForClassTypes.assertThatThrownBy(() ->
                        lottoService.checkBonusNumberValidity(input, winningNumbers.getNumbers()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }

    @Test
    void 당첨번호_맞춘개수_확인한다() {
        List<Integer> winningList = List.of(1, 2, 3, 4, 5, 6);
        Lotto userNumber1 = new Lotto(List.of(1, 2, 3, 15, 24, 36));
        Lotto userNumber2 = new Lotto(List.of(1, 13, 15, 25, 34, 42));
        List<Lotto> userNumbers = new ArrayList<>();
        userNumbers.add(userNumber1);
        userNumbers.add(userNumber2);

        LottoResultDto resultDto = new LottoResultDto(2, userNumbers);
        resultDto.setWinningNumbers(winningList);
        LottoService lottoService = new LottoService();
        List<Map<Integer, Boolean>> list = lottoService.getLottoWinningResults(resultDto);

        int expectedCount1 = 3;
        int expectedCount2 = 1;

        assertEquals(expectedCount1, list.get(0).keySet().stream().findFirst().orElse(0));
        assertEquals(false, list.get(0).values().stream().findFirst().orElse(false));
        assertEquals(expectedCount2, list.get(1).keySet().stream().findFirst().orElse(0));
        assertEquals(false, list.get(1).values().stream().findFirst().orElse(false));
    }
}
