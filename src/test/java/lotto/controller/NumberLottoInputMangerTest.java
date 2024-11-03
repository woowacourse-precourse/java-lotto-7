package lotto.controller;

import lotto.constants.string.InputError;
import lotto.domain.ComponentNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NumberLottoInputMangerTest {

    private static MockInputView mockInputView;
    private static Lotto sampleWinningComponent;

    @BeforeAll
    static void setUp() {
        mockInputView = new MockInputView();
        sampleWinningComponent = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
                .map(ComponentNumber::new)
                .collect(Collectors.toList()));
    }

    /**
     * @param input 구입 가격에 대한 테스트
     */

    @ParameterizedTest
    @DisplayName("구입 가격에 빈칸을 입력하면 에러가 난다")
    @ValueSource(strings = {"", " ", "   "})
    void testNoneIntegerInputPrice(String input) {

        assertThatThrownBy(() -> {
            mockInputView.setInput(input);
            NumberLottoInputManger numberLottoInputManger = new NumberLottoInputManger(mockInputView);
            numberLottoInputManger.getInputPrice();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.BLANK_INPUT_PRICE.getInstance());
    }

    @ParameterizedTest
    @DisplayName("구입 가격이 숫자가 아니면 에러가 난다")
    @ValueSource(strings = {"ㄱ", "문자", "천원"})
    void testNoneNumericPrice(String input) {

        assertThatThrownBy(() -> {
            mockInputView.setInput(input);
            NumberLottoInputManger numberLottoInputManger = new NumberLottoInputManger(mockInputView);
            numberLottoInputManger.getInputPrice();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.NONE_INTEGER_INPUT_PRICE.getInstance());
    }

    @ParameterizedTest
    @DisplayName("구입 가격이 충분하지 않으면 에러가 난다")
    @ValueSource(ints = {900, 800, 700, 600, 500})
    void testNoneNumericPrice(int input) {

        assertThatThrownBy(() -> {
            mockInputView.setInput(input);
            NumberLottoInputManger numberLottoInputManger = new NumberLottoInputManger(mockInputView);
            numberLottoInputManger.getInputPrice();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.NOT_ENOUGH_INPUT_PRICE.getInstance());
    }

    @ParameterizedTest
    @DisplayName("구입 가격이 로또의 가격으로 나눠지지 않으면 에러가 난다")
    @ValueSource(ints = {1001, 1500, 1600, 2100})
    void testUndividablePrice(int input) {

        assertThatThrownBy(() -> {
            mockInputView.setInput(input);
            NumberLottoInputManger numberLottoInputManger = new NumberLottoInputManger(mockInputView);
            numberLottoInputManger.getInputPrice();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.NOT_DIVIDABLE_BY_LOTTO_PRICE.getInstance());
    }

    /**
     * @param input 당첨 번호에 대한 테스트
     */
    @ParameterizedTest
    @DisplayName("당첨 번호에 빈칸을 입력하면 에러가 난다")
    @ValueSource(strings = {"", " ", "   "})
    void testBlankWinningComponent(String input) {

        assertThatThrownBy(() -> {
            mockInputView.setInput(input);
            NumberLottoInputManger numberLottoInputManger = new NumberLottoInputManger(mockInputView);
            numberLottoInputManger.getInputWinningComponent();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.BLANK_WINNING_NUMBER.getInstance());
    }

    @ParameterizedTest
    @DisplayName("당첨 번호에 허용된 구분자 이외의 문자를 사용하면 에러가 난다")
    @ValueSource(strings = {"1.2.3.4.5.6", "1,2,3,4,5:6", "?!"})
    void testNotAllowedNoneIntegers(String input) {

        assertThatThrownBy(() -> {
            mockInputView.setInput(input);
            NumberLottoInputManger numberLottoInputManger = new NumberLottoInputManger(mockInputView);
            numberLottoInputManger.getInputWinningComponent();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.NOT_ALLOWED_NONE_INTEGER.getInstance());
    }

    @ParameterizedTest
    @DisplayName("당첨 번호가 구분자로 시작하거나 끝나면 에러가 난다")
    @ValueSource(strings = {"1,2,3,4,5,6,", ",1,2,3,4,5,6", ",1,2,3,4,5,6,"})
    void testStartsAndEndWithDelimeter(String input) {

        assertThatThrownBy(() -> {
            mockInputView.setInput(input);
            NumberLottoInputManger numberLottoInputManger = new NumberLottoInputManger(mockInputView);
            numberLottoInputManger.getInputWinningComponent();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.CANNOT_START_OR_END_WITH_DELIMETER.getInstance());
    }

    /**
     * @param input 보너스 넘버에 대한 테스트 입니다
     */
    @ParameterizedTest
    @DisplayName("보너스 번호에 빈칸을 입력하면 에러가 난다")
    @ValueSource(strings = {"", " ", "   "})
    void testBlankBonusComponent(String input) {

        assertThatThrownBy(() -> {
            mockInputView.setInput(input);
            NumberLottoInputManger numberLottoInputManger = new NumberLottoInputManger(mockInputView);
            numberLottoInputManger.getInputBonusComponent(sampleWinningComponent);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.BLANK_BONUS_NUMBER.getInstance());
    }

    @ParameterizedTest
    @DisplayName("보너스 번호에 Integer를 입력하지 않으면 에러가 난다")
    @ValueSource(strings = {"ㄱ", "숫자", "일"})
    void testIntegerBonusComponent(String input) {

        assertThatThrownBy(() -> {
            mockInputView.setInput(input);
            NumberLottoInputManger numberLottoInputManger = new NumberLottoInputManger(mockInputView);
            numberLottoInputManger.getInputBonusComponent(sampleWinningComponent);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.NONE_INTEGER_BONUS_NUMBER.getInstance());
    }
}
