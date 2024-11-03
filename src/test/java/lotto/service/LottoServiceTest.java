package lotto.service;

import lotto.application.LottoTicketsDto;
import lotto.application.WinningNumbersDto;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.DefaultUserMoney.USER_MONEY;
import static lotto.domain.DefaultUserMoney.USER_MONEY_TEN_THOUSAND;
import static lotto.domain.MonetaryUnit.PERCENTAGE;
import static lotto.domain.MonetaryUnit.A_LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    @DisplayName("발행한 로또를 반환한다.")
    @Test
    void 발행한_로또를_반환() {
        LottoService lottoService = new LottoService();
        LottoTicketsDto lottoTicketsDto = lottoService.createLottoTickets(USER_MONEY.getUnit());

        assertThat(lottoTicketsDto.getLottoTickets()).hasSize(USER_MONEY.getUnit() / A_LOTTO_PRICE.getUnit());
    }

    @DisplayName("모든 구매한 로또와 당첨로또를 비교한다.")
    @ParameterizedTest
    @MethodSource("provideLottoTicketsAndWinningNumberAndBonusNumber")
    void 모든_구매한_로또와_당첨로또를_비교한다(List<List<Integer>> lottoTickets, WinningNumbersDto winningNumbersDto, List<Rank> expectedRanks) {
        LottoService lottoService = new LottoService();
        LottoTicketsDto lottoTicketsDto = new LottoTicketsDto(lottoTickets);
        List<Rank> ranks = lottoService.calculateRanks(lottoTicketsDto, winningNumbersDto);

        assertThat(ranks).containsExactlyElementsOf(expectedRanks);
    }

    static Stream<Arguments> provideLottoTicketsAndWinningNumberAndBonusNumber() {
        return Stream.of(
                Arguments.of(List.of(List.of(1, 2, 3, 4, 5, 6),
                                List.of(1, 2, 3, 4, 5, 7),
                                List.of(1, 2, 3, 4, 5, 8),
                                List.of(1, 2, 3, 4, 8, 9),
                                List.of(1, 2, 3, 8, 9, 10),
                                List.of(1, 2, 8, 9, 10, 11),
                                List.of(1, 2, 3, 4, 5, 6)),
                        new WinningNumbersDto(List.of(1, 2, 3, 4, 5, 6), 7),
                        List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.NONE, Rank.FIRST))
        );
    }

    @DisplayName("당첨 여부를 바탕으로 수익룰을 계산한다.")
    @ParameterizedTest
    @MethodSource("provideUserMoneyAndRanks")
    void 당첨_여부를_바탕으로_수익률을_계산(int userMoney, List<Rank> ranks, double expectedReturnOfRate) {
        LottoService lottoService = new LottoService();
        Double returnOfRate = lottoService.calculateRateOfReturn(userMoney, ranks);

        assertThat(returnOfRate).isEqualTo(expectedReturnOfRate);
    }

    static Stream<Arguments> provideUserMoneyAndRanks() {
        return Stream.of(
                Arguments.of(USER_MONEY.getUnit(), List.of(Rank.FIRST, Rank.SECOND), ((Rank.FIRST.getPrize() + Rank.SECOND.getPrize()) / USER_MONEY.getUnit()) * PERCENTAGE.getUnit()),
                Arguments.of(USER_MONEY_TEN_THOUSAND.getUnit(), List.of(Rank.FIRST, Rank.SECOND), ((Rank.FIRST.getPrize() + Rank.SECOND.getPrize()) / USER_MONEY_TEN_THOUSAND.getUnit()) * PERCENTAGE.getUnit())
        );
    }
}