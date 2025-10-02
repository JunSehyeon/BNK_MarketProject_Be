package kr.co.bnk_marketproject_be.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDeliveries is a Querydsl query type for Deliveries
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDeliveries extends EntityPathBase<Deliveries> {

    private static final long serialVersionUID = 1226432495L;

    public static final QDeliveries deliveries = new QDeliveries("deliveries");

    public final StringPath address = createString("address");

    public final NumberPath<Integer> delichar = createNumber("delichar", Integer.class);

    public final StringPath delicom = createString("delicom");

    public final StringPath delivered_at = createString("delivered_at");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath invoice = createString("invoice");

    public final NumberPath<Integer> orders_id = createNumber("orders_id", Integer.class);

    public final StringPath receipt = createString("receipt");

    public final StringPath recipient = createString("recipient");

    public final StringPath shipped_at = createString("shipped_at");

    public final StringPath status = createString("status");

    public QDeliveries(String variable) {
        super(Deliveries.class, forVariable(variable));
    }

    public QDeliveries(Path<? extends Deliveries> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDeliveries(PathMetadata metadata) {
        super(Deliveries.class, metadata);
    }

}

