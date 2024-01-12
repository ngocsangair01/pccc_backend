package org.example.buoi3.services.imp;

import org.example.buoi3.repositories.ClassRepository;
import org.example.buoi3.services.IClassService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImp implements IClassService {

    private final ClassRepository classRepository;

    public ClassServiceImp(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public Classs createClass(Classs classs) {
        classRepository.save(classs);
        Classs classs1 = classRepository.findById(classs.getId()).get();
        return classs;
    }

    @Override
    public List<Classs> getListClass() {
        List<Classs> classsList = classRepository.findAll();
        return classsList;
    }

    @Override
    public Classs putMappingClass(Long id, Classs classs) {
        Optional<Classs> classsOptional = classRepository.findById(id);
        if (classsOptional.isEmpty()){
            return null;
        }
        classsOptional.get().setName(classs.getName());
        classsOptional.get().setGrade(classs.getGrade());
        classRepository.save(classsOptional.get());
        return classsOptional.get();
    }

    @Override
    public Classs deleteClass(Long id) {
        //Luồng xóa đối tượng, xong in ra đối tượng vừa xóa
        Optional<Classs> classs = classRepository.findById(id);
        classRepository.deleteById(id);
        return classs.get();
    }

    @Override
    public Classs patchMappingClass(Long id, Classs classs) {
        return null;
    }
}
