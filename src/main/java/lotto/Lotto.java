package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = List.of(1, 2, 3, 4, 5, 6);
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkRange(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int idx = Integer.parseInt(numbers.get(i).toString());
            if (idx < 1 || idx > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45입니다.");
            }
        }
    }

    private void duplicate(List<Integer> numbers) {
        int[] num = new int[46] ;
        Arrays.fill(num, 0);
        for (int i = 0; i < numbers.size(); i++) {
            int idx = Integer.parseInt(numbers.get(i).toString());
            num[idx]++;
            if (num[idx] > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 수여야 합니다.");
            }
        }
    }

    public void printLottoCount(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입금액은 1,000원 단위여야 합니다.");
        }
        System.out.println("\n" + cost/1000 + "개를 구매했습니다.");
    }

    public int getLottoCount(int cost) {
        return cost / 1000;
    }

    public List getRandomNumber() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    public List<List<Integer>> getLottos(int lottoCount) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(getRandomNumber());
        }
        return lottos;
    }

    public void printLottos(List<List<Integer>> lottos) {
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i));
        }
    }

    public List<Integer> splitWinNumbers(String winNumbers) {
        List<Integer> winLotto = new ArrayList<>();
        String[] winNumber = winNumbers.split(",");
        for (int i = 0; i < winNumber.length; i++) {
            winLotto.add(Integer.parseInt(winNumber[i]));
        }
        return winLotto;
    }

    public void printWinStatistics() {
        System.out.println("\n당첨 통계");
        System.out.println("---");

    }

    public void checkBonusNumber(List<Integer> winNumbers ,int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        } else if (bonusNumber < 0 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }
}
