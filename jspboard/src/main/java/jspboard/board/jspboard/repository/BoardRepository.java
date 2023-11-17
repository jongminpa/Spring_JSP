package jspboard.board.jspboard.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jspboard.board.jspboard.zboard.Board;
import jspboard.board.jspboard.zboard.BoardSearch;
import jspboard.board.jspboard.zboard.QBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jspboard.board.jspboard.zboard.QBoard.board;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private JPAQueryFactory jpaQueryFactory;


    public void save(Board board){
        em.persist(board);
    }

    public Board findOne(Long id){
        return em.find(Board.class,id);
    }

    public List<Board> findAll(){
        return em.createQuery("select b from Board b",Board.class).getResultList();
    }

    public List<Board> findBoardS(BoardSearch boardSearch){
        QBoard qboard = QBoard.board;
        BooleanBuilder builder = new BooleanBuilder();

        //이름,제목 검색
        if (boardSearch.getBoardTitle() != null) {
            builder.or(board.title.containsIgnoreCase(boardSearch.getBoardTitle()));
        }
        if (boardSearch.getUserName() != null) {
            builder.or(board.userName.eq(boardSearch.getUserName()));
        }

        ///날짜 검색

        BooleanBuilder dateBuilder = new BooleanBuilder();
        if (boardSearch.getStartDate() != null){
            dateBuilder.or(board.createdAt.goe(boardSearch.getStartDate()));
        }
        if(boardSearch.getEndDate() != null){
            dateBuilder.or(board.createdAt.loe(boardSearch.getEndDate()));
        }

        if(dateBuilder.hasValue()){
            builder.and(dateBuilder);
        }
        return jpaQueryFactory.selectFrom(board).where(builder).fetch();
    }

}
