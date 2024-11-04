package lotto.model;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoTest {
    @Test
    void 로또번호가_6개가_아닐_시_에러_발생() {
        //Given & When & Then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호가_1부터_45_사이의_숫자가_아닐_시_에러_발생(){
        //Given & When & Then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 100)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1, 51, 50, 30, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호_중_중복된_숫자가_있을_시_에러_발생(){
        //Given & When & Then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1, 33, 33, 30, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호_요구사항을_다_지킨_경우_에러_발생_안_함() {
        //Given
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(11, 12, 13, 14, 15, 16);

        //When & Then
        assertDoesNotThrow(() -> new Lotto(numbers2));
    }
}
