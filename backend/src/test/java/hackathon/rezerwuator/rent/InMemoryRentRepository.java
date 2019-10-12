package hackathon.rezerwuator.rent;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class InMemoryRentRepository implements RentRepository{
    private Set<Rent> rentals  = new HashSet<>();
    @Override
    public Optional<Rent> findByIdAndRentedIsFalse(String code) {
        return Optional.empty();
    }

    @Override
    public boolean existsByResourceCodeAndRentedIsTrue(String resourceCode) {
        return rentals.stream().anyMatch(rent -> rent.getResourceCode().equals(resourceCode) && rent.isRented());
    }

    @Override
    public Optional<Rent> findByResourceCodeAndRentedIsFalse(String resourceCode) {
        return rentals.stream().filter(rent -> rent.getResourceCode().equals(resourceCode) && !rent.isRented()).findAny();
    }

    @Override
    public List<Rent> findAllByRented(boolean rented) {
        return null;
    }

    @Override
    public List<Rent> findAllByUserIdAndRentedIsTrue(long userId) {
        return null;
    }

    @Override
    public Optional<Rent> findByResourceCodeAndRentedIsTrue(String resourceCode) {
        return rentals.stream().filter(rent -> rent.getResourceCode().equals(resourceCode) && rent.isRented()).findAny();
    }

    @Override
    public List<Rent> findAll() {
        return null;
    }

    @Override
    public List<Rent> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Rent> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Rent> findAllById(Iterable<String> iterable) {
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
    public void delete(Rent rent) {

    }

    @Override
    public void deleteAll(Iterable<? extends Rent> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Rent save(Rent s) {
        rentals.add(s);
        return s;
    }

    @Override
    public <S extends Rent> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Rent> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Rent> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Rent> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Rent getOne(String s) {
        return null;
    }

    @Override
    public <S extends Rent> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Rent> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Rent> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Rent> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Rent> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Rent> boolean exists(Example<S> example) {
        return false;
    }
}
