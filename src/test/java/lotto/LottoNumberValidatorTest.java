package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoNumberValidatorTest {

    @Test
    void 중복된_숫자가_있으면_IllegalArgumentException_예외가_발생한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        assertThrows(IllegalArgumentException.class,
                () -> LottoNumberValidator.validateDuplicateNumber(numbers));

    }
}
