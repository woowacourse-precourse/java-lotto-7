package lotto.models;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoModel {
    private static final String DELIMITER = ",";

    public int calculateAmount(String amountInput) {
        int amount = Integer.parseInt(amountInput);
        return (amount / 1000);
    }

    // 사용자가 정수 아닌 값을 입력했을 경우 ERROR + 재입력받도록
    public List<Integer> stringToList (String lottoNumberInput) {
        ArrayList<Integer> numbers = new ArrayList<>();
        String[] tokens = lottoNumberInput.split(DELIMITER);
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }
        return numbers;
    }

    public static ArrayList<Integer> getRandomLottoNumbers() {
        return (ArrayList<Integer>) Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> sortNumbers (List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }



}
