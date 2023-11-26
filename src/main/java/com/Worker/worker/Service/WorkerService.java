package com.Worker.worker.Service;

import com.Worker.worker.Worker;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

public interface WorkerService {
    public void create( String category,
                        Long contact,
                        String productLocation,
                        MultipartFile mainImage,String productDescription,MultipartFile[] extraImages,
                        Long productPassWord,
                        Long productPrice) throws IOException;
    Collection<Worker> list(int limit );
    Worker find( Long id) ;
    Worker update(Worker worker);
    void delete(Long id);


}
