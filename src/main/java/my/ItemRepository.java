package my;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by a on 28.06.17.
 */
public interface ItemRepository extends CrudRepository<Item, String> {
}
