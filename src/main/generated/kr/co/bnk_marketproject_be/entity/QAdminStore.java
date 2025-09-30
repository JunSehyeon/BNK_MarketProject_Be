package kr.co.bnk_marketproject_be.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdminStore is a Querydsl query type for AdminStore
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdminStore extends EntityPathBase<AdminStore> {

    private static final long serialVersionUID = 825679663L;

    public static final QAdminStore adminStore = new QAdminStore("adminStore");

    public final StringPath boardType = createString("boardType");

    public final StringPath busname = createString("busname");

    public final StringPath comnum = createString("comnum");

    public final StringPath cornum = createString("cornum");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath look = createString("look");

    public final StringPath manage = createString("manage");

    public final StringPath rep = createString("rep");

    public final StringPath tel = createString("tel");

    public QAdminStore(String variable) {
        super(AdminStore.class, forVariable(variable));
    }

    public QAdminStore(Path<? extends AdminStore> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminStore(PathMetadata metadata) {
        super(AdminStore.class, metadata);
    }

}

