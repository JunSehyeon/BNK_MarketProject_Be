package kr.co.bnk_marketproject_be.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductOptions is a Querydsl query type for ProductOptions
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductOptions extends EntityPathBase<ProductOptions> {

    private static final long serialVersionUID = -1334353780L;

    public static final QProductOptions productOptions = new QProductOptions("productOptions");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath option_name = createString("option_name");

    public final StringPath option_value = createString("option_value");

    public final NumberPath<Integer> products_id = createNumber("products_id", Integer.class);

    public final NumberPath<Integer> stock = createNumber("stock", Integer.class);

    public QProductOptions(String variable) {
        super(ProductOptions.class, forVariable(variable));
    }

    public QProductOptions(Path<? extends ProductOptions> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductOptions(PathMetadata metadata) {
        super(ProductOptions.class, metadata);
    }

}

