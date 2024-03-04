package csf.saved223.hububumback.repository;

import csf.saved223.hububumback.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PostRepository extends CrudRepository<Post, UUID> {
}