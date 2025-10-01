package kr.co.bnk_marketproject_be.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdminNotice is a Querydsl query type for AdminNotice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdminNotice extends EntityPathBase<AdminNotice> {

    private static final long serialVersionUID = -321357238L;

    public static final QAdminNotice adminNotice = new QAdminNotice("adminNotice");

    public final StringPath boardType = createString("boardType");

    public final StringPath content = createString("content");

    public final StringPath createdAt = createString("createdAt");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> look = createNumber("look", Long.class);

    public final StringPath title = createString("title");

    public final StringPath updatedAt = createString("updatedAt");

    public final StringPath userId = createString("userId");

    public QAdminNotice(String variable) {
        super(AdminNotice.class, forVariable(variable));
    }

    public QAdminNotice(Path<? extends AdminNotice> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminNotice(PathMetadata metadata) {
        super(AdminNotice.class, metadata);
    }

}

