package lotto.model;

import static lotto.utils.InputParser.lottoNumParse;
import static lotto.utils.LottoConfig.LOTTO_MAX_NUM;
import static lotto.utils.LottoConfig.LOTTO_MIN_NUM;
import static lotto.utils.LottoConfig.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> lottosGenerate(int n) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        List<Integer> randomNums;
        for (int i = 0; i < n; i++) {
            randomNums = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM.getValue(),LOTTO_MAX_NUM.getValue(),LOTTO_SIZE.getValue());
            randomNums = randomNums.stream()
                                    .sorted()
                                    .toList();
            Lotto newLotto = new Lotto(randomNums);
            lottos.add(newLotto);
        }
        return lottos;
    }

    public Lotto winLottoGenerate(){
        while(true){
            try{
                Lotto win = new Lotto(lottoNumParse());
                return win;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
