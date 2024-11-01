package convert;

import java.util.List;
import java.util.stream.Collectors;

public class ListStringToNumConverter {
    public List<Integer> convert(List<String> inputStringList) {
        List<Integer> seperatedLottoWinningNumbersToInt = inputStringList.stream().mapToInt(Integer::parseInt).boxed()
                .toList();

        // 이름 바꿔야 함.
        return seperatedLottoWinningNumbersToInt;
    }
}
