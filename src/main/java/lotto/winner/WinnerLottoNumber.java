package lotto.winner;

import lotto.number.LottoNumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerLottoNumber {
    private static final String LOTTO_SIZE_ERROR = "로또 번호는 6개여야 합니다.";
    private List<LottoNumber> lottoNumbers;

    private WinnerLottoNumber(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static WinnerLottoNumber createOfWinnerLottoNumber(String input) {
        return new WinnerLottoNumber(Arrays.stream(isValid(parse(input)))
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList()));
    }

    private static String[] parse(String input) {
        return input.trim().split(",");
    }

    private static String[] isValid(String[] lottoNumbers) {
        if (lottoNumbers.length != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }
        return lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean contains(LottoNumber priceLottoNumber) {
        return lottoNumbers.contains(priceLottoNumber);
    }

}
