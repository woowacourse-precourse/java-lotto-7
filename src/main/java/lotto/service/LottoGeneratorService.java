package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoGeneratorService {

    public List<Integer> generateSixNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }
}
