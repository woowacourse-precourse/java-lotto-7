package lotto.view;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    InputView inputView = new InputView();

    @Test
    @DisplayName("구입금액_입력_테스트")
    void getPriceTest() {
        // given
        String input = "1000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        int amount = inputView.getAmount();

        // then
        assertThat(amount).isEqualTo(Integer.parseInt(input));
    }

    @Test
    @DisplayName("당첨번호_입력_테스트")
    void getWinningNumberTest() {
        // given
        String input = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        List<Integer> winningNumber = inputView.getWinningNumber();

        // then
        assertThat(winningNumber).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @Test
    @DisplayName("보너스번호_입력_테스트")
    void getBonusNumberTest() {
        // given
        String input = "10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        int bonusNumber = inputView.getBonusNumber(new ArrayList<>());

        // then
        assertThat(bonusNumber).isEqualTo(Integer.parseInt(input));
    }

}