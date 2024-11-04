package lotto.dto;

import static lotto.common.constant.LottoConstant.PAYMENT_UNIT_WON;

public class NumberOfTicketsDto {
    private static int numberOfTickets;

    public static void set(int numberOfTickets) {
        NumberOfTicketsDto.numberOfTickets = numberOfTickets;
    }

    public static int getNumberOfTickets() {
        return numberOfTickets;
    }

    public static int getPayment() {
        return numberOfTickets * PAYMENT_UNIT_WON;
    }
}
