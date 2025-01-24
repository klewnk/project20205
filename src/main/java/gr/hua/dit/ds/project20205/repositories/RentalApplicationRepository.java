package gr.hua.dit.ds.project20205.repositories;
import gr.hua.dit.ds.project20205.entities.RentalApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalApplicationRepository extends JpaRepository<RentalApplication, Long> {

    @Query("SELECT ra FROM RentalApplication ra WHERE ra.property.id = :propertyId")
    List<RentalApplication> findByPropertyId(@Param("propertyId") Long propertyId);
}
