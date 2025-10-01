package kr.co.bnk_marketproject_be.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdminStats is a Querydsl query type for AdminStats
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdminStats extends EntityPathBase<AdminStats> {

    private static final long serialVersionUID = 825666285L;

    public static final QAdminStats adminStats = new QAdminStats("adminStats");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath status = createString("status");

    public final NumberPath<Long> totalAmount = createNumber("totalAmount", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QAdminStats(String variable) {
        super(AdminStats.class, forVariable(variable));
    }

    public QAdminStats(Path<? extends AdminStats> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminStats(PathMetadata metadata) {
        super(AdminStats.class, metadata);
    }

}

