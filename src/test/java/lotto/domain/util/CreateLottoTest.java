package lotto.domain.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateLottoTest {

    @Test
    @DisplayName("로또 번호가 6개 생성되는지 확인한다.")
    void createLottoTest() {
        List<Integer> lotto = CreateLotto.lotto();

        Assertions.assertThat(lotto).hasSize(6);
    }
}