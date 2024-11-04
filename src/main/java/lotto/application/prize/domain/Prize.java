package lotto.application.prize.domain;

public class Prize {
    private final Long id;
    private final PrizeNumber prizeNumber;

    public Prize(Long id, PrizeNumber prizeNumber) {
        this.id = id;
        this.prizeNumber = prizeNumber;
    }

    public static Prize of(Long id, PrizeNumber prizeNumber) {
        return new Prize(id, prizeNumber);
    }

    public PrizeNumberResult getPrizeNumber() {
        return prizeNumber.getValue();
    }

    public Long getId() {
        return id;
    }
}
