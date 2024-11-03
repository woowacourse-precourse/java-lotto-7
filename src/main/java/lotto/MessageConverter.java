package lotto;

import java.util.List;

public interface MessageConverter<T> {

    List<String> convert(List<T> targets);
}
