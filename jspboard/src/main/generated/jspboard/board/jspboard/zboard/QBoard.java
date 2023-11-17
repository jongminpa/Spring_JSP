package jspboard.board.jspboard.zboard;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = 825932828L;

    public static final QBoard board = new QBoard("board");

    public final StringPath classification = createString("classification");

    public final NumberPath<Long> click = createNumber("click", Long.class);

    public final StringPath content = createString("content");

    public final DatePath<java.time.LocalDate> createdAt = createDate("createdAt", java.time.LocalDate.class);

    public final StringPath division = createString("division");

    public final StringPath filePath = createString("filePath");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public final DatePath<java.time.LocalDate> updatedAt = createDate("updatedAt", java.time.LocalDate.class);

    public final StringPath userName = createString("userName");

    public final StringPath userType = createString("userType");

    public QBoard(String variable) {
        super(Board.class, forVariable(variable));
    }

    public QBoard(Path<? extends Board> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoard(PathMetadata metadata) {
        super(Board.class, metadata);
    }

}

