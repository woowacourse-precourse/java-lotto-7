package lotto.application;

import lotto.Lotto;
import lotto.LottoFactory;
import lotto.LottoPrize;
import lotto.UserLottoRepository;
import lotto.dto.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {
    private LottoFactory lottoFactory = new LottoFactory();
    private UserLottoRepository userLottoRepository;

    @BeforeEach
    void setUp() {
        userLottoRepository = new UserLottoRepository();
    }


    @Test
    @DisplayName("로또를 구매시 저장소에 저장된다.")
    void buyLotto() {

        LottoWinningEvaluator lottoWinningEvaluator = new LottoWinningEvaluator();
        LottoMachine lottoMachine = new LottoMachine(userLottoRepository, lottoWinningEvaluator, lottoFactory);

        lottoMachine.buyLotto();

        assertEquals(1, lottoMachine.getBuyingLottos().size());
    }

    @Test
    @DisplayName("유저가 구입한 로또 당첨결과를 정상적으로 계산한다.")
    void calculatePrize() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 8, 9));

        Map<LottoPrize,List<Lotto>> answer = Map.of(
            LottoPrize.SIX_MATCH, List.of(lotto1),
            LottoPrize.FIVE_MATCH, List.of(lotto2),
            LottoPrize.FOUR_MATCH, List.of(lotto3)
        );

        LottoWinningEvaluator lottoWinningEvaluator = new LottoWinningEvaluatorFake(answer);
        LottoMachine lottoMachine = new LottoMachine(userLottoRepository, lottoWinningEvaluator, lottoFactory);
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        userLottoRepository.save(lotto1);
        userLottoRepository.save(lotto2);


        // when
        Map<LottoPrize, Integer> lottoResult = lottoMachine.calculatePrize(winningLotto);

        // then
        assertAll(
            () -> assertEquals(1, lottoResult.get(LottoPrize.SIX_MATCH)),
            () -> assertEquals(1, lottoResult.get(LottoPrize.FIVE_MATCH)),
            () -> assertEquals(2, lottoResult.size())
        );

    }

    public static class LottoWinningEvaluatorFake extends LottoWinningEvaluator {
        private final Map<LottoPrize,List<Lotto>> answer;

        public LottoWinningEvaluatorFake(Map<LottoPrize,List<Lotto>> answer) {
            this.answer = answer;
        }

        @Override
        public Optional<LottoPrize> calculatePrize(Lotto lotto, WinningLotto winningLotto) {
            for (Map.Entry<LottoPrize, List<Lotto>> entry : answer.entrySet()) {
                if (entry.getValue().contains(lotto)) {
                    return Optional.of(entry.getKey());
                }
            }
            return Optional.empty();
        }
    }
}