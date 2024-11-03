package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class MakeTickets {
    public List<List<Integer>> tickets = new ArrayList<>();

    public void makeTickets(int num){
        for (int i=0;i<num;i++) {
            List<Integer> temp = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            tickets.add(temp);
        }
    }

    public List<List<Integer>> getTickets(){
        return tickets;
    }
}
