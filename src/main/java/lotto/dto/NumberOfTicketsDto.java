package lotto.dto;

public class NumberOfTicketsDto {
    private static int numberOfTickets;

    public static void set(int numberOfTickets) {
        NumberOfTicketsDto.numberOfTickets = numberOfTickets;
    }

    public static int getNumberOfTickets() {
        return numberOfTickets;
    }

    public static int getPayment() {
        return numberOfTickets * 1_000;
    }
}
