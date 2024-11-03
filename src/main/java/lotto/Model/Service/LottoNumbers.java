package lotto.Model.Service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

import static lotto.constants.Constants.*;

public class LottoNumbers {

    public LottoNumbers() {
    }

    //로또의 랜덤 숫자를 만드는 로직
    public static List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE, LOTTO_NUMBER_LENGTH));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    //로또 1개를 만드는 로직
    public static Lotto makeLotto() {
        List<Integer> lottoNumbers = LottoNumbers.generateLottoNumbers();
        System.out.println(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    //사용자에게 입력받은 값을 기준으로 로또를 여러개 반환하는 로직
    public static List<Lotto> makeLottoList(int gameNumber) {
        System.out.println(gameNumber + "개를 구매했습니다.");
        ArrayList<Lotto> lottoList = new ArrayList<>();
        for (int i = 1; i <= gameNumber; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

}
