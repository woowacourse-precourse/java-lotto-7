package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        int price = 8000;
        // TODO: 여기도 연산
        int lottoCount = price / 1000; // TODO: 나누어 떨어지지 않으면 예외
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(randomNumbers);
            lottos.add(lotto);
        }

        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        List<Integer> machingNumCount = new ArrayList<>();
        for(int i=0;i<lottoCount;i++) {
            machingNumCount.add(countMatchingNumbers(lottos.get(i), winningLottoNumbers));
        }
        // [3, 0, 0, 0, 0]
        int revenue = 5000;
        double profit = revenue / price; // TODO: 연산
    }

    public static Integer countMatchingNumbers(Lotto lotto, List<Integer> winningNums) {
        return 1;
    }
}
