package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoTest {

    @Test
    public void 로또_번호_정상_생성() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @Test
    public void 로또_번호_6개가_아닌경우_예외처리() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] 로또 번호는 6개여야 합니다.");
    }
}
