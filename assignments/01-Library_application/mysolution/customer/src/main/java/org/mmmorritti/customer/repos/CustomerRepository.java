package org.mmmorritti.customer.repos;

import org.mmmorritti.customer.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Long> {
}
