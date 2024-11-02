package lotto;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomPickerTest {
    @Test
    void 정렬_테스트() {
        ArrayList<Integer> list = RandomPicker.pickLottoNumbers();
        assertThat(list).isSorted();
    }
}
