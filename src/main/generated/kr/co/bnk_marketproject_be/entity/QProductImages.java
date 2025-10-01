package kr.co.bnk_marketproject_be.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductImages is a Querydsl query type for ProductImages
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductImages extends EntityPathBase<ProductImages> {

    private static final long serialVersionUID = 890221258L;

    public static final QProductImages productImages = new QProductImages("productImages");

    public final StringPath created_at = createString("created_at");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath is_main = createString("is_main");

    public final NumberPath<Integer> products_id = createNumber("products_id", Integer.class);

    public final StringPath url = createString("url");

    public QProductImages(String variable) {
        super(ProductImages.class, forVariable(variable));
    }

    public QProductImages(Path<? extends ProductImages> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductImages(PathMetadata metadata) {
        super(ProductImages.class, metadata);
    }

}

