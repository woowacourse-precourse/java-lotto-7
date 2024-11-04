package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumberPickerTest {

    @DisplayName("로또 번호 생성 시 번호 개수가 6개인지 확인한다.")
    @Test
    void 로또_번호_개수_확인() {
        LottoNumberPicker lottoNumberPicker = new LottoNumberPicker();
        List<Integer> numbers = lottoNumberPicker.generate();
        assertThat(numbers).hasSize(6);
    }

    @DisplayName("로또 번호 생성 시 번호가 1부터 45 사이인지 확인한다.")
    @Test
    void 로또_번호_범위_확인() {
        LottoNumberPicker lottoNumberPicker = new LottoNumberPicker();
        List<Integer> numbers = lottoNumberPicker.generate();
        assertThat(numbers).allMatch(number -> number >= 1 && number <= 45);
    }

    @DisplayName("로또 번호 생성 시 중복된 번호가 없는지 확인한다.")
    @Test
    void 로또_번호_중복_확인() {
        LottoNumberPicker lottoNumberPicker = new LottoNumberPicker();
        List<Integer> numbers = lottoNumberPicker.generate();
        long uniqueCount = numbers.stream().distinct().count();
        assertThat(uniqueCount).isEqualTo(6);
    }
}
