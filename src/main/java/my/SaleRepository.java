package my;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by a on 29.06.17.
 */
public interface SaleRepository extends CrudRepository<Sale, Integer>{
    List<Sale> findByGnomeId(String gnomeId);
    Optional<Sale> findByGnomeIdAndItemId(String gnomeId, String itemId);
}
