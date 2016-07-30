package hello;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by a on 30.07.16.
 */
public interface RepaGnomes extends CrudRepository<Gnomes, String> {
}
