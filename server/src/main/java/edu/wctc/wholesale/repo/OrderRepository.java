package edu.wctc.wholesale.repo;

import edu.wctc.wholesale.entity.WholesaleOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<WholesaleOrder, Integer> {
}
