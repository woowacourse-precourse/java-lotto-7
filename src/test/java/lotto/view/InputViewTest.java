package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.Console;

class InputViewTest {
    private static final String NORMAL_LOTTO_INPUT = "1,2,3,4,5,6";
    private static final String ZERO_LOTTO_INPUT = "1,2,3,4,5,0";
    private static final List<Integer> NORMAL_LOTTO_NUMBERS = List.of(1, 2, 3, 4, 5, 6);

    private static final String NORMAL_BONUS_INPUT = "6";
    private static final String ZERO_BONUS_INPUT = "0";
    private static final int NORMAL_BONUS_NUMBER = 6;

    @BeforeEach
    void setUp() {
        Console.close(); // 이전 Scanner 인스턴스 닫기
    }

    @DisplayName("정상적인 로또 번호 입력 테스트")
    @Test
    void testLottoNumberInput() {
        // given
        System.setIn(new ByteArrayInputStream((NORMAL_LOTTO_INPUT).getBytes()));
        // when
        List<Integer> result = InputView.getLottoNumber();
        // then
        assertThat(result).isEqualTo(NORMAL_LOTTO_NUMBERS);
    }

    @DisplayName("0 포함 로또 번호 입력 테스트")
    @Test
    void testLottoNumberInputWithZero() {
        // given
        // Scanner의 nextLine()은 줄바꿈까지 전까지 읽고 다시 읽을 때 그 이후 부터 읽음
        String combinedInput = ZERO_LOTTO_INPUT + "\n" + NORMAL_LOTTO_INPUT;
        System.setIn(new ByteArrayInputStream(combinedInput.getBytes()));
        // when
        List<Integer> result = InputView.getLottoNumber();
        // then
        assertThat(result).isEqualTo(NORMAL_LOTTO_NUMBERS);
    }

    @DisplayName("정상적인 보너스 번호 입력 테스트")
    @Test
    void testBonusNumberInput() {
        // given
        System.setIn(new ByteArrayInputStream((NORMAL_BONUS_INPUT).getBytes()));
        // when
        int result = InputView.getBonusNumber();
        // then
        assertThat(result).isEqualTo(NORMAL_BONUS_NUMBER);
    }

    @DisplayName("0 포함 보너스 번호 입력 테스트")
    @Test
    void testBonusNumberInputWithZero() {
        // given
        String combinedInput = ZERO_BONUS_INPUT + "\n" + NORMAL_BONUS_INPUT;
        System.setIn(new ByteArrayInputStream(combinedInput.getBytes()));
        // when
        int result = InputView.getBonusNumber();
        // then
        assertThat(result).isEqualTo(NORMAL_BONUS_NUMBER);
    }
}