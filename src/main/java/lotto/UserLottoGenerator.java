package lotto;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class UserLottoGenerator {
    // 사용자의 로또 번호 생성
    private final static int LOTTO_NUMBER_START = 1;
    private final static int LOTTO_NUMBER_END = 45;
    private final static int LOTTO_NUMBER_COUNT = 6;


    public static List<Integer> lottoGenerate() {
        List<Integer> generatedLottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START, LOTTO_NUMBER_END,
                LOTTO_NUMBER_COUNT);
        List<Integer> userLottos = new ArrayList<>(generatedLottoNumbers);
        Collections.sort(userLottos);
        return userLottos;
    }
}
