package lotto.domain.lottery;

import java.util.List;
import lotto.domain.vo.WinningNumberMatchCountVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteriesTest {

    @DisplayName("발행된 복권을 저장하는 Lotteries 인스턴스를 만든다.")
    @Test
    void newInstance() {
        //given
        Lottery lotto1 = new Lotto(List.of(1, 2, 3, 4, 5,6));
        Lottery lotto2 = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        Lottery lotto3 = new Lotto(List.of(12, 22, 32, 42, 25, 26));
        List<Lottery> lottoList = List.of(lotto1, lotto2, lotto3);
        //when
        Lotteries lotteries = Lotteries.newInstance(lottoList);
        //then
        Assertions.assertThat(lotteries).isInstanceOf(Lotteries.class);
    }


    @DisplayName("발행된 복권의 수만큼 Lotteries에 저장한다.")
    @Test
    void newInstance2() {
        //given
        Lottery lotto1 = new Lotto(List.of(1, 2, 3, 4, 5,6));
        Lottery lotto2 = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        Lottery lotto3 = new Lotto(List.of(12, 22, 32, 42, 25, 26));
        Lottery lotto4 = new Lotto(List.of(13, 23, 33, 43, 35, 36));
        Lottery lotto5 = new Lotto(List.of(14, 24, 34, 36, 44, 45));
        List<Lottery> lottoList = List.of(lotto1, lotto2, lotto3, lotto4, lotto5);
        //when
        Lotteries lotteries = Lotteries.newInstance(lottoList);
        //then
        Assertions.assertThat(lotteries.getLottery().size()).isEqualTo(5);

    }

    @DisplayName("")
    @Test
    void getLottery() {
        //given
        Lottery lotto1 = new Lotto(List.of(1, 2, 3, 4, 5,6));
        Lottery lotto2 = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        Lottery lotto3 = new Lotto(List.of(12, 22, 32, 42, 25, 26));
        Lottery lotto4 = new Lotto(List.of(13, 23, 33, 43, 35, 36));
        Lotteries lotteries = Lotteries.newInstance(List.of(lotto1, lotto2, lotto3, lotto4));

        //when
        List<Lottery> lottery = lotteries.getLottery();

        //then
        Assertions.assertThat(lottery.get(0).getNumbers()).contains(3);
    }

    @DisplayName("복권별 일치번호의 개수를 vo에 담아 List로 만든다.")
    @Test
    void winningNumberMatchCount() {
        //given

        Lottery lotto1 = new Lotto(List.of(1, 2, 3, 4, 5,6));
        Lottery lotto2 = new Lotto(List.of(11, 2, 33, 5, 6, 16));
        Lottery lotto3 = new Lotto(List.of(12, 2, 32, 5, 6, 26));
        Lottery lotto4 = new Lotto(List.of(13, 2, 33, 5, 35, 36));
        Lotteries lotteries = Lotteries.newInstance(List.of(lotto1, lotto2, lotto3, lotto4));
        //when
        List<WinningNumberMatchCountVO> winningNumberMatchCountVOS = lotteries.WinningNumberMatchCount(
                List.of(1, 2, 33, 4, 5, 6));

        //then
        for (WinningNumberMatchCountVO vo:winningNumberMatchCountVOS) {
            System.out.println("numbers : " + vo.lottery().getNumbers().toString()
                    + " count : " + vo.count());
        }

        Assertions.assertThat(winningNumberMatchCountVOS.get(0).count()).isEqualTo(5);
    }
}