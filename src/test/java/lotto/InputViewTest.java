package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아닌 경우 예외 발생")
    @Test
    void isPurchasePriceByThousand() {
        assertThatThrownBy(() -> inputView.validatePurchasePriceByThousand(8090))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 숫자가 아닌 경우 예외 발생")
    @Test
    void isPurchasePriceNumber() {
        assertThatThrownBy(() -> inputView.validateIsNumeric("5000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 마지막에 쉼표를 입력한 경우 예외 발생")
    @Test
    void isLastCharacterComma() {
        assertThatThrownBy(() -> inputView.validateLastCharComma("4,15,30,35,41,43,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 쉼표가 아닌 다른 구분자를 입력한 경우 예외 발생")
    @Test
    void isNonCommaDelimiter() {
        assertThatThrownBy(() -> inputView.validateNonCommaDelimiter("4-15-30-35-41-43"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자를 입력하지 않은 경우 예외 발생")
    @Test
    void isBonusNumberOutOfRange() {
        assertThatThrownBy(() -> inputView.validateLottoRange(47))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 당첨 번호와 중복해서 입력한 경우 예외 발생")
    @Test
    void isBonusNumberDuplicate() {
        assertThatThrownBy(() -> inputView.validateBonusNumberDuplicate(Arrays.asList(1,2,3,4,5,6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
