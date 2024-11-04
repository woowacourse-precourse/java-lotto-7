package lotto.model;

import lotto.common.constant.WinningInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningLottoTest {
    @DisplayName("로또 번호를 통해 5등 당첨인지 확인")
    @Test
    void 로또_번호를_통해_5등_당첨인지_확인(){
        //given
        List<Integer> lottoNumber = List.of(1,2,3,4,5,6);
        WinningLottoNumber winningLottoNumber = WinningLottoNumber.of("1,2,3,8,9,10");
        BonusNumber bonusNumber = BonusNumber.of("11",winningLottoNumber);
        WinningLotto winningLotto = WinningLotto.of(winningLottoNumber, bonusNumber);
        //when
        WinningInfo winningInfo = winningLotto.matchWithLotto(lottoNumber);
        //then
        assertEquals(winningInfo.getMatchCount(), 3);
        assertEquals(winningInfo.getPriceMoney(), 5000);
    }

    @DisplayName("로또 번호를 통해 4등 당첨인지 확인")
    @Test
    void 로또_번호를_통해_4등_당첨인지_확인(){
        //given
        List<Integer> lottoNumber = List.of(1,2,3,4,5,6);
        WinningLottoNumber winningLottoNumber = WinningLottoNumber.of("1,2,3,4,9,10");
        BonusNumber bonusNumber = BonusNumber.of("11",winningLottoNumber);
        WinningLotto winningLotto = WinningLotto.of(winningLottoNumber, bonusNumber);
        //when
        WinningInfo winningInfo = winningLotto.matchWithLotto(lottoNumber);
        //then
        assertEquals(winningInfo.getMatchCount(), 4);
        assertEquals(winningInfo.getPriceMoney(), 50000);
    }

    @DisplayName("로또 번호를 통해 3등 당첨인지 확인")
    @Test
    void 로또_번호를_통해_3등_당첨인지_확인(){
        //given
        List<Integer> lottoNumber = List.of(1,2,3,4,5,6);
        WinningLottoNumber winningLottoNumber = WinningLottoNumber.of("1,2,3,4,5,10");
        BonusNumber bonusNumber = BonusNumber.of("11",winningLottoNumber);
        WinningLotto winningLotto = WinningLotto.of(winningLottoNumber, bonusNumber);
        //when
        WinningInfo winningInfo = winningLotto.matchWithLotto(lottoNumber);
        //then
        assertEquals(winningInfo.getMatchCount(), 5);
        assertEquals(winningInfo.getPriceMoney(), 1500000);
    }

    @DisplayName("로또 번호를 통해 2등 당첨인지 확인")
    @Test
    void 로또_번호를_통해_2등_당첨인지_확인(){
        //given
        List<Integer> lottoNumber = List.of(1,2,3,4,5,6);
        WinningLottoNumber winningLottoNumber = WinningLottoNumber.of("1,2,3,4,5,10");
        BonusNumber bonusNumber = BonusNumber.of("6",winningLottoNumber);
        WinningLotto winningLotto = WinningLotto.of(winningLottoNumber, bonusNumber);
        //when
        WinningInfo winningInfo = winningLotto.matchWithLotto(lottoNumber);
        //then
        assertEquals(winningInfo.getMatchCount(), 5);
        assertEquals(winningInfo.getPriceMoney(), 30000000);
    }

    @DisplayName("로또 번호를 통해 1등 당첨인지 확인")
    @Test
    void 로또_번호를_통해_1등_당첨인지_확인(){
        //given
        List<Integer> lottoNumber = List.of(1,2,3,4,5,6);
        WinningLottoNumber winningLottoNumber = WinningLottoNumber.of("1,2,3,4,5,6");
        BonusNumber bonusNumber = BonusNumber.of("11",winningLottoNumber);
        WinningLotto winningLotto = WinningLotto.of(winningLottoNumber, bonusNumber);
        //when
        WinningInfo winningInfo = winningLotto.matchWithLotto(lottoNumber);
        //then
        assertEquals(winningInfo.getMatchCount(), 6);
        assertEquals(winningInfo.getPriceMoney(), 2000000000);
    }

}
