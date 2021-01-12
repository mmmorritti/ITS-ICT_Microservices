package org.mmmorritti.borrowing.repos;

import org.mmmorritti.borrowing.models.Borrowing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepository extends MongoRepository<Borrowing,Long> {
}
