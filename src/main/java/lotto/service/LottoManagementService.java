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
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBERS_COUNT = 6;
    public static final int SECOND_MATCH_COUNT = 5;
    public static final int BONUS_NUM_NOT_APPLICABLE = -1; // 보너스 번호가 필요없는 경우의 상수 (2등을 제외한 모든 등수)

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

    // 랜덤한 로또 번호를 생성하여 UserLotto 객체로 반환
    public UserLotto createLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER, LOTTO_NUMBERS_COUNT));

        Collections.sort(lottoNumbers); // 오름차순 정렬

        return new UserLotto(lottoNumbers);
    }

    // 유저의 로또와 당첨 번호를 비교하여 당첨 여부를 확인
    public void drawLotto() {
        List<UserLotto> userLotto = userLottoRepository.findAll();
        Lotto lotto = lottoRepository.findWinningNums();

        userLotto.forEach(user -> {
            WinningRank winningRank = determineWinningRank(user, lotto);
            user.setWinningRank(winningRank);
        });
    }

    // 당첨 등수를 결정하는 메서드
    private WinningRank determineWinningRank(UserLotto userLotto, Lotto lotto) {
        List<Integer> userNums = userLotto.getNumbers();
        List<Integer> winningNumbers = lotto.getNumbers();

        boolean hasBonusNum = hasBonusNum(userLotto);
        long matchCount = calculateMatchCount(userNums, winningNumbers);

        return getWinningRank(matchCount, hasBonusNum);
    }

    // 일치하는 번호의 개수를 계산
    private long calculateMatchCount(List<Integer> userNums, List<Integer> winningNumbers) {
        return userNums.stream()
                .filter(winningNumbers::contains) // 당첨 번호에 포함된 사용자 번호 필터링
                .count();
    }

    // 일치하는 번호와 보너스 번호 여부에 따라 WinningRank를 결정 후 반환
    private WinningRank getWinningRank(long matchCount, boolean hasBN) {
        // 2등 여부 확인: 일치 숫자가 5개이고 보너스 번호가 일치하는 경우
        if (matchCount == SECOND_MATCH_COUNT && hasBN) {
            return WinningRank.SECOND;
        }

        // matchCount가 일치하고 보너스 번호가 필요 없는 등수 찾기
        for (WinningRank rank : WinningRank.values()) {
            if (rank.getMatchCount() == matchCount && rank.getBonusNumMatch() == BONUS_NUM_NOT_APPLICABLE) {
                return rank; // 해당 조건에 맞는 WinningRank 반환
            }
        }

        return WinningRank.NONE;
    }

    // WinningRank별 당첨 통계 계산
    public Map<WinningRank, Long> getWinningStatistics() {
        List<UserLotto> winningLottos = getWinningLottos();

        Map<WinningRank, Long> rankCounts = Arrays.stream(WinningRank.values())
                .filter(rank -> rank != WinningRank.NONE) // NONE을 제외
                .collect(Collectors.toMap(
                        rank -> rank, // 각 등수를 키로 설정
                        rank -> winningLottos.stream() // 해당 등수에 해당하는 로또의 개수를 세어 값으로 설정
                                .filter(winningLotto -> winningLotto.getWinningRank() == rank)
                                .count(),
                        (existing, replacement) -> existing, //같은 키에 대한 중복 처리를 위해 기존 값을 그대로 유지
                        () -> new EnumMap<>(WinningRank.class)
                ));

        return rankCounts;
    }

    // 당첨된 유저 로또 목록만 필터링하여 반환
    private List<UserLotto> getWinningLottos() {
        List<UserLotto> userLottos = userLottoRepository.findAll();
        List<UserLotto> winningLottos = new ArrayList<>();

        userLottos.forEach(userLotto -> {
            if (userLotto.getWinningRank() != WinningRank.NONE) {
                winningLottos.add(userLotto);
            }
        });

        return winningLottos;
    }

    // 등수별 당첨 개수에 따른 총 상금 합산
    public long calculateTotalPrize(Map<WinningRank, Long> statistics) {
        return statistics.entrySet().stream()
                .filter(entry -> entry.getKey() != WinningRank.NONE) // NONE 등수는 제외
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue()) // 당첨금 * 당첨로또 수
                .sum();
    }
    
}
