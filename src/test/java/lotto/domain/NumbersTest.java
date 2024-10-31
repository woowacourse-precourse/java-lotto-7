package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @DisplayName("로또 번호 생성 후 값 출력이 정상적이다.")
    @Test
    void 로또_번호_생성_후_값_출력() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);

        String strings = "1, 2, 3, 4, 5, 6";

        String stringsOtherFormat = "1,2, 3  , 4, 5 , 6    ";


        Numbers numbersInteger = new Numbers(integers);
        Numbers numbersString = new Numbers(strings);
        Numbers numbersStrOtherFormat = new Numbers(stringsOtherFormat);

        Assertions.assertThat(numbersInteger.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        Assertions.assertThat(numbersString.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        Assertions.assertThat(numbersStrOtherFormat.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("중복되는 숫자가 입력되면 예외가 발생한다.")
    @Test
    void 중복되는_숫자가_입력되면_예외가_발생한다() {

        String numbers = "2, 2, 3, 4, 5, 6";

        assertThatThrownBy(() -> new Numbers(numbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호는 중복이 없어야 합니다.");
    }

    @DisplayName("로또 숫자가 6개가 아니면 예외가 발생한다.")
    @Test
    void 로또_숫자가_6개가_아니면_예외가_발생한다() {

        String moreThan = "1, 2, 3, 4, 5, 6, 7";

        assertThatThrownBy(() -> new Numbers(moreThan))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");

        String lessThan = "1, 2, 3";

        assertThatThrownBy(() -> new Numbers(lessThan))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

}