package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HostTest {

    private Host host;

    @BeforeEach
    void setUp() {
        host = Host.getHost();
        host.setSelectedNumbers(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("선택된 번호가 올바르게 설정되는지 확인")
    @Test
    void selectedNumbersSetting() {
        assertThat(host.getSelectedNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("보너스 번호가 유효한 범위에서 설정되지 않으면 예외 발생")
    @ParameterizedTest
    @CsvSource({"0", "46"})
    void bonusNumberRangeValidation(int invalidNumber) {
        assertThatThrownBy(() -> host.setBonusNumber(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 선택된 번호와 중복되면 예외 발생")
    @Test
    void bonusNumberDuplicationValidation() {
        assertThatThrownBy(() -> host.setBonusNumber(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 올바르게 설정되는지 확인")
    @Test
    void bonusNumberSetting() {
        host.setBonusNumber(7);
        assertThat(host.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("일치하는 번호 개수가 올바르게 계산되는지 확인")
    @Test
    void matchingNumberCount() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        assertThat(host.countResult(lotto)).isEqualTo(3);
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되는지 확인")
    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "7 | 1,2,3,4,5,7 | true",
            "7 | 1,2,3,4,5,8 | false"
    })
    void bonusNumberCheck(int bonusNumber, String numbers, boolean expected) {
        host.setBonusNumber(bonusNumber);
        List<Integer> lottoNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(host.isBonus(lotto)).isEqualTo(expected);
    }
}