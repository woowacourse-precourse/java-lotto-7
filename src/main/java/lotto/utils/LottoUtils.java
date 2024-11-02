package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoUtils {
    public static List<Lotto> lottoGenerator(int lottoAmount) {
        return Stream.generate(() -> new Lotto(lottoNumberGenerator()))
                .limit(lottoAmount)
                .collect(Collectors.toList());
    }

    private static List<Integer> lottoNumberGenerator(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static List<Integer> generateWinningNumber(String inputWinningNumber){
        try {
            return Arrays.stream(inputWinningNumber.split(","))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 가능합니다. 입력 형식을 확인해 주세요");
        }
    }
}
