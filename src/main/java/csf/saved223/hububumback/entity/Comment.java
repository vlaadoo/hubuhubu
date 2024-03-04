package csf.saved223.hububumback.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.type.SqlTypes;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private Person author;

    @Lob
    @Column(name = "text", nullable = false)
    private String text;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Comment comment = (Comment) o;
        return getId() != null && Objects.equals(getId(), comment.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}