package kr.co.bnk_marketproject_be.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdminPoint is a Querydsl query type for AdminPoint
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdminPoint extends EntityPathBase<AdminPoint> {

    private static final long serialVersionUID = 822754270L;

    public static final QAdminPoint adminPoint = new QAdminPoint("adminPoint");

    public final NumberPath<Integer> balance = createNumber("balance", Integer.class);

    public final StringPath boardType = createString("boardType");

    public final NumberPath<Integer> change_amount = createNumber("change_amount", Integer.class);

    public final StringPath created_at = createString("created_at");

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath users_id = createString("users_id");

    public QAdminPoint(String variable) {
        super(AdminPoint.class, forVariable(variable));
    }

    public QAdminPoint(Path<? extends AdminPoint> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminPoint(PathMetadata metadata) {
        super(AdminPoint.class, metadata);
    }

}

