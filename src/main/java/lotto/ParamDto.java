package lotto;

import java.util.List;

public class ParamDto {

    public static class WinningLottoNumbers {
        public List<Integer> numbers;

        public WinningLottoNumbers(List<Integer> numbers) {
            this.numbers = numbers;
        }
    }

}
