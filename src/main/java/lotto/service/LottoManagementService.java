package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.UserLotto;
import lotto.domain.WinningRank;
import lotto.repository.LottoRepository;
import lotto.repository.UserLottoRepository;

import java.util.*;
import java.util.stream.Collectors;

public class LottoManagementService {

    private final UserLottoRepository userLottoRepository;
    private final LottoRepository lottoRepository;

    public LottoManagementService(UserLottoRepository userLottoRepository, LottoRepository lottoRepository) {
        this.userLottoRepository = userLottoRepository;
        this.lottoRepository = lottoRepository;
    }

    public void joinUserLotto(UserLotto userLotto) {
        userLottoRepository.save(userLotto);
    }

    public void joinLotto(Lotto lotto) {
        lottoRepository.save(lotto);
    }

    // 보너스 번호 포함 여부를 각 유저 로또에 저장
    public void setBonusNumForUsers(int bonusNum) {
        List<UserLotto> userLotto = userLottoRepository.findAll();

        userLotto.forEach(user -> {
            user.setHasBonusNum(bonusNum);
        });
    }

    private boolean hasBonusNum(UserLotto userLotto) {
        return userLotto.getHasBonusnum();
    }

}
