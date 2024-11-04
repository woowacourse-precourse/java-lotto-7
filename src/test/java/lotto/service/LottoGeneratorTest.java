package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.util.NumberGenerate;

class LottoGeneratorTest implements NumberGenerate {

    private List<Integer> expect = Arrays.asList(1, 20, 34, 42, 32, 6);

    @Override
    public List<Integer> randomGenerateInRange(int start, int end, int count) {
        return expect;
    }
}