package kpn.cms.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kpn.cms.models.CMSUser;

public interface UserRepository extends CrudRepository<CMSUser, Long>{
    List<CMSUser> findByLastName(String lastName);
}