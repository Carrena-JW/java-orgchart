package carrena.orgchart.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserPositionEntity is a Querydsl query type for UserPositionEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserPositionEntity extends EntityPathBase<UserPositionEntity> {

    private static final long serialVersionUID = -488623326L;

    public static final QUserPositionEntity userPositionEntity = new QUserPositionEntity("userPositionEntity");

    public final QEntityBase _super = new QEntityBase(this);

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdId = _super.createdId;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.Instant> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedId = _super.modifiedId;

    public final StringPath name = createString("name");

    public final StringPath positionIdentity = createString("positionIdentity");

    public final NumberPath<Long> sortOrder = createNumber("sortOrder", Long.class);

    public final EnumPath<carrena.orgchart.enums.Status> status = createEnum("status", carrena.orgchart.enums.Status.class);

    public QUserPositionEntity(String variable) {
        super(UserPositionEntity.class, forVariable(variable));
    }

    public QUserPositionEntity(Path<? extends UserPositionEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserPositionEntity(PathMetadata metadata) {
        super(UserPositionEntity.class, metadata);
    }

}

