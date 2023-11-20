package carrena.orgchart.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEntityBase is a Querydsl query type for EntityBase
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QEntityBase extends EntityPathBase<EntityBase> {

    private static final long serialVersionUID = 1587496031L;

    public static final QEntityBase entityBase = new QEntityBase("entityBase");

    public final DateTimePath<java.time.Instant> createdAt = createDateTime("createdAt", java.time.Instant.class);

    public final StringPath createdId = createString("createdId");

    public final DateTimePath<java.time.Instant> modifiedAt = createDateTime("modifiedAt", java.time.Instant.class);

    public final StringPath modifiedId = createString("modifiedId");

    public QEntityBase(String variable) {
        super(EntityBase.class, forVariable(variable));
    }

    public QEntityBase(Path<? extends EntityBase> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEntityBase(PathMetadata metadata) {
        super(EntityBase.class, metadata);
    }

}

