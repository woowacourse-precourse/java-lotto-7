package lotto.presentation.model;

import java.util.HashMap;
import java.util.Map;

public class Model {

    private final Map<Key, Object> attributes = new HashMap<>();

    public void put(Key key, Object value) {
        attributes.put(key, value);
    }

    public Object get(Key key) {
        return attributes.get(key);
    }
}
