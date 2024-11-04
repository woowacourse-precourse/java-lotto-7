package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.constants.Ranking;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoHandler;
import lotto.model.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoTest extends NsTest {


    private Customer customer;
    private LottoHandler lottoHandler;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        lottoHandler = new LottoHandler();
    }

    @Test
    @DisplayName("1등 당첨 테스트")
    void 일등_당첨_테스트() {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        List<Integer> boughtNumbers = List.of(1,2,3,4,5,6);

        Lotto lotto = new Lotto(winningNumbers);
        Lottos lottos = new Lottos(boughtNumbers);

        Ranking resultRanking = lottoHandler.checkedResult(lotto, lottos);

        assertEquals(resultRanking.getWinnings(), 2000000000);
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
