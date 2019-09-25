package t1708e.assgniment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import t1708e.assgniment.entity.Market;

import java.util.List;

@Repository
public interface MarketRepository extends JpaRepository<Market, Integer>, JpaSpecificationExecutor<Market> {
    Market findById(int id);
}
