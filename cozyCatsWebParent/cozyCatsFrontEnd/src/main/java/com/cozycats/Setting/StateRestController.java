package com.cozycats.Setting;

import java.util.ArrayList;
import java.util.List;

import com.cozycats.cozycatscommon.entity.Country;
import com.cozycats.cozycatscommon.entity.State;
import com.cozycats.cozycatscommon.entity.StateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StateRestController {

	@Autowired private StateRepository repo;
	
	@GetMapping("/settings/list_states_by_country/{id}")
	public List<StateDTO> listByCountry(@PathVariable("id") Integer countryId) {
		List<State> listStates = repo.findByCountryOrderByNameAsc(new Country(countryId));
		List<StateDTO> result = new ArrayList<>();
		
		for (State state : listStates) {
			result.add(new StateDTO(state.getId(), state.getName()));
		}
		
		return result;
	}

}
