package kr.co.bnk_marketproject_be.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSeller is a Querydsl query type for Seller
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSeller extends EntityPathBase<Seller> {

    private static final long serialVersionUID = 1695295068L;

    public static final QSeller seller = new QSeller("seller");

    public final StringPath biz_registration_number = createString("biz_registration_number");

    public final StringPath brand_name = createString("brand_name");

    public final StringPath created_at = createString("created_at");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath mail_order_number = createString("mail_order_number");

    public final StringPath seller_id = createString("seller_id");

    public final StringPath updated_at = createString("updated_at");

    public final NumberPath<Integer> user_id = createNumber("user_id", Integer.class);

    public QSeller(String variable) {
        super(Seller.class, forVariable(variable));
    }

    public QSeller(Path<? extends Seller> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSeller(PathMetadata metadata) {
        super(Seller.class, metadata);
    }

}

