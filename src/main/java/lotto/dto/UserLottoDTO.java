package lotto.dto;

import lotto.domain.UserLotto;

public class UserLottoDTO {
    private final UserLotto userLotto;

    private UserLottoDTO(UserLotto userLotto) {
        this.userLotto = userLotto;
    }

    public static UserLottoDTO of(UserLotto userLotto) {
        return new UserLottoDTO(userLotto);
    }

    public UserLotto getUserLotto() {
        return userLotto;
    }

}
