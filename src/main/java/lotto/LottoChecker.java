package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {
    int prize = 0;
    List<Integer> winTickets=new ArrayList<>();
    // 5등/4등/3등/2등/1등 순으로 당첨된 티켓 수를 저장하는 리스트
    List<Integer> tmp = new ArrayList<>();
    public void lottoChecker(List<Integer> winNum, List<List<Integer>> tickets, int bonusNum){
        for (List<Integer> sublist : tickets) {
            int count = 0;
            if (containsElement(sublist, winNum)) {
                tmp.add(count);
            }
        }
        for(int i=0;i<tickets.size();i++) {
            if(tmp.get(i)>=3){
                tmp.set(i, tmp.get(i) + 1);
            }
        }

        countWinTickets(tmp, tickets, bonusNum);
    }

    private boolean containsElement(List<Integer> sublist, List<Integer> winNum) {
        //각각의 티켓들과 당첨번호 비교하는 메소드(depth 3을 피하기 위한 메소드분리)
        for (int num : winNum) {
            if (sublist.contains(num)) {
                return true;
            }
        }
        return false;
    }

    private void countWinTickets(List<Integer> tmp, List<List<Integer>> tickets, int bonusNum){
        for(int i=0;i<tmp.size();i++){
            if(tmp.get(i)==3){
                winTickets.set(0, winTickets.get(0) + 1);
            }
            if(tmp.get(i)==4){
                winTickets.set(1, winTickets.get(1) + 1);

            }
            if(tmp.get(i)==5){
                winTickets.set(2, winTickets.get(2) + 1);

            }
            if(tmp.get(i)==6){
                winTickets.set(4, winTickets.get(4) + 1);

            }
        }
        plusBonusNum(tickets, bonusNum);
    }

    private void plusBonusNum(List<List<Integer>> tickets, int bonusNum){
        //5개의 숫자가 맞았을 때 보너스숫자도 맞는지 확인하는 메소드
        for(int i=0;i<tmp.size();i++) {
            if(tmp.get(i)==5 && tickets.get(i).contains(bonusNum)){
                winTickets.set(2, winTickets.get(2) - 1);
                winTickets.set(3, winTickets.get(3) + 1);
            }
        }
    }

    public int getPrize(){
        return prize;
    }
    
    public List<Integer> getWinTickets(){
        return winTickets;
    }
}
