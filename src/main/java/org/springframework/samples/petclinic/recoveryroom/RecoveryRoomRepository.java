package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
    List<RecoveryRoom> findAll();
    
    @Query("SELECT r FROM RecoveryRoomType r")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    
    @Query("SELECT r FROM RecoveryRoomType r WHERE r.name LIKE :name")
    RecoveryRoomType getRecoveryRoomType(@Param("name") String name);
    
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
    
    @Query("SELECT r FROM RecoveryRoom r WHERE r.size > :size")
    List<RecoveryRoom> findBySizeMoreThan(@Param("size") double size);
    
   
}
