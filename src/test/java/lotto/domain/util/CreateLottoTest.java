package lotto.domain.util;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateLottoTest {

    @Test
    @DisplayName("로또 번호가 6개 생성되는지 확인한다.")
    void createCreateTest() {
        List<Integer> lotto = CreateLotto.create();

        Assertions.assertThat(lotto).hasSize(6);
    }
}