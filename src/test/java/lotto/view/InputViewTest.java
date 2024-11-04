package lotto.view;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    @AfterEach
    void closeConsole(){
        Console.close();
    }

    @DisplayName("정상 입력을 받으면 해당 줄을 읽어옴, 로또 구입 금액")
    @ParameterizedTest
    @ValueSource(strings = {"12000", "510000", "3000", "601000"})
    void 정상_입력_로또_구입_금액(String input){
        // Given
        systemIn(input);
        // When
        String result = InputView.readAmount();
        // then
        assertThat(result).isEqualTo(input);
    }

    @DisplayName("정상 입력을 받으면 해당 줄을 읽어옴, 당첨 번호")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "21 ,12 , 31 , 44, 52 ,14", "1, 3, 5, 6, 7, 32"})
    void 정상_입력_당첨_번호(String input){
        // Given
        systemIn(input);
        // When
        String result = InputView.readWinningNumber();
        // then
        assertThat(result).isEqualTo(input);
    }

    @DisplayName("정상 입력을 받으면 해당 줄을 읽어옴, 보너스 번호")
    @ParameterizedTest
    @ValueSource(strings = {"1", "21", "34"})
    void 정상_입력_보너스_번호(String input){
        // Given
        systemIn(input);
        // When
        String result = InputView.readBonusNumber();
        // then
        assertThat(result).isEqualTo(input);
    }

    private void systemIn(final String input){
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
