package lotto.sevice;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    LottoService lottoService = new LottoService();
    @Test
    void countLottoTest() {
        //given
        String str = "10000";
        //when
        int res = lottoService.countLotto(str);
        assertThat(res).isEqualTo(Integer.parseInt(str)/1000);
    }

    @Test
    void getWinLottoListTest() {
        //given
        String str = "1,2,3,4,5,6";
        //when
        List<Integer> ls = lottoService.getWinLottoList(str);
        //then
        assertThat(ls.size()).isEqualTo(6);
    }

    @Test
    void countWinLottoTest() {
        //given
        List<List<Integer>> ls1 = List.of(
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,7),
                List.of(1,2,3,41,42,44),
                List.of(1,2,31,41,42,44),
                List.of(1,20,31,41,42,44)
                );
        List<Integer> win = List.of(1,2,3,4,5,6);
        int bonus = 7;
        //when
        List<Integer> res = lottoService.countWinLotto(ls1,win,bonus);
        //then
        assertThat(res.contains(10)).isTrue();
        assertThat(res.contains(6)).isTrue();
        assertThat(res.contains(3)).isTrue();
        assertThat(res.contains(2)).isTrue();
        assertThat(res.contains(1)).isTrue();

    }


}