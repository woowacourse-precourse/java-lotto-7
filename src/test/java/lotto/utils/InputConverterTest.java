package lotto.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

class InputConverterTest {

    private InputConverter inputConverter;

    @BeforeEach
    void setUp() {
        inputConverter = new InputConverter();
    }

    @ParameterizedTest
    @ValueSource(strings = {"8000", "10000", "5000"})
    @DisplayName("입력받은 금액 int로 형 변환")
    void convertBudget_shouldReturnIntegerValue(String input) {
        int result = inputConverter.convertBudget(input);
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @Test
    @DisplayName("입력받은 로또 번호 arrayList로 넣기")
    void convertLottoNumbers_shouldReturnListOfIntegers() {
        String input = "1, 2, 3, 4, 5, 6";
        ArrayList<Integer> result = inputConverter.convertWinningNumbers(input);
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("보너스 번호 arrayList 맨 뒤 추가")
    void addBonusNumber_shouldAddBonusToLottoNumbers() {
        String bonusInput = "7";
        ArrayList<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> result = inputConverter.addBonusNumber(bonusInput, lottoNumbers);
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6, 7);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3 ,4,5     , 6", "1,2,3,4,5,6", " 1 , 2 ,3, 4 ,5 ,6"})
    @DisplayName("숫자 분리 시 공백 삭제 처리")
    void convertLottoNumbers_withSpaces_shouldReturnTrimmedList(String input) {
        ArrayList<Integer> result = inputConverter.convertWinningNumbers(input);
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
