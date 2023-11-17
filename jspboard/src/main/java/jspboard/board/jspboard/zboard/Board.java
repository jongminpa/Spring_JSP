package jspboard.board.jspboard.zboard;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter @Setter
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    public Long id;


    public String division;
    public String userName;
    public String classification;
    public String userType;
    public String title;
    public String content;

    public String filePath;

    public Long click = 0L;

    private LocalDate createdAt;

    private LocalDate updatedAt;


    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDate.now();
    }




}
