package vn.edu.eiu.theo7.fecse4562131200024demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.theo7.fecse4562131200024demo.model.Major;
import vn.edu.eiu.theo7.fecse4562131200024demo.repo.MajorRepo;

import java.util.List;

@Service
public class MajorService {
    @Autowired
    private MajorRepo majorRepo;
    
    public void saveMajor(Major major) {
        majorRepo.save(major);
    }
    
    public List<Major> getAllMajors() {
        return majorRepo.findAll();
    }
}
