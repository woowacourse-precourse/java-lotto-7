package lotto.dto;

public class LottoPurchase {
    private int amount;

    public LottoPurchase(int amount){
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount){
        if(amount % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }

    public int getTicketNumber(){
        return amount/1000;
    }

    public int getAmount() {
        return amount;
    }
}
