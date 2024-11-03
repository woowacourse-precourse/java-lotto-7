package lotto.domain;

public class LottoTicket {
    private static final int PRICE_TICKET = 1_000;
    private static final int PRICE_MAX = 100_000;
    private final int price;
    private int count;

    public LottoTicket(int price) {
        validatePrice(price);
        this.price = price;
        count = priceChangeToTicket(price);
    }
    public int getCount(){
        return count;
    }
    private void validatePrice(int price){
        if(price < PRICE_TICKET || price > PRICE_MAX){
            throw new IllegalArgumentException("[ERROR] 로또 티켓은 10먼원까지 구입 가능합니다.");
        }
        if(checkMoneyChange(price) != 0 ){
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로만 판매 가능합니다.");
        }
    }
    private int priceChangeToTicket(int price){
        count = price / PRICE_TICKET;
        return count;
    }
    private int checkMoneyChange(int price){
        return price % PRICE_TICKET;
    }
}
