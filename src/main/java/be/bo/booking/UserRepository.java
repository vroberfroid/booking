package be.bo.booking;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import be.bo.user.User;

import org.springframework.data.jpa.repository.JpaRepository;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends JpaRepository<User, Long> {

}
