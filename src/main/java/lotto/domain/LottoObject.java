package lotto.domain;

import java.util.List;

public interface LottoObject {

    void validateDuplicate(List<Object> lottoObjects);

    void validateLength(List<Object> lottoObjects);
}
