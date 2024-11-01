package lotto.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberValidatorTest {
    private BonusNumberValidator bonusNumberValidator;


    @BeforeEach
    void setUp() {
        this.bonusNumberValidator = new BonusNumberValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "    ", ""})
    void 보너스_번호가_빈칸일때_에러_반환(String bonusNumbers) {
        assertThatThrownBy(() -> {
            bonusNumberValidator.validate(new ArrayList<>(), bonusNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 빈칸일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1a", "15ㄴ", " 1bb1123", "23423?ib2"})
    void 보너스_번호가_정수가_아닐때_에러_반환(String bonusNumbers) {
        assertThatThrownBy(() -> {
            bonusNumberValidator.validate(new ArrayList<>(), bonusNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 정수여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"6", "5", "4", "3", "2", "1"})
    void 당첨번호와_보너스번호가_겹칠때_에러_반환(String bonusNumber) {
        assertThatThrownBy(() -> {
            bonusNumberValidator.validate(List.of(1, 2, 3, 4, 5, 6), bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 같을 수 없습니다.");
    }
}