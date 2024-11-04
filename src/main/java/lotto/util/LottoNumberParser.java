package lotto.util;

import lotto.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoNumberParser {
    private static final int SPLIT_LIMIT = -1;
    private static final String DELIMITER = ",";

    /**
     * 문자열 당첨 번호를 구분자를 기준으로 정수형 리스트 형식으로 변경해주는 메서드
     * @param numbers 당첨 번호(문자열)
     */
    public static List<Integer> parseLottoNumbers(String numbers){
        try{
            return new ArrayList<>(
                            Arrays.stream(numbers.split(DELIMITER, SPLIT_LIMIT))
                            .map(Integer::parseInt)
                            .toList()
            );
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
    }
}
