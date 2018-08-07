package be.bo.booking;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;

@RepositoryRestResource(collectionResourceRel = "booking", path = "booking")
public interface BookingRepository extends JpaRepository<Reservation, Long> {

}
