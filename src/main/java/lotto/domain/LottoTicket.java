package lotto.domain;

public class LottoTicket {
    private static final int TICKET_PRICE = 1_000;
    private final int price;
    private int count;

    LottoTicket(int price) {
        validatePrice(price);
        this.price = price;
        count = priceChangeToTicket(price);
    }
    public int getCount(){
        return count;
    }
    private void validatePrice(int price){
        if(price < 0 || price > 100_000){
            throw new IllegalArgumentException("[ERROR] 로또 티켓은 10먼원까지 구입 가능합니다.");
        }
        if(checkMoneyChange(price) != 0 ){
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로만 판매 가능합니다.");
        }
    }
    private int priceChangeToTicket(int price){
        count = price /TICKET_PRICE;
        return count;
    }
    private int checkMoneyChange(int price){
        return price % TICKET_PRICE;
    }
}
