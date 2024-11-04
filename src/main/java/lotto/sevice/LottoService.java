package lotto.sevice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoService {

    public int countLotto(String money){
        return Integer.parseInt(money)/1000;
    }

    public List<Integer> getWinLottoList(String lottoStr){
        String[] num = lottoStr.split(",");
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < num.length; i++) {
            res.add(Integer.parseInt(num[i].trim()));
        }
        return res;
    }

    public List<Integer> countWinLotto(List<List<Integer>> lottos,
                                       List<Integer> winLotto,
                                       int bonus){
        List<Integer> res = new ArrayList<>();

        for(List<Integer> lotto : lottos){
            int cnt1 = lotto.stream().filter(o -> winLotto.stream()
                    .anyMatch(Predicate.isEqual(o))).toList().size();
            int cnt2 = lotto.stream().filter(o -> o == bonus).toList().size();
            if(cnt1 == 5 && cnt2 == 1){
                res.add(cnt1*2);
            }
            res.add(cnt1);
        }
        return res;
    }
}
