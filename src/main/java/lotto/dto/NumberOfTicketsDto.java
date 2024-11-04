package lotto.dto;

public record NumberOfTicketsDto (int numberOfTickets) {
    private static NumberOfTicketsDto numberOfTicketsDto;

    public NumberOfTicketsDto(int numberOfTickets) {
        numberOfTicketsDto = new NumberOfTicketsDto(numberOfTickets);
    }

    public static NumberOfTicketsDto getNumberOfTicketsDto() {
        return numberOfTicketsDto;
    }
}
