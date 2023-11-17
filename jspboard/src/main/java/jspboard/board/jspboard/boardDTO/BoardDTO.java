package jspboard.board.jspboard.boardDTO;

import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Getter @Setter
public class BoardDTO {

    public String userName;
    public String title;
    public String content;
    public String Path;

    private LocalDate createdAt;

}
