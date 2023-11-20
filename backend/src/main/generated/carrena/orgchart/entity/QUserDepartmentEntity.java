package carrena.orgchart.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserDepartmentEntity is a Querydsl query type for UserDepartmentEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserDepartmentEntity extends EntityPathBase<UserDepartmentEntity> {

    private static final long serialVersionUID = 1149469963L;

    public static final QUserDepartmentEntity userDepartmentEntity = new QUserDepartmentEntity("userDepartmentEntity");

    public final QEntityBase _super = new QEntityBase(this);

    //inherited
    public final DateTimePath<java.time.Instant> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdId = _super.createdId;

    public final StringPath departmentIdentity = createString("departmentIdentity");

    public final StringPath departmentManagerIdentity = createString("departmentManagerIdentity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.Instant> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedId = _super.modifiedId;

    public final StringPath name = createString("name");

    public final StringPath parentDepartmentIdentity = createString("parentDepartmentIdentity");

    public final NumberPath<Long> sortOrder = createNumber("sortOrder", Long.class);

    public final EnumPath<carrena.orgchart.enums.Status> status = createEnum("status", carrena.orgchart.enums.Status.class);

    public QUserDepartmentEntity(String variable) {
        super(UserDepartmentEntity.class, forVariable(variable));
    }

    public QUserDepartmentEntity(Path<? extends UserDepartmentEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserDepartmentEntity(PathMetadata metadata) {
        super(UserDepartmentEntity.class, metadata);
    }

}

