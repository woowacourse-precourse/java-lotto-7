package lotto.shop.bandingmachine;

import java.util.List;
import lotto.MessageCenter;
import lotto.user.UserStorage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrinterTest {

    Printer printer = new Printer();

    @Test
    @DisplayName("유저 구매 기록이 비어있거나 NULL이면 예외가 발생한다")
    void 유저_구매_기록이_비어있거나_NULL이면_예외가_발생한다() {
        assertThatThrownBy(() -> printer.getPrintedPaper())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_USERSTORAGE.get());
    }


}
