package csf.saved223.hububumback.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;

    @Column(name = "photo_path")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String photo_path;

    @Lob
    @Column(name = "text", nullable = false)
    private String text;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "post_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tags_id"))
    private Set<Tag> tags = new LinkedHashSet<>();

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private Person author;

}