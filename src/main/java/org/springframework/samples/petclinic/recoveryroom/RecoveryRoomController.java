package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecoveryRoomController {
	
	private static final String VIEWS_ROOMS_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
    
	private final RecoveryRoomService roomService;
	
	@Autowired
	public RecoveryRoomController(RecoveryRoomService roomService) {
		this.roomService = roomService;
	}
	
	@GetMapping(value = "/recoveryroom/create")
	public String initCreationForm(Map<String, Object> model) {
		RecoveryRoom room = new RecoveryRoom();
		model.put("recoveryRoom", room);
		
		List<RecoveryRoomType> list = roomService.getAllRecoveryRoomTypes();
		model.put("types", list);
		
		return VIEWS_ROOMS_CREATE_OR_UPDATE_FORM;
	}
	
	
}
