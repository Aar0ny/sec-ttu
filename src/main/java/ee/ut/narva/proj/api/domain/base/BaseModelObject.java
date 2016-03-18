package ee.ut.narva.proj.api.domain.base;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseModelObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @CreatedDate
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updatedDate;

    @Version
    private Long version;

    public BaseModelObject() {
    }

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return this.updatedDate;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof BaseModelObject)) return false;
        final BaseModelObject other = (BaseModelObject) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$createdDate = this.createdDate;
        final Object other$createdDate = other.createdDate;
        if (this$createdDate == null ? other$createdDate != null : !this$createdDate.equals(other$createdDate))
            return false;
        final Object this$updatedDate = this.updatedDate;
        final Object other$updatedDate = other.updatedDate;
        if (this$updatedDate == null ? other$updatedDate != null : !this$updatedDate.equals(other$updatedDate))
            return false;
        final Object this$version = this.version;
        final Object other$version = other.version;
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $createdDate = this.createdDate;
        result = result * PRIME + ($createdDate == null ? 0 : $createdDate.hashCode());
        final Object $updatedDate = this.updatedDate;
        result = result * PRIME + ($updatedDate == null ? 0 : $updatedDate.hashCode());
        final Object $version = this.version;
        result = result * PRIME + ($version == null ? 0 : $version.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseModelObject;
    }

    public String toString() {
        return "ee.ut.narva.proj.api.domain.base.BaseModelObject(createdDate=" + this.createdDate + ", updatedDate=" + this.updatedDate + ", version=" + this.version + ")";
    }
}
