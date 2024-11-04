package lotto.converter;

public class StringToIntConverter implements Converter<String, Integer> {
    @Override
    public Integer convert(String source) {
        try {
            return Integer.parseInt(source.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요");
        }
    }
}
