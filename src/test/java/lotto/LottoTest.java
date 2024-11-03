package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.PriceValidator;
import lotto.view.PriceInputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    // 구매 금액 검증 기능 ( PriceValidator ) 테스트
    @DisplayName("구입 금액에 숫자 외의 문자가 있으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"asd", ",123", "12 12432", "@$%#!", "123@$12,./"})
    void 구입_금액에_숫자_외의_문자가_있으면_예외가_발생한다(String input){
        System.out.println(input);
        assertThatThrownBy(() -> new PriceValidator(input).validate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1000000", "-2147483648", "-3482739"})
    void 음수를_입력하면_예외가_발생한다(String input){
        assertThatThrownBy(() -> new PriceValidator(input).validate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1231241242141", "999999999999999", "2147483648"})
    void 정수_범위를_벗어나면_예외가_발생한다(String input){
        assertThatThrownBy(() -> new PriceValidator(input).validate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("천 단위 숫자가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"10001", "25001", "2147483647", "0"})
    void 천_단위_숫자가_아니면_예외가_발생한다(String input){
        assertThatThrownBy(() -> new PriceValidator(input).validate())
                .isInstanceOf(IllegalArgumentException.class);
    }

//    private InputStream userInput(String input){
//        return new ByteArrayInputStream(input.getBytes());
//    }
}
