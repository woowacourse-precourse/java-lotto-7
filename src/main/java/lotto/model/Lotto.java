package lotto.model;

import lotto.dto.MatchInfo;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        List<Integer> parsingLottoNumbers = parseLottoNumbers(numbers);
        validate(parsingLottoNumbers);
        this.numbers = parsingLottoNumbers;
    }

    public MatchInfo makeMatchInfo(Lotto userLotto, int bonusNumber) {
        int matchCount = 0;
        boolean isMatchBonusNumber = false;

        for (Integer userLottoNumber : userLotto.numbers) {
            if (this.numbers.contains(userLottoNumber)) {
                matchCount++;
            }
        }

        if (this.numbers.contains(bonusNumber)) {
            isMatchBonusNumber = true;
        }

        return new MatchInfo(matchCount, isMatchBonusNumber);
    }

    public String getLottoNumbers() {
        return formatLottoNumber() + "\n";
    }

    private List<Integer> parseLottoNumbers(String rawLottoNumbers) {
        List<Integer> parsingNumbers = new ArrayList<>();
        String[] lottoNumbers = rawLottoNumbers.split(",");

        for (String lottoNumber : lottoNumbers) {
            try {
                parsingNumbers.add(Integer.parseInt(lottoNumber));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨번호를 숫자로만 입력해주세요.");
            }
        }

        return parsingNumbers;
    }

    private String formatLottoNumber() {
        List<Integer> sortLottoNumbers = sortLottoNumbers();
        return String.join(", ", Arrays.toString(sortLottoNumbers.toArray()));
    }

    private List<Integer> sortLottoNumbers() {
        return numbers.stream().sorted().toList();
    }

    public void checkBonusNumberDuple(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스번호가 중복되면 안됩니다.");
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        checkNumberDuple(numbers);
        checkValidArrange(numbers);
    }

    private void checkValidArrange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 수만 가능합니다.");
            }
        }
    }

    private void checkNumberDuple(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 숫자가 중복되면 안됩니다.");
            }
            uniqueNumbers.add(number);
        }
    }
}
