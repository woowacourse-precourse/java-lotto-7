package lotto.validator;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoValidatorTest {

    private LottoValidator lottoValidator;

    @BeforeEach
    void beforeEach() {
        this.lottoValidator = new LottoValidator();
    }

    @Test
    @DisplayName("로또 번호가 범위를 넘어가는 경우")
    void 로또_번호가_범위를_넘어가는_경우() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> lottoValidator.validateLotto(List.of(1, 2, 3, 4, 5, 46)));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> lottoValidator.validateLotto(List.of(0, 2, 3, 4, 5, 46)));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> lottoValidator.validateLotto(List.of(-1, 2, 3, 4, 5, 46)));
    }

    @Test
    @DisplayName("로또 번호에 중복이 존재하는 경우")
    void 로또_번호에_중복이_존재하는_경우() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> lottoValidator.validateLotto(List.of(1, 2, 2, 4, 5, 45)));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> lottoValidator.validateLotto(List.of(1, 2, 2, 2, 5, 45)));
    }

    @Test
    @DisplayName("로또 번호 입력 개수가 6개가 아닌경우")
    void 로또_번호_입력_개수가_6개가_아닌경우() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> lottoValidator.validateLotto(List.of(1, 2, 4, 5, 45)));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> lottoValidator.validateLotto(List.of(1, 2, 3, 4, 5, 45, 41)));
    }
}
