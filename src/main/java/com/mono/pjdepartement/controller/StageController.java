package com.mono.pjdepartement.controller;

import java.util.List;

import com.mono.pjdepartement.service.StageService;
import com.mono.pjdepartement.entity.app.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/Stage")
public class StageController {

	@Autowired
    StageService stageService;
	
	@PostMapping(path = "/create")
    public ResponseEntity<String> creatStage(@RequestBody Stage stage){
        return stageService.createStage(stage);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateStage(@RequestBody Stage stage, @PathVariable Long id){
        return stageService.updateStage(stage, id);
    }

    @GetMapping(path = "/read")
    public List<Stage> readAllStage(){
        return stageService.getAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteStage(@PathVariable Long id){
        return stageService.deleteStage(id);
    }

    @GetMapping("/poste/{poste}")
    public List<Stage> getStageByPoste(@PathVariable String poste) {
        return stageService.findByPoste(poste);
    }
}
