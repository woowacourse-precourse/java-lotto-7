package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public void printWinStatistics(List<List<Integer>> lottos, int bounsNumber) {
        int[] matchRank = new int[6];
        matchRank = getMatchRank(lottos, bounsNumber);
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + matchRank[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + matchRank[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchRank[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchRank[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchRank[4] + "개");
    }

    public void checkBonusNumber(int bonusNumber) {
        if (this.numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        } else if (bonusNumber < 0 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    public int compareWinNumbers(List<Integer> lottoNumbers) {
        int numberCount = 0;
        List<Integer> matchNumbers = new ArrayList<>();
        matchNumbers = this.numbers.stream()
                .filter(old -> lottoNumbers.stream()
                        .anyMatch(Predicate.isEqual(old)))
                .collect(Collectors.toList());
        numberCount = matchNumbers.size();
        return numberCount;
    }

    public boolean compareBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public int getMatchNumbers(List<Integer> randomLotto, int bounsNumber) {
        int[] matchRank = new int[6];
        int matchCount = 0;
        boolean isBonus = false;
        matchCount = compareWinNumbers(randomLotto);
        isBonus = compareBonusNumber(randomLotto, bounsNumber);
        if (matchCount == 5 && isBonus) {
            return 3;
        } else if (matchCount == 6) {
            return 4;
        } else if (matchCount >= 3) {
            return matchCount-3;
        }
        return 5;
    }

     public int[] getMatchRank(List<List<Integer>> lottos, int bounsNumber) {
        int[] matchRank = new int[6];
        for (int i = 0; i < lottos.size(); i++) {
            matchRank[getMatchNumbers(lottos.get(i), bounsNumber)]++;
        }
        return matchRank;
     }
}
