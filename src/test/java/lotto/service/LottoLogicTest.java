package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoLogicTest {

    @DisplayName("로또 추첨 결과 테스트")
    @Test
    void 로또_추첨_결과_테스트() {

        LottoLogic lottoLogic = new LottoLogic();
        List<List<Integer>> lottoNumbers = List.of(List.of(1, 2, 3, 4, 5, 6), List.of(10, 20, 30, 40, 11, 22));
        int bonus = 6;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);

        int[] result = lottoLogic.winning(lottoNumbers, bonus, numbers);

        Assertions.assertThat(result).isEqualTo(new int[]{0, 0, 0, 1, 0});
    }
}