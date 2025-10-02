package kr.co.bnk_marketproject_be.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductBoards is a Querydsl query type for ProductBoards
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductBoards extends EntityPathBase<ProductBoards> {

    private static final long serialVersionUID = 691674783L;

    public static final QProductBoards productBoards = new QProductBoards("productBoards");

    public final StringPath content = createString("content");

    public final StringPath created_at = createString("created_at");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> products_id = createNumber("products_id", Integer.class);

    public final NumberPath<Integer> rating = createNumber("rating", Integer.class);

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public final NumberPath<Integer> users_id = createNumber("users_id", Integer.class);

    public QProductBoards(String variable) {
        super(ProductBoards.class, forVariable(variable));
    }

    public QProductBoards(Path<? extends ProductBoards> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductBoards(PathMetadata metadata) {
        super(ProductBoards.class, metadata);
    }

}

