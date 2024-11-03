package lotto.service;

import lotto.properties.LottoMatch;
import lotto.vo.Lotto;

import java.util.ArrayList;
import java.util.HashMap;

public class LottoMatchingSerivce {

    public int getMatchCount(Lotto lotto,Lotto selectLotto){
        int result = 0;
        for(int number : lotto.getNumbers()){
            if(selectLotto.getNumbers().contains(number)){
                result++;
            }
        }
        return result;
    }

    public int getMatchBonus(Lotto lotto,int bonusNumber){
        int result = 0;
        for(int number : lotto.getNumbers()){
            if(number == bonusNumber){
                result++;
            }
        }
        return result;
    }


    public HashMap<LottoMatch,Integer> getLottoResult(ArrayList<Lotto> lottoList,Lotto selectLotto,int bonusNumber){
        HashMap<LottoMatch,Integer> result = new HashMap<>();

        for(Lotto lotto : lottoList){
            int matchCount = getMatchCount(lotto,selectLotto);
            int matchBonus = getMatchBonus(lotto,bonusNumber);
            LottoMatch match = LottoMatch.getLottoMatch(matchCount, matchBonus);
            result.put(match, result.getOrDefault(match,0)+1);
        }

        return result;
    }

    public double getRateReturn(HashMap<LottoMatch,Integer> match,int cost){
        int total = 0;
        for(LottoMatch lottoMatch : LottoMatch.values()){
            int matchCount = match.getOrDefault(lottoMatch, 0);
            total += matchCount * lottoMatch.getPrize();
        }
        return (double) total / cost * 100;
    }


}
