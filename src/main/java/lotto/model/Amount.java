package lotto.model;

public class Amount {
    private final int amount;
    private final int count;
    private final int UNIT_AMOUNT = 1000;

    public Amount(String input){
        int amountNumber = parseInput(input);
        validateDivisible(amountNumber);
        this.amount = amountNumber;
        this.count = amount / UNIT_AMOUNT;
    }

    private void validateDivisible(int amountNumber){
        if(amountNumber % UNIT_AMOUNT != 0){
            throw new IllegalArgumentException("[ERROR] 로또는 개당 1000원 입니다.");
        }
    }

    private int parseInput(String input){
        return Integer.parseInt(input);
    }

    public int getCount(){
        return this.count;
    }
}
