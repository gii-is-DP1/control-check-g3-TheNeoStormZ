package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@PostMapping(value = "/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom room, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_ROOMS_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.roomService.save(room);
			
			return "welcome";
		}
	}
	
	
}
