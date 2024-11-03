package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMachine {
    private final List<Lotto> lottos;
    private static LottoMachine instance;

    public LottoMachine() {
        this.lottos = new ArrayList<>();
    }

    public static LottoMachine getInstance() {
        if (instance == null) {
            instance = new LottoMachine();
        }
        return instance;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void createLottos(int lottoCount) {
        for(int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = sortNumbers(makeNumbers());
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public void createWinningNumbers(List<Integer> numbers, int bonusNumber) {
        WinningNumbers winningNumbers = WinningNumbers.getInstance(numbers, bonusNumber);
    }

    public List<Integer> makeNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Set<Integer> safeNumbers = new HashSet<>(numbers);

        if (safeNumbers.size() < 6) {
           numbers = makeNumbers();
        }

        return numbers;
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public void printAllLottoNumbers() {
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

}
