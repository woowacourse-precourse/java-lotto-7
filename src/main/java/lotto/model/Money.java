package lotto.model;

public class Money {
    private final int amount;

    private Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public static Money of(int amount) {
        return new Money(amount);
    }

    public Ticket toTickets(){
        int ticketCount = this.amount / 1000;
        return new Ticket(ticketCount);
    }

    private void validate(int amount){
        validateRange(amount);
    }

    private void validateRange(int amount){
        if(amount < 1000 || amount > 100000){
            throw new IllegalArgumentException("[ERROR] 로또 구입 최소 금액은 1000원 최대 금액은 100000원 입니다.");
        }
    }
}
