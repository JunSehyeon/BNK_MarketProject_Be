package kr.co.bnk_marketproject_be.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrders is a Querydsl query type for Orders
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrders extends EntityPathBase<Orders> {

    private static final long serialVersionUID = 1592539586L;

    public static final QOrders orders = new QOrders("orders");

    public final StringPath created_at = createString("created_at");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath order_code = createString("order_code");

    public final StringPath status = createString("status");

    public final NumberPath<Integer> total_amount = createNumber("total_amount", Integer.class);

    public final StringPath updated_at = createString("updated_at");

    public final NumberPath<Integer> users_id = createNumber("users_id", Integer.class);

    public QOrders(String variable) {
        super(Orders.class, forVariable(variable));
    }

    public QOrders(Path<? extends Orders> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrders(PathMetadata metadata) {
        super(Orders.class, metadata);
    }

}

