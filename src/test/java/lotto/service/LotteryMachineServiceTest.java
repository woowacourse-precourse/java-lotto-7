package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.lang.reflect.Method;
import java.util.List;
import lotto.entity.Lotto;
import lotto.entity.Prize;
import lotto.entity.PurchaseAmount;
import lotto.model.LotteryMachineModel;
import lotto.model.StatisticModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LotteryMachineServiceTest {

    private LotteryMachineService lotteryMachineService;
    private LotteryMachineModel lotteryMachineModel;
    private StatisticModel statisticModel;

    @BeforeEach
    void init() {
        lotteryMachineModel = new LotteryMachineModel();
        statisticModel = new StatisticModel();
        lotteryMachineService = new LotteryMachineService(lotteryMachineModel, statisticModel);
    }

    @Test
    void buy_오류_없이_정상_작동한다() {
        // given
        StringBuilder sb = new StringBuilder();

        // when

        // then
        assertThatCode(() -> lotteryMachineService.buy(sb))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(longs = {0L, 1000L, (Long.MAX_VALUE - Long.MAX_VALUE % 1000)})
    void getPurchaseCount_구매금액에_대한_최종_구매개수를_정상적으로_반환한다(Long amount) throws Exception {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);

        Method getPurchaseCount = lotteryMachineService.getClass()
                .getDeclaredMethod("getPurchaseCount", PurchaseAmount.class);
        getPurchaseCount.setAccessible(true);

        // when
        long result = (long) getPurchaseCount.invoke(lotteryMachineService, purchaseAmount);

        // then
        assertThat(result).isEqualTo(amount / 1000);
    }

    @ParameterizedTest
    @ValueSource(longs = {0L, 1000L, 100000L})
    void issue_구매개수_만큼_로또를_발행하여_발매기에_저장한다(long amount) throws Exception {
        // given
        long purchaseCount = amount / 1000;
        StringBuilder sb = new StringBuilder();

        Method issue = lotteryMachineService.getClass()
                .getDeclaredMethod("issue", long.class, StringBuilder.class);
        issue.setAccessible(true);

        // when
        issue.invoke(lotteryMachineService, purchaseCount, sb);

        // then
        assertThat(lotteryMachineModel.getIssuedLotto().lottos().size()).isEqualTo(purchaseCount);
    }

    @Test
    void generate_Lotto를_정상적으로_생성하여_반환한다() throws Exception {
        // given
        Method generate = lotteryMachineService.getClass()
                .getDeclaredMethod("generate");
        generate.setAccessible(true);

        // when

        // then
        assertThatCode(() -> {
            Lotto lotto = (Lotto) generate.invoke(lotteryMachineService);
        })
                .doesNotThrowAnyException();
    }

    @Test
    void check_당첨_확인_메서드가_정상_동작한다() {
        // given
        lotteryMachineModel.insertPurchaseAmount(new PurchaseAmount(1000L));
        lotteryMachineService.buy(new StringBuilder());

        // when

        // then
        assertThatCode(() -> lotteryMachineService.check())
                .doesNotThrowAnyException();
    }

    @Test
    void compare_당첨_로또를_비교하고_저장한다() throws Exception {
        // given
        statisticModel.setPurchaseAmount(new PurchaseAmount(1000L));
        Method compare = lotteryMachineService.getClass()
                .getDeclaredMethod("compare", List.class, Integer.class, List.class);
        compare.setAccessible(true);

        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);

        // when
        compare.invoke(lotteryMachineService, winnerNumbers, bonusNumber, lotto);

        // then
        assertThat(statisticModel.getPrizeMoney()).isEqualTo(Prize.FIRST.getMoney());
    }

    @Test
    void compare_당첨_로또를_비교하고_저장한다2() throws Exception {
        // given
        statisticModel.setPurchaseAmount(new PurchaseAmount(1000L));
        Method compare = lotteryMachineService.getClass()
                .getDeclaredMethod("compare", List.class, Integer.class, List.class);
        compare.setAccessible(true);

        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 7);

        // when
        compare.invoke(lotteryMachineService, winnerNumbers, bonusNumber, lotto);

        // then
        assertThat(statisticModel.getPrizeMoney()).isEqualTo(Prize.SECOND.getMoney());
    }

    @ParameterizedTest
    @CsvSource({
            "6, true",
            "6, false",
            "5, true",
            "5, false",
            "4, true",
            "4, false",
            "3, true",
            "3, false",
    })
    void savePrize_해당_상품이_있으면_저장한다(int match, boolean bonus) throws Exception {
        // given
        statisticModel.setPurchaseAmount(new PurchaseAmount(1000L));
        Method savePrize = lotteryMachineService.getClass()
                .getDeclaredMethod("savePrize", int.class, boolean.class);
        savePrize.setAccessible(true);

        // when
        savePrize.invoke(lotteryMachineService, match, bonus);

        // then
        assertThat(statisticModel.getPrizeMoney()).isNotEqualTo(0L);
    }

    @Test
    void getStatistic_통계_데이터를_반환한다() throws Exception {
        // given
        StringBuilder sb = new StringBuilder();

        statisticModel.setPurchaseAmount(new PurchaseAmount(1000L));
        Method savePrize = lotteryMachineService.getClass()
                .getDeclaredMethod("savePrize", int.class, boolean.class);
        savePrize.setAccessible(true);

        int match = 6;
        boolean bonus = false;
        savePrize.invoke(lotteryMachineService, match, bonus);

        // when
        lotteryMachineService.getStatistic(sb);
        String result = sb.toString();

        // then
        assertThat(result).isEqualTo("""
                당첨 통계
                ---
                3개 일치 (5,000원) - 0개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 1개""");
    }

    @Test
    void getProfitRate_수익률을_계산하여_반환한다() throws Exception {
        // given
        StringBuilder sb = new StringBuilder();

        statisticModel.setPurchaseAmount(new PurchaseAmount(1000L));
        Method savePrize = lotteryMachineService.getClass()
                .getDeclaredMethod("savePrize", int.class, boolean.class);
        savePrize.setAccessible(true);

        int match = 6;
        boolean bonus = false;
        savePrize.invoke(lotteryMachineService, match, bonus);

        // when
        lotteryMachineService.getProfitRate(sb);
        String result = sb.toString();

        // then
        assertThat(result).isEqualTo("총 수익률은 200000000.0%입니다.");
    }

}