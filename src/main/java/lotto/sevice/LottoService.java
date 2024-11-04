package lotto.sevice;

import java.util.ArrayList;
import java.util.List;

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
}
