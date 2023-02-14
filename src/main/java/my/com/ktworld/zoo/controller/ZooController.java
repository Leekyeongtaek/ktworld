package my.com.ktworld.zoo.controller;

import lombok.RequiredArgsConstructor;
import my.com.ktworld.common.ApiResponse;
import my.com.ktworld.zoo.dto.request.AnimalForm;
import my.com.ktworld.zoo.dto.request.ZookeeperForm;
import my.com.ktworld.zoo.service.ZooService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/zoo")
@RestController
public class ZooController {

    private final ZooService zooService;

    @PostMapping("/zookeeper")
    public ResponseEntity<ApiResponse<?>> createZookeeper(@RequestBody ZookeeperForm zookeeperForm) {
        zooService.createZookeeper(zookeeperForm);
        return new ResponseEntity<>(ApiResponse.createSuccessNoData(), HttpStatus.OK);
    }

    @PutMapping("/zookeeper")
    public ResponseEntity<ApiResponse<?>> updateZookeeper(@RequestBody ZookeeperForm zookeeperForm) {
        zooService.updateZookeeper(zookeeperForm);
        return new ResponseEntity<>(ApiResponse.createSuccessNoData(), HttpStatus.OK);
    }

    @PostMapping("/animal")
    public ResponseEntity<ApiResponse<?>> createAnimal(@RequestBody AnimalForm animalForm) {
        zooService.createAnimal(animalForm);
        return new ResponseEntity<>(ApiResponse.createSuccessNoData(), HttpStatus.OK);
    }

    @PutMapping("/animal")
    public ResponseEntity<ApiResponse<?>> updateAnimal(@RequestBody AnimalForm animalForm) {
        zooService.updateAnimal(animalForm);
        return new ResponseEntity<>(ApiResponse.createSuccessNoData(), HttpStatus.OK);
    }



}
