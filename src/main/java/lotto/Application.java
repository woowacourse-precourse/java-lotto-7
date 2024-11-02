package lotto;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        List<List<Integer>> list = lottoNumberGenerator.generateLottoNumbers();
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }
}
