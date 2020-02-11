package cz.databazista.spring5webapp.repositories;

import cz.databazista.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
