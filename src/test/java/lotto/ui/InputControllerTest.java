package lotto.ui;

import java.util.stream.Stream;
import lotto.exception.LottoArgumentException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputControllerTest {

    private StringBuilder input = new StringBuilder();
    private final InputUi inputUi = () -> input.toString();

    @Test
    void 돈_읽기_테스트() {
        input.append("10000");
        final InputController inputController = new InputController(inputUi);

        Assertions.assertThat(inputController.getPayment().getLottoCount())
                .isEqualTo(10);
    }

    @DisplayName("로또 잘못된 입력 테스트")
    @ParameterizedTest
    @MethodSource("잘못된_당첨번호_입력")
    void 로또_잘못된_당첨번호_입력_테스트(final String inputLottoNumbers) {
        input.append(inputLottoNumbers);
        final InputController inputController = new InputController(inputUi);

        Assertions.assertThatThrownBy(() -> inputController.getLotto())
                .isInstanceOf(LottoArgumentException.class);
    }

    static Stream<Arguments> 잘못된_당첨번호_입력() {
        return Stream.of(
                Arguments.of("1,2,3,,4,5"),
                Arguments.of(" "),
                Arguments.of("123124"),
                Arguments.of("test"),
                Arguments.of("")
        );
    }

    @DisplayName("입금 금액이 숫자가 아닐때 예외를 던진다")
    @ParameterizedTest
    @MethodSource("숫자가_아닌_입력_데이터")
    void 숫자가_아닐때_예외를_던진다(final String userInput) {
        input.append(userInput);
        final InputController inputController = new InputController(inputUi);

        Assertions.assertThatThrownBy(() -> inputController.getPayment())
                .isInstanceOf(LottoArgumentException.class);
    }

    static Stream<Arguments> 숫자가_아닌_입력_데이터() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("asd234"),
                Arguments.of("2311s"),
                Arguments.of("    ")
        );
    }

    @BeforeEach
    void initInput() {
        this.input = new StringBuilder();
    }
}