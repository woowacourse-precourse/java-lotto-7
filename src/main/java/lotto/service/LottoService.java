package lotto.service;

import lotto.factory.LottoFactory;
import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    public List<Lotto> purchase(int amount){
        // 구매할 수 있는 로또 개수
        int count = amount / LottoFactory.PRICE;

        return LottoFactory.create(count);
    }

    public Lotto parseLotto(String input) {
        try {
            // 문자열을 쉼표로 구분하여 정수 리스트로 변환
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)                      // 각 요소를 trim하여 공백 제거
                    .map(Integer::parseInt)                 // 문자열을 정수로 변환
                    .collect(Collectors.toList());          // 리스트로 수집

            // 변환된 리스트를 Lotto 객체로 생성하여 반환
            return new Lotto(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 포함되어있습니다.");
        }
    }
}
