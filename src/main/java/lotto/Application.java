package lotto;

import lotto.domain.*;
import lotto.dto.*;
import lotto.utils.BonusNumberInputParser;
import lotto.utils.LottoNumbersInputParser;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.utils.TicketFormatter;
import lotto.utils.TicketSorter;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        // 구입 금액 입력
        outputView.printPurchaseTotalPricePrompt();
        PurchaseTotalPriceInput purchaseTotalPriceInput = inputView.readPurchaseTotalPrice();
        PurchaseTotalPrice purchaseTotalPrice = PurchaseTotalPrice.from(purchaseTotalPriceInput.input());

        // 티켓 수 계산
        TicketCountCalculator ticketCountCalculator = new TicketCountCalculator();
        TicketCount ticketCount = ticketCountCalculator.calculateTotalTicketCount(purchaseTotalPrice);
        outputView.printPurchasedTicketCount(ticketCount.count());

        // 티켓 발행
        TicketIssuer ticketIssuer = new TicketIssuer(ticketCount);
        IssuedTickets issuedTickets = ticketIssuer.issueTickets();

        // 티켓 정렬
        SortedIssuedTickets sortedIssuedTickets = TicketSorter.getSortedTickets(issuedTickets);

        // 티켓 형식화
        FormattedTickets formattedTickets = TicketFormatter.formatTickets(sortedIssuedTickets);

        // 형식화된 티켓 출력
        outputView.printFormattedTickets(formattedTickets);

        //당첨 번호 입력
        outputView.printLottoNumbersInputPrompt();
        LottoNumbersInput lottoNumbersInput = inputView.readLottoNumbers();
        List<Integer> parsedLottoNumber = LottoNumbersInputParser.parse(lottoNumbersInput.input());
        Lotto lotto = new Lotto(parsedLottoNumber);


        //보너스 번호 입력
        outputView.printBonusNumberInputPrompt();
        BonusNumberInput bonusNumberInput = inputView.readBonusNumber();
        int parsedBonusNumber = BonusNumberInputParser.parse(bonusNumberInput.input());
        Bonus bonus = new Bonus(parsedBonusNumber, lotto);

        //당첨 통계 헤더 출력
        outputView.printWinningStatisticsHeader();

        // 당첨 결과 계산
        MatchCounter matchCounter = new MatchCounter(lotto, bonus);
        MatchResults matchResults = matchCounter.calculateMatchResults(sortedIssuedTickets);

        // 등수별 당첨 개수 집계
        RankCounter rankCounter = new RankCounter();
        Map<Rank, Integer> rankCounts = rankCounter.countRanks(matchResults);

        // 당첨 내역 출력
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NO_MATCH) {
                outputView.printRankStatistics(rank, rankCounts.getOrDefault(rank, 0));
            }
        }

        // 총 상금 계산
        int totalPrizeAmount = PrizeCalculator.calculateTotalPrize(rankCounts);

        // 수익률 계산
        ProfitResult profitResult = ProfitCalculator.calculateProfit(purchaseTotalPrice.totalPrice(), totalPrizeAmount);

        // 수익률 출력
        outputView.printProfitRate(profitResult.profitRate());

    }
}
