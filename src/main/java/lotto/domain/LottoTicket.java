package lotto.domain;

import lotto.service.Issuing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoTicket {
    private static final int PRICE_TICKET = 1_000;
    private static final int PRICE_MAX = 100_000;
    private final int price;
    private final List<Lotto> lottoTickets = new ArrayList<>();
    private final HashMap<Rank, Integer> result = new HashMap<>();
    private int count;

    Issuing issue = new Issuing();

    public LottoTicket(int price) {
        validatePrice(price);
        this.price = price;
        count = priceChangeToTicket(price);
    }
    public void addLottoTicket(Lotto lotto){
        lottoTickets.add(lotto);
    }
    public int getCount(){
        return count;
    }
    public List<Lotto> getLottoTickets(){
        return lottoTickets;
    }
    public HashMap<Rank, Integer> getResult(){
        return result;
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
