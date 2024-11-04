package lotto.winning;

import lotto.AppConfig;
import lotto.donghang.WinningLotto;
import lotto.vendingmachine.Lotto;
import lotto.vendingmachine.VendingMachineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WinningServiceImplTest {

    VendingMachineRepository vendingMachineRepository;
    WinningService winningService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        winningService = appConfig.winningService();
        vendingMachineRepository = appConfig.vendingMachineRepository();
    }

    @Test
    @DisplayName("당첨 확인 테스트 - 5등 잘 되는지")
    void 당첨_확인_테스트1() {
        List<Lotto> lottos = new ArrayList<>(List.of(new Lotto(List.of(1,2,3,4,5,6)), new Lotto(List.of(1,2,3,4,5,7))));
        vendingMachineRepository.save(lottos);

        Map<Rank, Integer> result = winningService.checkLotto(new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 7));

        assertEquals(Integer.valueOf(1), result.get(Rank.FIRST));
        assertEquals(Integer.valueOf(1), result.get(Rank.SECOND));
        assertEquals(Integer.valueOf(0), result.get(Rank.THIRD));
        assertEquals(Integer.valueOf(0), result.get(Rank.FOURTH));
        assertEquals(Integer.valueOf(0), result.get(Rank.FIFTH));
    }

    @Test
    @DisplayName("당첨 확인 테스트 - 미당첨 결과 잘 나오는지")
    void 당첨_확인_테스트2() {
        List<Lotto> lottos = new ArrayList<>(List.of(new Lotto(List.of(1,2,3,4,5,6)), new Lotto(List.of(4,5,6,7,8,9))));
        vendingMachineRepository.save(lottos);

        Map<Rank, Integer> result = winningService.checkLotto(new WinningLotto(new Lotto(List.of(1,2,3,43,44,45)), 27));

        assertEquals(Integer.valueOf(0), result.get(Rank.FIRST));
        assertEquals(Integer.valueOf(0), result.get(Rank.SECOND));
        assertEquals(Integer.valueOf(0), result.get(Rank.THIRD));
        assertEquals(Integer.valueOf(0), result.get(Rank.FOURTH));
        assertEquals(Integer.valueOf(1), result.get(Rank.FIFTH));
    }

    @Test
    @DisplayName("당첨 확인 테스트 - 5개가 아닐 때 보너스가 맞을 경우 2등이 안되도록 되는지")
    void 당첨_확인_테스트3() {
        List<Lotto> lottos = new ArrayList<>(List.of(new Lotto(List.of(1,2,3,4,5,27)), new Lotto(List.of(1,2,3,43,44,45))));
        vendingMachineRepository.save(lottos);

        Map<Rank, Integer> result = winningService.checkLotto(new WinningLotto(new Lotto(List.of(1,2,3,43,44,45)), 27));

        assertEquals(Integer.valueOf(1), result.get(Rank.FIRST));
        assertEquals(Integer.valueOf(0), result.get(Rank.SECOND));
        assertEquals(Integer.valueOf(0), result.get(Rank.THIRD));
        assertEquals(Integer.valueOf(0), result.get(Rank.FOURTH));
        assertEquals(Integer.valueOf(1), result.get(Rank.FIFTH));
    }



}