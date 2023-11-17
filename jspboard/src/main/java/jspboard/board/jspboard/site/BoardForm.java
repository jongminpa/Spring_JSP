package jspboard.board.jspboard.site;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardForm {
    private Long id;

    private String division;
    private String username;
    private String classification;
    private String usertype;
    private String title;
    private String content;
    private String path;
}
