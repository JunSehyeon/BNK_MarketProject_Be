package kr.co.bnk_marketproject_be.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdminMember is a Querydsl query type for AdminMember
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdminMember extends EntityPathBase<AdminMember> {

    private static final long serialVersionUID = -359436788L;

    public static final QAdminMember adminMember = new QAdminMember("adminMember");

    public final StringPath boardType = createString("boardType");

    public final StringPath created_at = createString("created_at");

    public final StringPath gender = createString("gender");

    public final StringPath grade = createString("grade");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath look = createString("look");

    public final StringPath point = createString("point");

    public final StringPath rep = createString("rep");

    public final StringPath tel = createString("tel");

    public QAdminMember(String variable) {
        super(AdminMember.class, forVariable(variable));
    }

    public QAdminMember(Path<? extends AdminMember> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminMember(PathMetadata metadata) {
        super(AdminMember.class, metadata);
    }

}

