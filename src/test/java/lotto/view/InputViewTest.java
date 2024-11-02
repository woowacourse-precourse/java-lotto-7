package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    InputView inputView = new InputView();

    @Test
    @DisplayName("함수 기본 테스트")
    void inputPriceTest() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1000\n".getBytes());
        System.setIn(inputStream);

        int result = inputView.inputPrice();
        assertThat(result).isEqualTo(1000);

        System.setIn(System.in);
    }

    @Test
    @DisplayName("함수 극값 테스트")
    void inputPriceMaxTest() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("2147483000\n".getBytes());
        System.setIn(inputStream);

        int result = inputView.inputPrice();
        assertThat(result).isEqualTo(2147483000);

        System.setIn(System.in);
    }

    @Test
    @DisplayName("함수 예외 테스트")
    void inputPriceExceptionTest() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("0\n".getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.inputPrice())
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(System.in);
    }

    @Test
    @DisplayName("함수 예외 테스트 - 오버플로우")
    void inputPriceOverflowTest() {

        ByteArrayInputStream inputStream = new ByteArrayInputStream("220000000000\n".getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.inputPrice())
                .isInstanceOf(NumberFormatException.class);

        System.setIn(System.in);
    }

    @Test
    @DisplayName("함수 기본 테스트")
    void inputLottoNumbersTest() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1, 2, 3, 4, 5, 6\n".getBytes());
        System.setIn(inputStream);

        List<Integer> result = inputView.inputLottoNumbers();
        assertThat(result).isEqualTo(List.of(1, 2, 3, 4));

        System.setIn(System.in);
    }

    @Test
    @DisplayName("함수 기본 테스트")
    void inputBonusNumberTest() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("45\n".getBytes());
        System.setIn(inputStream);

        int result = inputView.inputBonusNumber();
        assertThat(result).isEqualTo(45);

        System.setIn(System.in);
    }
}
