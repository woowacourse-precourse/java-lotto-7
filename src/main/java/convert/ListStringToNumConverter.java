package convert;

import java.util.List;
import java.util.stream.Collectors;

public class ListStringToNumConverter {
    private final List<String> inputStringList;

    public ListStringToNumConverter(List<String> inputListString) {
        this.inputStringList = inputListString;
    }

    public List<Integer> convert() {
        List<Integer> seperatedLottoWinningNumbersToInt = inputStringList.stream().mapToInt(Integer::parseInt).boxed()
                .toList();

        return seperatedLottoWinningNumbersToInt;
    }
}
