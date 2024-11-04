package lotto.sevice;

import lotto.model.WinLotto;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<Integer> equalsNum = new ArrayList<>();

        for(List<Integer> lotto : lottos){
            int cnt1 = lotto.stream().filter(o -> winLotto.stream()
                    .anyMatch(Predicate.isEqual(o))).toList().size();
            int cnt2 = lotto.stream().filter(o -> o == bonus).toList().size();
            if(cnt1 == 5 && cnt2 == 1){
                equalsNum.add(cnt1*2);
            }else{
                equalsNum.add(cnt1);
            }
        }
        List<Integer> res =  statisticNumbers(equalsNum);
        return res;
    }

    public List<Integer> statisticNumbers(List<Integer> winCounts){
        Integer[] arr = new Integer[5];
        Arrays.fill(arr, 0);

        for(int tmp : winCounts){
            if(tmp == 3){
                arr[0] += 1;
            }else if (tmp == 4){
                arr[1] += 1;
            }else if (tmp == 5){
                arr[2] += 1;
            }else if (tmp == 10){
                arr[3] += 1;
            }else if (tmp == 6){
                arr[4] += 1;
            }
        }
        return List.of(arr);
    }

    public String totalRevenueMoney(WinLotto[] winLottos, List<Integer> winCounts, int inputMoney){
        int[] arr = new int[winLottos.length];
        int i=0;
        for(WinLotto w : winLottos){
            String money = w.getPrizeMoney().replace(",", "");
            arr[i] = Integer.parseInt(money) * winCounts.get(i);
            i++;
        }
        return String.format("%.1f",(double)Arrays.stream(arr).sum()/(inputMoney*1000)*100);
    }
}
