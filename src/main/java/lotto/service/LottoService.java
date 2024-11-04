package lotto.service;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.*;

public class LottoService {


    public void printRank(int[] ranks){
        int cnt=4;
        for (Rank rank : Rank.values()) {
            rank.print(ranks[cnt--]);
        }
    }

    public void checkRank(Map<Integer,Lotto> lottoNumList, Lotto winnigNuum,int bonusNum,int money){
        int ranks[] = new int[5];

        for(Map.Entry<Integer,Lotto> entry : lottoNumList.entrySet()){
            int rank = checkWinningNum(entry.getValue(),winnigNuum,bonusNum);
            if(rank > 4) continue;
            ranks[rank]++;
        }

        printRank(ranks);
        int totalWinningMoney = calWinningMoney(ranks);
        Output.printMoney((totalWinningMoney*1.0/money)*100);
    }

    public int calWinningMoney(int ranks[]){
        int winningMoney[] = new int[5],cnt=4,sum=0;
        for(Rank rank : Rank.values()){
            winningMoney[cnt] = rank.getMoney()*ranks[cnt];
            cnt--;
        }
        for(int i=0;i<5;i++){
            sum+=winningMoney[i];
        }
        return sum;
    }

    public int checkWinningNum(Lotto lottonum, Lotto winningNum, int bonusNum){
        int winningCnt=0,lottoCnt=0,len=6;
        while(true){
            if(winningCnt>=6 || lottoCnt>=6) break;
            if(winningNum.getNumbers().get(winningCnt) == lottonum.getNumbers().get(lottoCnt)){
                winningCnt++;
                lottoCnt++;
                len--;
            }
            else if(winningNum.getNumbers().get(winningCnt) > lottonum.getNumbers().get(lottoCnt)){
                lottoCnt++;
            }
            else if(winningNum.getNumbers().get(winningCnt) < lottonum.getNumbers().get(lottoCnt)){
                winningCnt++;
            }
        }

        if(len==1) len+=checkBonus(lottonum,bonusNum);
        else if(len>1) len+=1;

        return len;
    }

    public int checkBonus(Lotto lottoNum, int bonusNum){
        for(int num: lottoNum.getNumbers()){
            if(bonusNum == num) return 0;
        }
        return 1;
    }

    public Map<Integer, Lotto> makeLottoNum(int n){
        Map<Integer,Lotto> lottoNumList = new HashMap<>();
        int cnt=1;
        while(true){
            List<Integer> lottoNum = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
            lottoNum.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(lottoNum);
            if(isDuplicated(lottoNumList,lotto)) continue;
            lottoNumList.put(cnt++,lotto);
            if(cnt == n+1) break;
        }
        for(int i=1;i<=lottoNumList.size();i++){
            System.out.println(lottoNumList.get(i).getNumbers());
        }
        return lottoNumList;
    }

    public boolean isDuplicated( Map<Integer,Lotto> lottoNumList, Lotto lottoNum) {
        for(int i=1;i<=lottoNumList.size();i++){
            if(lottoNumList.get(i).equals(lottoNum)) return true;
        }
        return false;
    }



}
