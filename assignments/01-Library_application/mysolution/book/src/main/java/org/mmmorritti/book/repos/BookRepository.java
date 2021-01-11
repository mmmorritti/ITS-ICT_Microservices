package org.mmmorritti.book.repos;

import org.mmmorritti.book.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book,Long> {
}
