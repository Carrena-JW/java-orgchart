package carrena.orgchart.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserMapEntity is a Querydsl query type for UserMapEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserMapEntity extends EntityPathBase<UserMapEntity> {

    private static final long serialVersionUID = 834427369L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserMapEntity userMapEntity = new QUserMapEntity("userMapEntity");

    public final QEntityBase _super = new QEntityBase(this);

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdId = _super.createdId;

    public final QUserDepartmentEntity department;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isMainJob = createBoolean("isMainJob");

    //inherited
    public final DateTimePath<java.time.Instant> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedId = _super.modifiedId;

    public final QUserPositionEntity position;

    public final QUserRoleEntity role;

    public final QUserTitleEntity title;

    public final QUserEntity user;

    public QUserMapEntity(String variable) {
        this(UserMapEntity.class, forVariable(variable), INITS);
    }

    public QUserMapEntity(Path<? extends UserMapEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserMapEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserMapEntity(PathMetadata metadata, PathInits inits) {
        this(UserMapEntity.class, metadata, inits);
    }

    public QUserMapEntity(Class<? extends UserMapEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new QUserDepartmentEntity(forProperty("department")) : null;
        this.position = inits.isInitialized("position") ? new QUserPositionEntity(forProperty("position")) : null;
        this.role = inits.isInitialized("role") ? new QUserRoleEntity(forProperty("role")) : null;
        this.title = inits.isInitialized("title") ? new QUserTitleEntity(forProperty("title")) : null;
        this.user = inits.isInitialized("user") ? new QUserEntity(forProperty("user")) : null;
    }

}

