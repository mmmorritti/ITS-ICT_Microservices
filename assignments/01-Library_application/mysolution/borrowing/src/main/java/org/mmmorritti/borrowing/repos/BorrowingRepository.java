package org.mmmorritti.borrowing.repos;

import org.mmmorritti.borrowing.models.Borrowing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing,Long> {
}
