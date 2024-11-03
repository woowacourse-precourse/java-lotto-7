package lotto.domain.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.config.Factory;
import lotto.domain.model.user.Lotto;
import lotto.domain.utils.TestLotto;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    Factory factory = new Factory();
    InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = factory.inputView();
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Nested
    @DisplayName("사용자가 가격을 입력하면")
    class AmountTest {
        @ParameterizedTest
        @ValueSource(strings = {"1000", "2000"})
        @DisplayName("숫자일 시 해당 금액을 반환해야 한다.")
        void getUserWinningNumber(String input) {
            //given
            setUserInput(input);

            //when
            int amount = inputView.getUserPurchaseAmount();

            //then
            assertEquals(Integer.parseInt(input), amount);
        }
    }


    @Nested
    @DisplayName("사용자가 당첨 로또를 입력하면")
    class WinningNumberTest {
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,6"})
        @DisplayName("정상적으로 파싱하여야 한다.")
        void getUserPurchaseAmount(String input) {
            //given
            setUserInput(input);

            //when
            Lotto winningNumber = inputView.getWinningNumber();
            List<Integer> numbers = winningNumber.getNumbers();

            //then
            assertThat(numbers)
                    .containsOnly(1, 2, 3, 4, 5, 6);
        }
    }

    @Nested
    @DisplayName("사용자가 보너스 번호를 입력하면")
    class BonusNumberTest {
        @ParameterizedTest
        @ValueSource(strings = {"1", "2", "3"})
        @DisplayName("정상적으로 변환하여야 한다.")
        void getUserPurchaseAmount(String input) {
            //given
            setUserInput(input);
            Lotto testLotto = TestLotto.createTestLotto(List.of(10, 11, 12, 13, 14, 15));
            //when
            int bonusNumber = inputView.getBonusNumber(testLotto);

            //then
            assertThat(bonusNumber).isEqualTo(Integer.parseInt(input));
        }
    }

    private static void setUserInput(String userInput) {
        ByteArrayInputStream in = new ByteArrayInputStream((userInput + "\n").getBytes());
        System.setIn(in);
    }
}