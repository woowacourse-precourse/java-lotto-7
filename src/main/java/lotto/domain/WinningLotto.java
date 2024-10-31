package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WinningLotto {
    private final Lotto winningLotto;

    public WinningLotto(String readLine) {
        List<Integer> list;
        try {
            String[] split = readLine.split(",");
            Stream<String> stream = Arrays.stream(split);
            Stream<Integer> integerStream = stream.map(Integer::parseInt);
            list = integerStream.toList();
        }catch (Exception e){
            throw new IllegalArgumentException(ErrorMessage.READ_NUMBER_ERROR_MESSAGE);
        }
        winningLotto = new Lotto(list);
    }
}
