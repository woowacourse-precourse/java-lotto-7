package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Store {
    public static ArrayList<Lotto> ticketMachine(int amount){
        int count = amount / 1000;
        ArrayList<Lotto> tickets = new ArrayList<>();

        for(int index = 0; index < count; index++){
            List<Integer> ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            tickets.add(new Lotto(ticket));
        }
        return tickets;
    }
}
