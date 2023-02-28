package my.com.ktworld.zoo.controller;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.com.ktworld.common.ApiResponse;
import my.com.ktworld.zoo.dto.request.AnimalForm;
import my.com.ktworld.zoo.dto.request.AnimalSearchCondition;
import my.com.ktworld.zoo.dto.request.ZookeeperForm;
import my.com.ktworld.zoo.dto.request.ZookeeperSave;
import my.com.ktworld.zoo.dto.request.ZookeeperSearchCondition;
import my.com.ktworld.zoo.dto.response.AnimalDto;
import my.com.ktworld.zoo.dto.response.ZookeeperDto;
import my.com.ktworld.zoo.service.ZooService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/zoo")
@RestController
public class ZooController {

    private final ZooService zooService;

    // 에러 발생.
    // BindingResult 파싱. -> 응답 객체에 담아서 리턴...
    // 에러 객체에 담아서 리턴.

    //todo ApiResponse 다시 추가.
    @PostMapping("/zookeepers")
    public ResponseEntity<ApiResponse<ApiResponse<?>>> createZookeeper(@Validated @RequestBody ZookeeperSave zookeeperSave,
        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            ErrorResponse response = new ErrorResponse();
//            response.createErrors(bindingResult);
//            ApiResponse<?> errors = ApiResponse.createErrors(bindingResult);
//            log.info("생성 에러 = {}", errors);
//            return new ResponseEntity<>(errors, BAD_REQUEST);
            return null;
        }
        zooService.createZookeeper(zookeeperSave);
//        return new ResponseEntity<>(ApiResponse.createSuccessNoData(), OK);
        return null;
    }

    @PutMapping("/zookeepers")
    public ResponseEntity<ApiResponse<?>> updateZookeeper(@RequestBody ZookeeperForm zookeeperForm) {
        zooService.updateZookeeper(zookeeperForm);
//        return new ResponseEntity<>(ApiResponse.createSuccessNoData(), OK);
        return null;
    }

    @GetMapping("/zookeepers")
    public ResponseEntity<ApiResponse<Page<ZookeeperDto>>> searchZookeepers(ZookeeperSearchCondition condition, Pageable pageable) {
        return new ResponseEntity<>(zooService.searchZookeepers(condition, pageable), OK);
    }

    @GetMapping("/zookeepers/{zookeeper_id}")
    public ResponseEntity<ApiResponse<ZookeeperDto>> selectZookeeper(@PathVariable(value = "zookeeper_id") Long zookeeperId) {
        ApiResponse<ZookeeperDto> zookeeperDtoApiResponse = zooService.selectZookeeper(zookeeperId);
        return new ResponseEntity<>(zookeeperDtoApiResponse, OK);
    }

    @PostMapping("/animals")
    public ResponseEntity<ApiResponse<?>> createAnimal(@RequestBody AnimalForm animalForm) {
        zooService.createAnimal(animalForm);
//        return new ResponseEntity<>(ApiResponse.createSuccessNoData(), OK);
        return null;
    }

    @PutMapping("/animals")
    public ResponseEntity<ApiResponse<?>> updateAnimal(@RequestBody AnimalForm animalForm) {
        zooService.updateAnimal(animalForm);
//        return new ResponseEntity<>(ApiResponse.createSuccessNoData(), OK);
        return null;
    }

    @GetMapping("/animals")
    public ResponseEntity<ApiResponse<Page<AnimalDto>>> searchAnimals(AnimalSearchCondition condition, Pageable pageable) {
        return new ResponseEntity<>(zooService.searchAnimals(condition, pageable), OK);
    }

    @GetMapping("/animals/{animal_id}")
    public ResponseEntity<ApiResponse<AnimalDto>> selectAnimal(@PathVariable(value = "animal_id") Long animalId) {
        ApiResponse<AnimalDto> animalDtoApiResponse = zooService.selectAnimal(animalId);
        return new ResponseEntity<>(animalDtoApiResponse, OK);
    }

}
