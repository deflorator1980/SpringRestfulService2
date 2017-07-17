package my;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by a on 29.06.17.
 */
public interface SaleRepository extends CrudRepository<Sale, Integer>{
    Sale findByGnomeId(String gnomeId);
}
