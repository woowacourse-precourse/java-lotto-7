package lotto.model;

import lotto.model.UserLotto;

// Output에 필요한 메서드 모음
public class OutputModel {

    // 유저 로또 리스트를 출력
    public void showUserLotto(UserLotto userLotto) {
        for (Lotto lotto : userLotto.getUserLotto()) {
            System.out.println(lotto);
        }
    }
}
