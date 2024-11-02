package lotto.dto;

import lotto.domain.Lotto;

public class UserSixNumberDTO {
    private final Lotto userSixNumber;

    public UserSixNumberDTO(Lotto userSixNumber) {
        this.userSixNumber = userSixNumber;
    }

    public Lotto getUserSixNumber() {
        return userSixNumber;
    }
}
