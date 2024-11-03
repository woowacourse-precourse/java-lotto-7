package lotto.model;



import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AutoLottoGenerator {

    public AutoLottoGenerator() {
    }

    public List<Lotto> generate(int lottoCount){
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i<lottoCount;i++){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

        return lottos;
    }
}
