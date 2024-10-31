package lotto.util;

import lotto.constant.ErrorMessage;
import lotto.lotto.winning.domain.BonusNumber;
import lotto.lotto.winning.domain.WinningLotto;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationProcess {
    public static <R> void createThrownBy(List<String> exceptionData, Function<String, R> transFormer, ErrorMessage errorMessage) {
        exceptionData.forEach((data) -> {
                    assertThatThrownBy(() -> transFormer.apply(data))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(errorMessage.getMessage());
                }
        );
    }

    public static void createThrownBy(
            WinningLotto winningLotto,
            List<String> exceptionData,
            Function<String, BonusNumber> transFormer,
            BiConsumer<BonusNumber, WinningLotto> biConsumer,
            ErrorMessage errorMessage) {
        exceptionData.forEach((data) -> {
                    BonusNumber bonusNumber = transFormer.apply(data);
                    assertThatThrownBy(() -> biConsumer.accept(bonusNumber, winningLotto))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(errorMessage.getMessage());
                }
        );
    }
    public static void inputThrownBy(List<String> exceptionData, Consumer<String> validate, ErrorMessage errorMessage) {
        exceptionData.forEach((data) -> {
            assertThatThrownBy(() -> validate.accept(data))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(errorMessage.getMessage());
        });
    }
}
