package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.error.ExceptionMessage;
import lotto.service.InputService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputServiceTest {
    public InputService inputService;

    @BeforeEach
    public void setUp() {
        inputService = new InputService();
    }

    @DisplayName("문자열이 올바른 정수형식이면 True를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "0", "-1000"})
    void 문자열이_정수이면_True를_반환한다(String number) {
        assertThat(inputService.isNumber(number)).isTrue();
    }

    @DisplayName("문자열에 올바른 정수형식이 아니면 False를 반환한다. ")
    @ParameterizedTest
    @ValueSource(strings = {"1000원", "-0", "asdf", "01000", "-01000"})
    void 문자열이_정수가_아니면_False를_반환한다(String notNumber) {
        assertThat(inputService.isNumber(notNumber)).isFalse();
    }

    @DisplayName("수가 양수이면 True를 반환한다.")
    @Test
    void 수가_양수이면_True를_반환한다() {
        assertThat(inputService.isPositiveNumber(1000)).isTrue();
    }

    @DisplayName("수가 0이하이면 False를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1000})
    void 수가_양수이면_True를_반환한다(int notPositiveNumber) {
        assertThat(inputService.isPositiveNumber(notPositiveNumber)).isFalse();
    }

    @DisplayName("금액이 로또 가격에 나누어 떨어지면 True를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000})
    void 금액이_로또_가격에_나누어_떨어지면_True를_반환한다(int cost) {
        assertThat(inputService.isValidCost(cost)).isTrue();
    }

    @DisplayName("금액이 로또 가격에 나누어 떨어지지 않으면 False를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1001, 2100, 3110})
    void 금액이_로또_가격에_나누어_떨어지지_않으면_False를_반환한다(int cost) {
        assertThat(inputService.isValidCost(cost)).isFalse();
    }

    @DisplayName("로또 구입 금액 입력값이 유효한 가격을 나타낸 값이면 수를 추출한다.")
    @Test
    void 로또_구입_금액이_유효한_가격을_나타낸_값이면_정상적으로_수를_추출한다() {
        assertThat(inputService.validateLottoCost("3000")).isEqualTo(3000);
    }

    @DisplayName("로또 구입 금액 입력값에 수가 아닌 값이 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"$12", "asdf", "1003원"})
    void 로또_구입_금액에_수가_아닌_값이_있으면_예외가_발생한다(String lottoCost) {
        assertThatThrownBy(() -> inputService.validateLottoCost(lottoCost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_MESSAGE_IS_NOT_NUMBER.toString().toString());
        ;
    }

    @DisplayName("로또 구입 금액 입력값이 0이하 이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000"})
    void 로또_구입_금액이_0이하_이면_예외가_발생한다(String lottoCost) {
        assertThatThrownBy(() -> inputService.validateLottoCost(lottoCost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_MESSAGE_IS_NOT_POSITIVE_NUMBER.toString());
        ;
    }

    @DisplayName("로또 구입 금액 입력값이 로또 가격에 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1003", "2030", "3300"})
    void 로또_구입_금액이_가격에_나누어_떨어지지_않으면_예외가_발생한다(String lottoCost) {
        assertThatThrownBy(() -> inputService.validateLottoCost(lottoCost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_MESSAGE_IS_NOT_VALID_COST.toString());
        ;
    }

    @DisplayName("로또 구입 금액으로 로또 수량 계산하기")
    @Test
    void 로또_구입_금액으로_로또_수량_계산하기() {
        assertThat(inputService.calculateLottoCount(3000)).isEqualTo(3);
    }

    @DisplayName("번호가 로또 번호 범위 안의 문자이면 True를 반환한다.")
    @Test
    void 번호가_로또_번호_범위_안의_문자이면_True를_반환한다() {
        assertThat(inputService.isLottoRange(30)).isTrue();
    }

    @DisplayName("번호가 로또 번호 범위 안의 문가 아니면 False를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    void 번호가_로또_번호_범위_안의_문자가_아니면_False를_반환한다(int number) {
        assertThat(inputService.isLottoRange(number)).isFalse();
    }

    @DisplayName("당첨 번호 요소가 유효하면 숫자로 반환된다. ")
    @ParameterizedTest
    @ValueSource(strings = {"4", "30", "43"})
    void 당첨_번호_요소가_유효하면_숫자로_반환된다(String element) {
        List<Integer> testWinningNumbers = new ArrayList<>(Arrays.asList(1, 10, 20));
        int expected = Integer.parseInt(element);
        assertThat(inputService.validateWinningNumber(element)).isEqualTo(expected);
    }

    @DisplayName("당첨 번호 요소가 수가 아니면 예외가 발생한다. ")
    @ParameterizedTest
    @ValueSource(strings = {"~", "1번", ""})
    void 당첨_번호_요소가_수가_아니면_예외가_발생한다(String element) {
        List<Integer> testWinningNumbers = new ArrayList<>(Arrays.asList(1, 10, 20));
        assertThatThrownBy(() -> inputService.validateWinningNumber(element))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_MESSAGE_IS_NOT_NUMBER.toString());
    }

    @DisplayName("당첨 번호 요소가 로또 번호 범위의 수가 아니면 예외가 발생한다. ")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "46"})
    void 당첨_번호_요소가_로또_번호_범위의_수가_아니면_예외가_발생한다(String element) {
        assertThatThrownBy(() -> inputService.validateWinningNumber(element))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_MESSAGE_IS_NOT_IN_LOTTO_NUMBER_RANGE.toString());
    }


    @DisplayName("유효한 당첨 번호 문자열이 들어온 경우 정상적으로 당첨 번호들을 추출한다.")
    @Test
    void 유효한_당첨번호_문자열이_들어온_경우_정상적으로_번호_추출한다() {
        String testValue = "1,3,5,10,34,40";
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 3, 5, 10, 34, 40));
        assertThat(inputService.extractWinningNumbers(testValue))
                .isEqualTo(expected);
    }

    @DisplayName("유효한 보너스 번호 문자가 들어온 경우 정상적으로 보너스 번호를 반환한다.")
    @Test
    void 유효한_보너스_번호_문자가_들어온_경우_정상적으로_번호를_반환한다() {
        List<Integer> testWinningNumbers = new ArrayList<>(Arrays.asList(1, 10, 20, 34, 40, 45));
        String testValue = "25";
        int expected = Integer.parseInt(testValue);

        assertThat(inputService.validateBonusNumber(testWinningNumbers, testValue))
                .isEqualTo(expected);
    }

}
