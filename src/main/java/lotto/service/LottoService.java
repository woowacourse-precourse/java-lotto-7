package lotto.service;

import java.util.Arrays;
import java.util.List;

public class LottoService {

    public List<Integer> generateLotto (String str) {
        return Arrays.stream(str.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
