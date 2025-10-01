package kr.co.bnk_marketproject_be.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrderItems is a Querydsl query type for OrderItems
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderItems extends EntityPathBase<OrderItems> {

    private static final long serialVersionUID = 884732271L;

    public static final QOrderItems orderItems = new QOrderItems("orderItems");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> orders_id = createNumber("orders_id", Integer.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> product_options_id = createNumber("product_options_id", Integer.class);

    public final NumberPath<Integer> products_id = createNumber("products_id", Integer.class);

    public final NumberPath<Integer> quentity = createNumber("quentity", Integer.class);

    public QOrderItems(String variable) {
        super(OrderItems.class, forVariable(variable));
    }

    public QOrderItems(Path<? extends OrderItems> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderItems(PathMetadata metadata) {
        super(OrderItems.class, metadata);
    }

}

