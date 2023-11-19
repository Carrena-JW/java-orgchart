package carrena.orgchart.entity;


import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public abstract class EntityBase {
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;
    @CreatedBy
    @Column(nullable = false, updatable = false)
    private final String createdId = "ADMIN";
    @LastModifiedDate
    @Column(nullable = false, updatable = false)
    private  Instant modifiedAt;
    @LastModifiedBy
    @Column(nullable = false, updatable = false)
    private final String modifiedId = "ADMIN";
}
