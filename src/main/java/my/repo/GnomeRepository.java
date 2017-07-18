package my.repo;

import my.model.Gnome;
import org.springframework.data.repository.CrudRepository;

public interface GnomeRepository extends CrudRepository<Gnome, String> {

}
