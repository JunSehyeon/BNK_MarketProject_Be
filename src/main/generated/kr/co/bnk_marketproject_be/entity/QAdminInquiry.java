package kr.co.bnk_marketproject_be.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdminInquiry is a Querydsl query type for AdminInquiry
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdminInquiry extends EntityPathBase<AdminInquiry> {

    private static final long serialVersionUID = -1545726827L;

    public static final QAdminInquiry adminInquiry = new QAdminInquiry("adminInquiry");

    public final StringPath boardType = createString("boardType");

    public final StringPath content = createString("content");

    public final StringPath createdAt = createString("createdAt");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> look = createNumber("look", Long.class);

    public final StringPath tel = createString("tel");

    public final StringPath title = createString("title");

    public final StringPath updatedAt = createString("updatedAt");

    public final StringPath userId = createString("userId");

    public QAdminInquiry(String variable) {
        super(AdminInquiry.class, forVariable(variable));
    }

    public QAdminInquiry(Path<? extends AdminInquiry> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminInquiry(PathMetadata metadata) {
        super(AdminInquiry.class, metadata);
    }

}

