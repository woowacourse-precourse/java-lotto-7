package lotto;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    //LottoMachine lottoMachine = new LottoMachine();
    private int amount;
    private static List<Lotto> ticket;
    //로또 개수만큼 생성


    public Ticket() {
        amount = Amount.get();
        ticket = new ArrayList<>();
        for(int i=0; i<amount; i++){
            Numbers numbers = new Numbers();
            ticket.add(new Lotto(numbers.get()));
        }
    }

    public static List<Lotto> get(){
        return ticket;
    }

    public void print(){
        for(Lotto lotto : ticket){
            System.out.println(lotto.toString());
        }
    }

}
