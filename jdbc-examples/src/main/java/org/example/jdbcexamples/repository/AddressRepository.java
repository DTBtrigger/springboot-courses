package org.example.jdbcexamples.repository;

import org.example.jdbcexamples.dox.Address;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
    @Query("""
           select * from address a where a.user_id=:userId
       """)
    List<Address> findByUserId(String userId);

    @Modifying
    @Query("""
            update address a set detail=:detail  where a.user_Id=:userId
        """)
    void updateAddressByUserId(String userId, String detail);

    @Modifying
    @Query("""
           delete from address a where a.user_id =:userId 
       """)
    void deleteAddressByUserId(String userId);
}
