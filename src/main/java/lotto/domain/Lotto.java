package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.utils.LottoNumbersGenerator;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;
    private static final String PURCHASE_INSUFFICIENT_MESSAGE = "구입금액이 부족합니다. 구매 개수를 낮춰주세요.";
    private static final String REQUEST_UNIT_OF_1000_MESSAGE = LOTTO_PRICE + "원 단위로 입력해주세요.";

    private final Amount inputAmount;
    private Tickets tickets = new Tickets(new ArrayList<>());

    public Lotto(int amount) {
        validateAmount(amount);
        this.inputAmount = new Amount(amount);
    }

    public Lotto(int amount, LottoNumbersGenerator lottoNumbersGenerator) {
        validateAmount(amount);
        this.inputAmount = new Amount(amount);
        this.tickets = Tickets.of(findCountOfPurchasable(), lottoNumbersGenerator);
    }

    private void validateAmount(int amount) {
        if (isNotDivisibleLottoPrice(amount)) {
            throw new IllegalArgumentException(PURCHASE_INSUFFICIENT_MESSAGE);
        }
    }

    private boolean isNotDivisibleLottoPrice(int amount) {
        return amount % LOTTO_PRICE != 0;
    }

    public int findCountOfPurchasable() {
        return inputAmount.getAmountDivide(LOTTO_PRICE);
    }

    public void addTicket(Ticket ticket) {
        if (inputAmount.isPurchasable(LOTTO_PRICE)) {
            tickets.add(ticket);
            inputAmount.decrease(LOTTO_PRICE);
        }
    }

    public Map<Rank, Integer> getResult(FirstTicket firstTicket) {
        return tickets.getResult(firstTicket);
    }

    public double getYield(FirstTicket firstTicket) {
        return tickets.getYield(inputAmount.getOriginalAmount(), firstTicket);
    }

    public Tickets getTickets() {
        return tickets;
    }

    public int getAutoTicketCount() {
        return tickets.getManualTicketCount();
    }


    public void validateTicketCount(int ticketCount) {
        if (!isPurchasable(ticketCount)) {
            throw new IllegalArgumentException(REQUEST_UNIT_OF_1000_MESSAGE);
        }
    }

    private boolean isPurchasable(int ticketCount) {
        return ticketCount <= inputAmount.getAmountDivide(LOTTO_PRICE);
    }

    // TODO: 추가 기능 구현
}
