package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    LottoController lottoController = new LottoController();

    @AfterEach
    void afterEach() {
        Console.close();
    }

    @Test
    @DisplayName("당첨번호의 개수는 6개이다.")
    void getWinningNumbersTest() throws NoSuchMethodException {
        Method getWinningNumbers = LottoController.class.getDeclaredMethod("getWinningNumbers");
        getWinningNumbers.setAccessible(true);

        // given
        String input = "1,2,3,4,5,6,7";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // when & then
        assertThatThrownBy(() -> {
            try {
                getWinningNumbers.invoke(lottoController);
            } catch (InvocationTargetException e) {
                throw e.getCause(); // 실제 예외로 변환
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 구입 금액은 1000원 단위이다.")
    void getLottoPurchaseAmountTest() throws NoSuchMethodException {
        Method getLottoPurchaseAmount = LottoController.class.getDeclaredMethod("getLottoPurchaseAmount");
        getLottoPurchaseAmount.setAccessible(true);

        // given
        String input = "7300";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // when & then
        assertThatThrownBy(() -> {
            try {
                getLottoPurchaseAmount.invoke(lottoController);
            } catch (InvocationTargetException e) {
                throw e.getCause(); // 실제 예외로 변환
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 금액이 1,000원으로 나누어 떨어지지 않습니다.");
    }

    @Test
    @DisplayName("로또 번호는 1에서 45 사이의 정수이다.")
    void validateLottoNumberTest() throws NoSuchMethodException {
        Method validateLottoNumber = LottoController.class.getDeclaredMethod("validateLottoNumber", int.class);
        validateLottoNumber.setAccessible(true);

        // given
        int input = 60;

        // when & then
        assertThatThrownBy(() -> {
            try {
                validateLottoNumber.invoke(lottoController, input);
            } catch (InvocationTargetException e) {
                throw e.getCause(); // 실제 예외로 변환
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 값이 1과 45 사이의 값이 아닙니다.");
    }

    @Test
    @DisplayName("로또 번호는 정수이다.")
    void parseIntTest() throws NoSuchMethodException {
        Method getWinningNumbers = LottoController.class.getDeclaredMethod("parseInt", String.class);
        getWinningNumbers.setAccessible(true);

        // given
        String input = "One";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // when & then
        assertThatThrownBy(() -> {
            try {
                getWinningNumbers.invoke(lottoController, input);
            } catch (InvocationTargetException e) {
                throw e.getCause(); // 실제 예외로 변환
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력된 값이 정수가 아닙니다.");
    }

}