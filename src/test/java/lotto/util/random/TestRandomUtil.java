package lotto.util.random;

import java.util.List;

public class TestRandomUtil implements RandomUtil {

    private final List<Integer> fixedResults;

    public TestRandomUtil(List<Integer> fixedResults) {
        this.fixedResults = fixedResults;
    }

    @Override
    public List<Integer> issueLottoTicket(Integer minNumber, Integer maxNumber, Integer lottoCount) {
        return fixedResults;
    }
}
