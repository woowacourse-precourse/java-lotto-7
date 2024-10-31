package lotto.validate;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberValidate {

    private final List<Integer> lottoNumber;

    public LottoNumberValidate(String numberString) {
        List<Integer> lottoNumber = parseNumber(splitNumberString(numberString));
        isRangeNumber(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    private List<String> splitNumberString(String numberString) {
        return List.of(numberString.split(","));
    }

    private List<Integer> parseNumber(List<String> list) {
        try {
            return list.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    private void isRangeNumber(List<Integer> numberList) {
        if (numberList.stream().anyMatch((number) -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1 ~ 45 범위 안의 숫자여야 합니다.");
        }
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }
}
