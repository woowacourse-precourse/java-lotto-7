package lotto.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.business.contract.MockedContractStrategy;
import lotto.business.draw.MockedDrawStrategy;
import lotto.business.issue.MockedIssueStrategy;
import lotto.io.MockedIOManager;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;
import lotto.lotto.LottoResult;
import lotto.lotto.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoShopTest {
    Money lottoPrice;
    MockedIOManager mockedIOManager;
    MockedContractStrategy mockedContractStrategy;
    MockedIssueStrategy mockedIssueStrategy;
    MockedDrawStrategy mockedDrawStrategy;
    LottoShop lottoShop;

    @BeforeEach
    void setUp() {
        lottoPrice = new Money(1_000);
        mockedIOManager = new MockedIOManager();
        mockedContractStrategy = new MockedContractStrategy(mockedIOManager);
        mockedIssueStrategy = new MockedIssueStrategy();
        mockedDrawStrategy = new MockedDrawStrategy();
        lottoShop = new LottoShop(lottoPrice, mockedContractStrategy, mockedIssueStrategy, mockedDrawStrategy);
    }

    @Nested
    class TestSellLotto {
        @ParameterizedTest
        @ValueSource(ints = {0, 2, 3, 4, 15})
        void should_size_of_lotteries_buy_equal_to_payed_amount(int numOfLotto) {
            // given
            mockedContractStrategy.payedMoney = numOfLotto * lottoPrice.value();
            mockedIssueStrategy.lottoNumbers = IntStream
                    .range(0, numOfLotto)
                    .mapToObj(i -> List.of(1, 2, 3, 4, 5, 6))
                    .collect(Collectors.toCollection(ArrayList::new));

            // when
            List<Lotto> lotteriesBuy = lottoShop.sellLotto();

            // then
            assertThat(lotteriesBuy.size()).isEqualTo(numOfLotto);
            assertThat(mockedContractStrategy.sellLottoCallCount).isEqualTo(1);
            assertThat(mockedIssueStrategy.issueManyCallCount).isEqualTo(1);
            assertThat(mockedIssueStrategy.issueManyLastCalledWith).isEqualTo(numOfLotto);
            assertThat(mockedContractStrategy.printBillCallCount).isEqualTo(1);
            assertThat(mockedContractStrategy.printBillLastCalledWith).isEqualTo(lotteriesBuy);
        }

        @Test
        void should_put_lotteries_issued() {
            // given
            mockedContractStrategy.payedMoney = 3 * lottoPrice.value();
            mockedIssueStrategy.lottoNumbers = new ArrayList<>(List.of(
                    List.of(1, 2, 3, 4, 5, 6),
                    List.of(11, 21, 31, 41, 25, 26),
                    List.of(13, 22, 33, 34, 45, 6)
            ));

            // when
            List<Lotto> lotteriesBuy = lottoShop.sellLotto();

            // then
            assertThat(lotteriesBuy).containsExactly(
                    new Lotto(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).toList()),
                    new Lotto(Stream.of(11, 21, 31, 41, 25, 26).map(LottoNumber::new).toList()),
                    new Lotto(Stream.of(13, 22, 33, 34, 45, 6).map(LottoNumber::new).toList())
            );
        }
    }

    @Nested
    class TestDraw {
        @Test
        void should_return_drawn_result() {
            // given
            mockedDrawStrategy.drawnNumbers = List.of(1, 2, 3, 4, 5, 6);
            mockedDrawStrategy.bonusNumber = 7;

            // when
            LottoResult lottoResult = lottoShop.draw();

            // then
            assertThat(lottoResult).isEqualTo(new LottoResult(
                    new WinningNumbers(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).toList()),
                    new LottoNumber(7)
            ));
            assertThat(mockedDrawStrategy.drawCallCount).isEqualTo(1);
        }
    }

    @Nested
    class TestPrintResult {
        @Test
        void should_print_winning_prizes() {
            // given
            List<Lotto> lotteries = List.of(
                    new Lotto(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).toList()),
                    new Lotto(Stream.of(11, 21, 3, 4, 5, 6).map(LottoNumber::new).toList()),
                    new Lotto(Stream.of(13, 22, 33, 34, 45, 6).map(LottoNumber::new).toList())
            );
            LottoResult lottoResult = new LottoResult(
                    new WinningNumbers(Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).toList()),
                    new LottoNumber(7)
            );

            // when
            lottoShop.printResult(lotteries, lottoResult);

            // then
            assertThat(mockedContractStrategy.printResultCallCount).isEqualTo(1);
            assertThat(mockedContractStrategy.printResultLastCalledWithLotteries).isEqualTo(lotteries);
            assertThat(mockedContractStrategy.printResultLastCalledWithLottoResult).isEqualTo(lottoResult);
            assertThat(mockedIOManager.outputBuilder.toString()).contains(
                    "lotto prizes",
                    "---",
                    "6개 일치 (2,000,000,000원)",
                    "4개 일치 (50,000원)",
                    "0개 일치 (0원)"
            );
        }
    }
}
