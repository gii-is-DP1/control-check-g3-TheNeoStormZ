package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RecoveryRoomService {
	
	private RecoveryRoomRepository rp;
	
	@Autowired
    public RecoveryRoomService(RecoveryRoomRepository rp) {
		this.rp = rp;
	}

	public List<RecoveryRoom> getAll(){
        return rp.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return null;
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return null;
    }

    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
        return null;
    }

    public RecoveryRoom save(RecoveryRoom p) {
        return rp.save(p);       
    }

    
}
