package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberMatching {
    private int MatchingCount(List<Integer> amountLottoNumbers, List<Integer> winningLottoNumbers,int bonusNumber){
        int count=0;
        for (int i:amountLottoNumbers){
            if(winningLottoNumbers.contains(i)){
                count++;
            }
        }
        if(count==6){
            return 1;
        }
        if(count==5 && amountLottoNumbers.contains(bonusNumber)){
            return 2;
        }
        return 8-count;
    }

    public List<Integer> matchingLottos(List<List<Integer>> lottos, List<Integer> winningLottoNumbers,int bonusNumber){
        List<Integer> lottoRanks= new ArrayList<>();
        for(List<Integer> lotto:lottos){
            int rank=MatchingCount(lotto,winningLottoNumbers,bonusNumber);
            lottoRanks.add(rank);
        }
        return lottoRanks;
    }
}
