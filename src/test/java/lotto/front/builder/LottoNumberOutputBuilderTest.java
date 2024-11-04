package lotto.front.builder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberOutputBuilderTest {

    @Test
    @DisplayName("구매한 로또번호를 출력할 문자열을 만들어 반환")
    void 로또_구매_문자열_테스트() {
        //given
        List<List<Integer>> lottoNumbers = List.of(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12),
                List.of(13, 14, 15, 16, 17, 18), List.of(19, 20, 21, 22, 23, 24));
        //when
        String output = LottoNumberOutputBuilder.build(lottoNumbers);
        //then
        assertThat(output).contains("4개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]",
                "[7, 8, 9, 10, 11, 12]",
                "[13, 14, 15, 16, 17, 18]",
                "[19, 20, 21, 22, 23, 24]");
    }
}