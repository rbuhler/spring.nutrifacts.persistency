package io.github.rbuhler.nutrifactspersistency.Entities;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Date;

public class BaseEntity {

    @Version
    @Column
    private long version;
    @NotBlank
    @Column(updatable = false)
    private Timestamp createdAt;
    @Column(insertable = false)
    private Timestamp modifiedAt;

    protected static Timestamp now( ){
        return new Timestamp(new Date().getTime());
    }

    public void setVersion(long version) {
        this.version = version;
    }
    public Long getVersion() { return this.version; }

    @PrePersist
    protected void onPersist(){
        this.createdAt = now();
    }
    public Timestamp getCreatedAt(){ return this.createdAt; }

    @PreUpdate
    protected void onUpdate(){
        this.modifiedAt = now();
    }
    public Timestamp getModifiedAt() { return  this.modifiedAt; }
}
