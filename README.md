# java-lotto-precourse

# 구현할 기능 목록
    1. Lotto 클래스
        - 역할: 로또 번호의 유효성 검사, 6개의 고유 번호 저장
        - 주요 메소드
            - validate() : 입력된 로또 번호가 6개인지 확인
            - getNumbers() : 로또 번호 리스트를 반환
    2. Selling 클래스
        - 역할 : 사용자가 입력한 금액에 따라 로또를 자동으로 생성하여 반환 
        - 주요 메소드
            - purchaseLottos(): 구입 금액에 따라 로또 번호를 생성, 객체 배열로 반환
            - generateLottoNumbers(): 1부터 45 사이의 고유한 숫자 6개를 생성
        
    3. Winning 클래스
        - 역할 : 당첨 번호와 보너스 번호를 관리, 구입한 로또와 비교하여 당첨 등수를 확인
        - 주요 메소드
            - checkLotto(Lotto lotto) : 로또 번호와 당첨 번호를 비교, 등수를 판별
            - validateWinningNumbers() : 입력된 당첨 번호가 6개인지 중복된 숫자가 없는지 검증
            - validateBonusNumber() : 보너스 번호가 1부터 45 사이의 번호인지 확인

    4. Benefit 클래스
        - 역할 : 당첨 결과를 기반으로 수익률을 계산
        - 주요 메소드
            - calculateBenefit() : 총 구입 금액 대비 총 당첨금의 비율로 수익률을 계산하여 반환
    
    5. LottoService 클래스
        - 약할 : 프로그램의 흐름을 관리
        - 주요 메소드
            - run()
            - displayResults() : 당첨 결과 출력
            - displayBenefit() : 수익률 계산 및 출력

    6. LottoRank
        - 역할 : 로또 당첨 등수 관리, 해당하는 상금 반환
        - 주요 메소드
            - valueOf() : 매칭 개수와 보너스 일치 여부에 따라 등수 반환