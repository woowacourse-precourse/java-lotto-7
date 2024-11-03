package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    // 생성자이므로 void를 붙이지 않고 일반 메서드와 구분한다.
    // 생성자는 객체를 초기화 할 때만 호출된다.
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicatesCheck(numbers);
        rangeCheck(numbers);
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
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        if (uniqueNumber.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    // 로또 번호 범위 체크
    private void rangeCheck(List<Integer> numbers) {
        for (int number:numbers){
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45사이어야 합니다.");
            }
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
