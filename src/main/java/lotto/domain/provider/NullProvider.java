package lotto.domain.provider;

import java.util.List;

public class NullProvider implements NumberProvider {

    @Override
    public List<Integer> provide() {
        return null;
    }

}
