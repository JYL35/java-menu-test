package menu.view;

import menu.repository.RecommendHistory;

public class OutputView {
    private static final String START_SERVICE = "점심 메뉴 추천을 시작합니다.";
    private static final String RECOMMENDED_RESULTS = "메뉴 추천 결과입니다.";
    private static final String SUCCESS_RECOMMENDED = "추천을 완료했습니다.";

    public void printStartPhrase() {
        System.out.println(START_SERVICE);
        printNewLine();
    }

    public void printRecommendedResults() {
        System.out.println(RECOMMENDED_RESULTS);
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.println(RecommendHistory.formattedCategoryHistory());
        for (String coachEatResult : RecommendHistory.formattedEatHistory()) {
            System.out.println(coachEatResult);
        }
        printNewLine();
        System.out.println(SUCCESS_RECOMMENDED);
    }

    public void printError(RuntimeException e) {
        System.out.println(e.getMessage());
        printNewLine();
    }

    private static void printNewLine() {
        System.out.print(System.lineSeparator());
    }
}
