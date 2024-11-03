package lotto.domain;

import lotto.util.RandomNumbers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyLotto {
    private final List<List<Integer>> myLottos = new ArrayList<>();
    public MyLotto(int quantity){
        for(int count = 0;count<quantity;count++){
            List<Integer> lottoNumbers = new ArrayList<>(RandomNumbers.getGenerateLotto());
            Collections.sort(lottoNumbers);
            myLottos.add(lottoNumbers);
        }
    }
    public List<List<Integer>> getMyLottos() {
        return myLottos;
    }
}
