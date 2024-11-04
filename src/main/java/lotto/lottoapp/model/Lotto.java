package lotto.lottoapp.model;

import java.util.List;
import java.util.stream.Stream;
import lotto.lottoapp.model.value.LottoNumber;
import lotto.lottoapp.model.value.LottoNumbers;
import lotto.lottoapp.model.value.Won;

public class Lotto {

    private static final Won PRICE = Won.of(1_000);

    private final LottoNumbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = LottoNumbers.of(numbers);
    }

    public Lotto(LottoNumbersGenerator lottoNumbersGenerator) {
        this.numbers = LottoNumbers.of(lottoNumbersGenerator.generate());
    }

    public static int calculateCanBuyLotto(Won amountOfPaid) {
        if (!isMoneyLeftFrom(amountOfPaid)) {
            throw new IllegalArgumentException(String.format(
                    "로또 한 장의 가격은 %s원이며, 거스름돈을 남길 수 없습니다.",
                    PRICE));
        }

        return getNumberOfLottoAvailable(amountOfPaid);
    }

    public static List<Lotto> issueLottosBy(int numberOfLottosPurchased, LottoNumbersGenerator lottoNumbersGenerator) {
        return Stream.generate(() -> new Lotto(lottoNumbersGenerator))
                .limit(numberOfLottosPurchased)
                .toList();
    }

    public Stream<LottoNumber> stream() {
        return numbers.stream();
    }

    public LottoNumbers getLottoNumbers() {
        return numbers;
    }

    private static boolean isMoneyLeftFrom(Won amountOfPaid) {
        return amountOfPaid.reminder(PRICE)
                .equals(Won.of(0));
    }

    private static int getNumberOfLottoAvailable(Won amountOfPaid) {
        return amountOfPaid
                .divide(PRICE)
                .getIntValue();
    }

}
