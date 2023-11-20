package carrena.orgchart.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserEntity is a Querydsl query type for UserEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserEntity extends EntityPathBase<UserEntity> {

    private static final long serialVersionUID = -38074727L;

    public static final QUserEntity userEntity = new QUserEntity("userEntity");

    public final QEntityBase _super = new QEntityBase(this);

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdId = _super.createdId;

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.Instant> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedId = _super.modifiedId;

    public final StringPath name = createString("name");

    public final StringPath officeTel = createString("officeTel");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<Long> sortOrder = createNumber("sortOrder", Long.class);

    public final EnumPath<carrena.orgchart.enums.Status> status = createEnum("status", carrena.orgchart.enums.Status.class);

    public final StringPath userIdentity = createString("userIdentity");

    public final StringPath userNumber = createString("userNumber");

    public QUserEntity(String variable) {
        super(UserEntity.class, forVariable(variable));
    }

    public QUserEntity(Path<? extends UserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserEntity(PathMetadata metadata) {
        super(UserEntity.class, metadata);
    }

}

