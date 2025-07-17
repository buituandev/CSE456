package vn.edu.eiu.lab3.service;

import vn.edu.eiu.lab3.entity.Major;
import vn.edu.eiu.lab3.repository.MajorRepo;

import java.util.List;

public class MajorService {
    public void createMajor(Major major) {
        MajorRepo.save(major);
    }

    public void updateMajor(Major major) {
        MajorRepo.update(major);
    }

    public void deleteMajor(Major major) {
        MajorRepo.remove(major);
    }

    public Major getMajorById(String majorId) {
        return MajorRepo.findById(majorId);
    }

    public List<Major> getAllMajors() {
        return MajorRepo.findAll();
    }

    public List<Major> findMajorsByName(String name) {
        return MajorRepo.findByName(name);
    }
}
