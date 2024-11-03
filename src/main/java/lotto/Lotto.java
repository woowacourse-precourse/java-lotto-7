package lotto;

import lotto.number.LottoNumber;
import lotto.winner.WinnerLottoNumber;

import java.util.*;

public class Lotto {
    private static final String LOTTO_SIZE_ERROR = "로또 번호는 6개여야 합니다.";
    private static final String LOTTO_DUPLICATE_ERROR = "로또 번호 중복이 있습니다.";
    private static final int MIN_NUMBER = 3;

    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto createOfLotto(String numbers) {
        ArrayList<LottoNumber> newNumbers = new ArrayList<>(Arrays.stream(numbers.trim().split(",")).map(LottoNumber::new).toList());
        Collections.sort(newNumbers);
        return new Lotto(newNumbers);
    }

    public static Lotto createOfLotto(List<Integer> numbers) {
        List<LottoNumber> newNumbers = new ArrayList<>(numbers.stream().map(LottoNumber::new).toList());
        Collections.sort(newNumbers);
        return new Lotto(newNumbers);
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR);
        }

        Set<LottoNumber> lottoNumbers = Set.copyOf(numbers);
        if (lottoNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR);
        }
    }


    public Prize hitLottoNumber(WinnerLottoNumber winnerLottoNumber, LottoNumber bonusNumber) {
        boolean hasBonusNumber = hasBonusNumber(bonusNumber);
        int count = hitLottoNumberCount(winnerLottoNumber);

        if(count < MIN_NUMBER) {
            count = 0;
            hasBonusNumber = false;
        }

        return Prize.valueOf(count, hasBonusNumber);
    }

    private boolean hasBonusNumber(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private int hitLottoNumberCount(WinnerLottoNumber winnerLottoNumber) {
        int count = 0;
        for(LottoNumber lottoNumber : numbers) {
            if(winnerLottoNumber.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
