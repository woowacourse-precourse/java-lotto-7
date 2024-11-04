package lotto.model;

import java.io.ByteArrayInputStream;
import lotto.exception.ErrorCode;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        OutputView outputView = new OutputView();
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers();
        lottoGame = new LottoGame(outputView, winningLottoNumbers);
    }

    @DisplayName("구입 금액 입력 성공 테스트")
    @Test
    void testValidPriceInput() {
        // given
        String validInput = "2000";
        String input = "2000\n"; // 올바른 입력값
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = lottoGame.getValidatedPrice();

        // then
        assertThat(result).isEqualTo(2000);
    }

}
