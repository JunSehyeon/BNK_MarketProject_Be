package kr.co.bnk_marketproject_be.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProducts is a Querydsl query type for Products
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProducts extends EntityPathBase<Products> {

    private static final long serialVersionUID = -815897343L;

    public static final QProducts products = new QProducts("products");

    public final NumberPath<Integer> categories_id = createNumber("categories_id", Integer.class);

    public final StringPath created_at = createString("created_at");

    public final StringPath description = createString("description");

    public final NumberPath<Integer> discount = createNumber("discount", Integer.class);

    public final NumberPath<Integer> hits = createNumber("hits", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> product_code = createNumber("product_code", Integer.class);

    public final StringPath product_name = createString("product_name");

    public final NumberPath<Integer> sellers_id = createNumber("sellers_id", Integer.class);

    public final StringPath status = createString("status");

    public final NumberPath<Integer> stock = createNumber("stock", Integer.class);

    public final StringPath updated_at = createString("updated_at");

    public QProducts(String variable) {
        super(Products.class, forVariable(variable));
    }

    public QProducts(Path<? extends Products> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProducts(PathMetadata metadata) {
        super(Products.class, metadata);
    }

}

