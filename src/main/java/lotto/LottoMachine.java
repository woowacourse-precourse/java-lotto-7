package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    public List<Lotto> generateLottos(int quntity) {
        List<Lotto> result = new ArrayList<>();

        for (int i = 0; i < quntity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            result.add(new Lotto(numbers));
        }

        List<Lotto> unmodifiableResult = Collections.unmodifiableList(result);
        printGeneratedLottos(unmodifiableResult);

        return unmodifiableResult;
    }

    public void printGeneratedLottos(List<Lotto> generatedLottos) {
        int size = generatedLottos.size();
        StringBuilder result = new StringBuilder();

        result.append("\n").append(size).append("개 구매했습니다.\n");
        for(int i = 0; i < size; i++) {
            List<Integer> numbers = generatedLottos.get(i).getNumbers();
            result.append("[");
            numbers.forEach(e -> result.append(e).append(", "));
            result.replace(result.length()-2, result.length(), "]\n");
        }

        System.out.println(result);
    }
}
