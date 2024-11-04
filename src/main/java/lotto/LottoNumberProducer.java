package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.internal.Integers;

public class LottoNumberProducer {
    public List<List<Integer>> lottoNumbers;
    private int lottoNum;

    LottoNumberProducer(int lottoNum) {
        this.lottoNum = lottoNum;
        this.lottoNumbers = new ArrayList<>();  // 리스트 초기화
    }

    public void createRandomNumbers() {

        for (int i = 0; i < lottoNum; i++) {
            lottoNumbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
    }

    public void displayLottoNumbers() {
        //오름차순으로 보여줘야함
        for (int i = 0; i < lottoNum; i++) {
            System.out.println(lottoNumbers.get(i));
        }
    }

    public List<List<Integer>> getLottoNumbers() {
        return this.lottoNumbers;
    }
}
