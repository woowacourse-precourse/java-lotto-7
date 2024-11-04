package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNoDuplicates(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void validatePurchaseAmount(int purchase_amount) {
        if (purchase_amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 천원 단위로 구매하여야 합니다.");
        }
    }
    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다: " + number);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<Lotto> create_Lotto(int lotto_count) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < lotto_count; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(randomNumbers);
            lottoList.add(lotto);
        }

        print_Lotto(lottoList);
        return lottoList;
    }

    public static void print_Lotto(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        lottoList.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static int[] parse_winNumberArray(String winning_numbers) {
        String[] winningString = winning_numbers.split(",");
        int[] winningNumbers = new int[winningString.length];

        for (int i = 0; i < winningString.length; i++) {
            // 각 요소를 정수로 변환
            winningNumbers[i] = Integer.parseInt(winningString[i].trim());
            validateWinningNumber(winningNumbers[i]);
        }

        validateNoDuplicatesWinningNumbers(winningNumbers);
        validateWinningNumbersCount(winningString.length);

        return winningNumbers;
    }

    public static void validateWinningNumber(int winningNum) {
        if (winningNum < 1 || winningNum > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateWinningNumbersCount(int count) {
        if (count != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 입력하여야 합니다.");
        }
    }

    public static void validateNoDuplicatesWinningNumbers(int[] numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다: " + number);
            }
        }
    }

    public static void validateNoDuplicatesBonusNumber(int[] winningNumbers, int bonus_number) {
        Set<Integer> winningSet = new HashSet<>();
        for (int number : winningNumbers) {
            winningSet.add(number);
        }

        if (winningSet.contains(bonus_number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다: " + bonus_number);
        }
    }

    public static int countMatches(Lotto myLotto, int[] winningNumbers) {
        Set<Integer> winningSet = new HashSet<>();
        for (int number : winningNumbers) {
            winningSet.add(number);
        }

        List<Integer> lottoNumbers = myLotto.getNumbers();
        int matchCount = 0;

        // 로또 번호를 확인하여 일치 개수를 세기
        for (Integer number : lottoNumbers) {
            if (winningSet.contains(number)) {
                matchCount++; // 중복된 숫자 발견 시 카운트 증가
            }
        }
        return matchCount;
    }

    public static void checkLottoMatch(Lotto myLotto, int[] winningNumbers, int bonus_number, int[] matchCountArray) {
        int matchCount = countMatches(myLotto, winningNumbers); // 일치 번호 개수 세기
        boolean hasBonusNumber = myLotto.getNumbers().contains(bonus_number); // 보너스 번호가 있는지 확인
        updateMatchCountArray(matchCount, hasBonusNumber, matchCountArray); // 배열 업데이트
    }

    public static void updateMatchCountArray(int matchCount, boolean hasBonusNumber, int[] matchCountArray) {
        if (matchCount >= 0 && matchCount <= 6) {
            matchCountArray[matchCount]++; // 0~6개의 일치 번호
        }
        if (matchCount == 5 && hasBonusNumber) {
            matchCountArray[7]++; // 5개 일치 + 보너스 번호
        }
    }

    public static void printWinResult(int matchNum,int matchCount) {
        if(matchNum == 3) {
            System.out.println(matchNum+"개 일치 (5,000원) - " + matchCount + "개");
        }
        if(matchNum == 4) {
            System.out.println(matchNum+"개 일치 (50,000원) - " + matchCount + "개");
        }
        if(matchNum == 5) {
            System.out.println(matchNum+"개 일치 (1,500,000원) - " + matchCount + "개");
        }
        if(matchNum == 7) {
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCount + "개");
        }
        if(matchNum == 6) {
            System.out.println(matchNum+"개 일치 (2,000,000,000원) - " + matchCount + "개");
        }
    }

    public static int calculateIncome(int[] matchCountArray) {
        int[] prizeMoney = {0, 0, 0, 5000, 50000, 1500000, 2000000000, 30000000};
        int totalIncome = 0;

        for (int i = 0; i < matchCountArray.length; i++) {
            totalIncome += matchCountArray[i] * prizeMoney[i];
        }
        return totalIncome;
    }

    public static void calculateROI(int totalIncome, int purchaseAmount) {
        double roi = (double) totalIncome / purchaseAmount * 100;
        double roundedRoi = Math.round(roi * 100.0) / 100.0;

        System.out.println("총 수익률은 " + roundedRoi + "%입니다.");
    }
}
