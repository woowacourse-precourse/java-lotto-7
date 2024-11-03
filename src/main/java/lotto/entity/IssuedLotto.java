package lotto.entity;

import java.util.List;

public record IssuedLotto(
        List<Lotto> lottos
) {

    public IssuedLotto {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            if (!sb.isEmpty()) {
                sb.append("\n");
            }
            sb.append(lotto);
        }
        return sb.toString();
    }
}
