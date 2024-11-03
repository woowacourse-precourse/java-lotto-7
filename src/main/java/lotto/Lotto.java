package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicatesCheck(numbers);
        this.numbers = numbers;

    }

    // 로또 번호 길이 체크
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 로또 번호 중복 체크
    private void duplicatesCheck(List<Integer> numbers) {
        Set<Integer> duplicatesNumber = new HashSet<>(numbers);
        if (duplicatesNumber.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }


    // 구매한 로또의 개수 반환
    public static int lottoCount(int lottoPurchaseAmount){
        return lottoPurchaseAmount / 1000;
    }

    // 구매한 로또 번호의 리스트들을 반환
    public static int[][] purchaseLottoNumbers(int lottoCount){
        int[][] lottoNumbers = new int[lottoCount][6];
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> purchaseLottoNumber =  Randoms.pickUniqueNumbersInRange(1, 45, 6);
            for (int j = 0; j < 6; j++) {
                lottoNumbers[i][j] = purchaseLottoNumber.get(j);
            }
        }
        return lottoNumbers;
    }

}
