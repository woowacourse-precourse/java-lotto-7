package util;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import valid.Validate;

public class LottoGeneratorTest {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @DisplayName("1~45 사이의 중복되지 않는 6자리 번호를 갖는 로또를 생성한다.")
    @Test
    void generateLotto() {
        // when
        Lotto lotto = lottoGenerator.generateLotto();

        // then
        assertAll(
                () -> assertDoesNotThrow(() -> Validate.isDuplicated(lotto.getNumbers())),
                () -> assertDoesNotThrow(() -> Validate.isSixNumbers(lotto.getNumbers())),
                () -> assertDoesNotThrow(() -> lotto.getNumbers().stream()
                        .forEach(number -> Validate.isOneBetweenFortyFive(number)))
        );
    }
}
