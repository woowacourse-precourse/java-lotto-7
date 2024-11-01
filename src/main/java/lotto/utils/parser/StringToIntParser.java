package lotto.utils.parser;

public class StringToIntParser implements Parser<Integer>{
    @Override
    public Integer parse(String rawNumber) {
        return Integer.parseInt(rawNumber);
    }
}
