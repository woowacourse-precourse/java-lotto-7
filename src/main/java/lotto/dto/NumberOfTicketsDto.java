package lotto.dto;

public record NumberOfTicketsDto(int numberOfTickets) {
    private static NumberOfTicketsDto numberOfTicketsDto;

    public NumberOfTicketsDto {
        numberOfTicketsDto = new NumberOfTicketsDto(numberOfTickets);
    }

    public static NumberOfTicketsDto getNumberOfTicketsDto() {
        return numberOfTicketsDto;
    }

    public int getPayment() {
        return numberOfTickets * 1_000;
    }
}
