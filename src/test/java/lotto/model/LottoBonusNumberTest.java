package lotto.model;

import static lotto.util.message.OutputMessage.ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBonusNumberTest {

    @Test
    @DisplayName("입력한 6개의 당첨 번호 중 보너스 번호와 중복된 번호가 존재하면 예외 발생")
    void throwExceptionIfDuplicatedBonusNumberContained() {
        Lotto winningLottoNumber = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 6;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoBonusNumber(winningLottoNumber, bonusNumber))
                .withMessageStartingWith(ERROR_MESSAGE);
    }
}