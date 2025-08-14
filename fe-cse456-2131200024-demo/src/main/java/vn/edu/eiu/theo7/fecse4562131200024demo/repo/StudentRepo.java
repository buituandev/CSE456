package vn.edu.eiu.theo7.fecse4562131200024demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.eiu.theo7.fecse4562131200024demo.model.Major;
import vn.edu.eiu.theo7.fecse4562131200024demo.model.Student;

import java.util.List;

/**
 * Jpa repository la interface trong spring data jpa. Chua tat ca cac ham abstract xu ly crud tren database
 * Luc ke thua se truyen vao ten class entity va kieu du lieu cua khoa chinh
 * Trong jpa repository da xay dung cac phuong thuc abstract tu sinh hau nhu la phuc vu duoc cac thao tac co ban xuong database
 */
@Repository
public interface StudentRepo extends JpaRepository<Student, String> {
    List<Student> searchAllByNameContainingIgnoreCase(String name);
}
