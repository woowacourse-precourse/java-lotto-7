package lotto;

import lotto.validator.PriceValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class PriceValidatorTest {
    @DisplayName("가격이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void priceUnit() {
        //given
        int case1 = 3300;
        int case2 = 3000;

        //when
        final Throwable thrown1 = catchThrowable(() -> {
            PriceValidator.validatePrice(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            PriceValidator.validatePrice(case2);
        });

        //then
        assertThat(thrown1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("단위");
        assertThat(thrown2)
                .doesNotThrowAnyException();
    }

    @DisplayName("가격이 1,000~100,000의 범위가 아니면 예외가 발생한다.")
    @Test
    void priceScope() {
        //given
        int case1 = 101000;
        int case2 = 0;
        int case3 = 3000;

        //when
        final Throwable thrown1 = catchThrowable(() -> {
            PriceValidator.validatePrice(case1);
        });
        final Throwable thrown2 = catchThrowable(() -> {
            PriceValidator.validatePrice(case2);
        });
        final Throwable thrown3 = catchThrowable(() -> {
            PriceValidator.validatePrice(case3);
        });

        //then
        assertThat(thrown1)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("원 이상");
        assertThat(thrown2)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("원 이하");
        assertThat(thrown3)
                .doesNotThrowAnyException();
    }
}
