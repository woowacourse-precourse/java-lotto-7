package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 구매한 로또의 개수 반환
    public static int lottoCount(int lottoPurchaseAmount){
        return lottoPurchaseAmount / 1000;
    }

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
