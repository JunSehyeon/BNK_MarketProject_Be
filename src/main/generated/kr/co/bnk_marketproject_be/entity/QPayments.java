package kr.co.bnk_marketproject_be.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPayments is a Querydsl query type for Payments
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPayments extends EntityPathBase<Payments> {

    private static final long serialVersionUID = 1570546378L;

    public static final QPayments payments = new QPayments("payments");

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath method = createString("method");

    public final NumberPath<Integer> orders_id = createNumber("orders_id", Integer.class);

    public final StringPath paid_at = createString("paid_at");

    public final StringPath status = createString("status");

    public QPayments(String variable) {
        super(Payments.class, forVariable(variable));
    }

    public QPayments(Path<? extends Payments> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPayments(PathMetadata metadata) {
        super(Payments.class, metadata);
    }

}

