package com.Worker.worker.Resource;


import com.Worker.worker.Service.Implementation.WorkerServiceImplementation;
import com.Worker.worker.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class WorkerControler {
    private final WorkerServiceImplementation workerServiceImplementation;
    @GetMapping("/all")
    public ResponseEntity<List<Worker>> getAllWorkers(){
        List<Worker> workers= (List<Worker>) workerServiceImplementation.list(1000);
        return  new ResponseEntity<>(workers, OK);

    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable("id")Long id){
        Worker worker= workerServiceImplementation.find(id);
        return  new ResponseEntity<>(worker, OK);

    }
    @PostMapping("/create" )
    public String createWorker(@RequestParam (  required = false, name="category") String category,
                                   @RequestParam ( required = false, name = "price") Long price,
                                   @RequestParam (required = false , name = "contact") Long contact,
                                   @RequestParam (required = false , name = "description") String description,
                                   @RequestParam ( required = false,name = "location") String location,
                                   @RequestParam (required = false,name = "password") Long password,
                                   @RequestParam(required = false,name = "mainImage")  MultipartFile mainImage,
                                   @RequestParam(required = false,name = "extras") MultipartFile[] extras) throws IOException {

        workerServiceImplementation.create(category,contact,location,mainImage,description,extras,
                password,price);
        return "product " + category + " created successfully";
    }
    @PutMapping("/update")
    public ResponseEntity<Worker> updateWorker(@RequestBody Worker worker){
        Worker updatedWorker= workerServiceImplementation.update(worker);
        return  new ResponseEntity<>(updatedWorker, OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteWorkerById(@PathVariable("id")Long id){
       workerServiceImplementation.delete(id);
        return  new ResponseEntity<>(OK);

    }
}

