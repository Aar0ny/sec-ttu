package ee.ut.narva.proj.api.domain.base;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class UniversallyUniqueIdentity extends BaseModelObject {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    public UniversallyUniqueIdentity() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof UniversallyUniqueIdentity)) return false;
        final UniversallyUniqueIdentity other = (UniversallyUniqueIdentity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.id;
        final Object other$id = other.id;
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.id;
        result = result * PRIME + ($id == null ? 0 : $id.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof UniversallyUniqueIdentity;
    }

    public String toString() {
        return "ee.ut.narva.proj.api.domain.base.UniversallyUniqueIdentity(id=" + this.id + ")";
    }
}
