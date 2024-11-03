package lotto;

import lotto.domain.TicketCountCalculator;
import lotto.domain.PurchaseTotalPrice;
import lotto.domain.TicketIssuer;
import lotto.domain.WinningNumbersGenerator;
import lotto.dto.*;
import lotto.utils.LottoNumbersInputParser;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.utils.TicketFormatter;
import lotto.utils.TicketSorter;

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
        LottoNumbersInputParser.parse(lottoNumbersInput.input());

        //보너스 번호 입력
        outputView.printBonusNumberInputPrompt();

    }
}
