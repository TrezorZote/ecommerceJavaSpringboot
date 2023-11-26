package com.Worker.worker.Service.Implementation;


import com.Worker.worker.Service.Implementation.exception.UserNotFoundException;
import com.Worker.worker.Service.WorkerService;
import com.Worker.worker.Worker;
import com.Worker.worker.repo.WorkerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;
import java.util.UUID;


@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class WorkerServiceImplementation implements WorkerService {

    private final WorkerRepo workerRepo;

    @Override
    public void create( String productCategory,
                          Long contact,
                          String productLocation,
                          MultipartFile mainImage,String productDescription,MultipartFile[] extraImages,
                          Long productPassWord,
                          Long productPrice) {
        Worker worker= new Worker();
        String fileNameMain= StringUtils.cleanPath(Objects.requireNonNull(mainImage.getOriginalFilename()));
        try {
            byte[] mainImageData= mainImage.getBytes();
            worker.setImageUrl(mainImageData);
        }catch (IOException e){
            e.printStackTrace();
        }
        if (fileNameMain.contains("..")){
            System.out.print(" not valid file");
        }
        int i=0;
        for (MultipartFile extras: extraImages) {

           if (i==0){
               String fileNameExtras = StringUtils.cleanPath(Objects.requireNonNull(extras.getOriginalFilename()));
            try {
                byte[] extraImageData= extras.getBytes();
                worker.setMainImage1(extraImageData);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (fileNameExtras.contains("..")) {
                System.out.print(" not valid file");
            }
        }
            if (i==1){
                String fileNameExtras = StringUtils.cleanPath(Objects.requireNonNull(extras.getOriginalFilename()));
                try {
                    byte[] extraImageData2= extras.getBytes();
                    worker.setMainImage2(extraImageData2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (fileNameExtras.contains("..")) {
                    System.out.print(" not valid file");
                }
            }
            if (i==2){
                String fileNameExtras = StringUtils.cleanPath(Objects.requireNonNull(extras.getOriginalFilename()));
                try {
                    byte[] extraImageData3= extras.getBytes();
                    worker.setMainImage3(extraImageData3);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (fileNameExtras.contains("..")) {
                    System.out.print(" not valid file");
                }
            }
            if (i==3){
                String fileNameExtras = StringUtils.cleanPath(Objects.requireNonNull(extras.getOriginalFilename()));
                try {
                    byte[] extraImageData4= extras.getBytes();
                    worker.setMainImage4(extraImageData4);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (fileNameExtras.contains("..")) {
                    System.out.print(" not valid file");
                }
            }
           i++;
        }

        worker.setProductCategory(productCategory);
        worker.setContact(contact);
        worker.setProductDescription(productDescription);
        worker.setProductPassWord(productPassWord);
        worker.setProductLocation(productLocation);
        worker.setProductPrice(productPrice);
       worker.setIpAddress(UUID.randomUUID().toString());
       workerRepo.save(worker);
    }


    @Override
    public Collection<Worker> list(int limit) {
        System.out.println("fetching all servers" );
       return workerRepo.findAll(PageRequest.of(0,limit)).toList();

    }

    @Override
    public Worker find(Long id) {
        System.out.println("fetching id: {}" + id);
        return workerRepo.findWorkerById(id).orElseThrow(()-> new UserNotFoundException("the Worker with " + id + "was not found"));
    }

    @Override
    public Worker update(Worker worker) {
        System.out.println("Updating  Worker: {}" + worker.getProductCategory());
        return workerRepo.save(worker);

    }

    @Override
    public void delete(Long id) {
        System.out.println("Deleting Worker by id: {}"+ id);
        workerRepo.deleteById(id);

    }


}
