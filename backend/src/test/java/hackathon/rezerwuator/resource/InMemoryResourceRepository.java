package hackathon.rezerwuator.resource;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class InMemoryResourceRepository implements ResourceRepository{
    private Set<Resource> resources = new HashSet<>();

    @Override
    public List<Resource> findAll() {
        return null;
    }

    @Override
    public List<Resource> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Resource> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Resource> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Resource resource) {

    }

    @Override
    public void deleteAll(Iterable<? extends Resource> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Resource  save(Resource s) {
        resources.add(s);
        return s;
    }

    @Override
    public <S extends Resource> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Resource> findById(String s) {
        return resources.stream().filter( resource -> resource.getCode().equals(s)).findAny();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Resource> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Resource> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Resource getOne(String s) {
        return null;
    }

    @Override
    public <S extends Resource> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Resource> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Resource> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Resource> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Resource> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Resource> boolean exists(Example<S> example) {
        return false;
    }
}
