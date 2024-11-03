package lotto.view.converter;

import java.util.List;

public interface MessageParser<T> {

    List<String> toMessages(List<T> targets);

    List<Integer> toNumbers(String message);
}
