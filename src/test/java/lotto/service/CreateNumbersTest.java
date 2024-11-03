package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateNumbersTest {

    CreateNumbers createNumbers = new CreateNumbers();

    @DisplayName("입력 갯수만큼 로또 생성한다.")
    @Test
    void 입력_갯수만큼_로또_생성한다() {
        createNumbers.numbersList(3);
        int numbers = createNumbers.getNumbers().size();
        Assertions.assertThat(numbers).isEqualTo(3);
    }
}