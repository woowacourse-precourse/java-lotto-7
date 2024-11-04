package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private Lotto lotto;

    private int bonusNumber;
    public WinningLotto(String lottoNumber, int bonusNumber) {
        this.lotto = new Lotto(splitLottoNumber(lottoNumber));
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private List<Integer> splitLottoNumber(String lottoNumber) {

        return Arrays.stream(lottoNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }



}
