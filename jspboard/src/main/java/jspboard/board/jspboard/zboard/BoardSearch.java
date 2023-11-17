package jspboard.board.jspboard.zboard;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class BoardSearch {

    private String boardTitle;
    private String userName;

    private LocalDate startDate;  // 검색 범위 시작 날짜
    private LocalDate endDate; //검색 범위 끝 날짜
}
