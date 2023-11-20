package carrena.orgchart.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserTitleEntity is a Querydsl query type for UserTitleEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserTitleEntity extends EntityPathBase<UserTitleEntity> {

    private static final long serialVersionUID = 1626599269L;

    public static final QUserTitleEntity userTitleEntity = new QUserTitleEntity("userTitleEntity");

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

    public final NumberPath<Long> sortOrder = createNumber("sortOrder", Long.class);

    public final EnumPath<carrena.orgchart.enums.Status> status = createEnum("status", carrena.orgchart.enums.Status.class);

    public final StringPath titleIdentity = createString("titleIdentity");

    public QUserTitleEntity(String variable) {
        super(UserTitleEntity.class, forVariable(variable));
    }

    public QUserTitleEntity(Path<? extends UserTitleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserTitleEntity(PathMetadata metadata) {
        super(UserTitleEntity.class, metadata);
    }

}

