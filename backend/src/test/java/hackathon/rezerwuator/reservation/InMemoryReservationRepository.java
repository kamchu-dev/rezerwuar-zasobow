package hackathon.rezerwuator.reservation;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class InMemoryReservationRepository implements ReservationRepository{
    private Set<Reservation> reservations = new HashSet<>();
    @Override
    public List<Reservation> deleteByResourceCodeAndUserId(String resourceCode, Long userId) {
        reservations.removeIf(reservation -> reservation.getResourceCode().equals(resourceCode) && reservation.getUserId().equals(userId));
        return new ArrayList(reservations);
    }

    @Override
    public List<Reservation> findByResourceCode(String resourceCode) {
        return reservations.stream().filter(reservation -> reservation.getResourceCode().equals(resourceCode)).collect(Collectors.toList());
    }

    @Override
    public List<Reservation> findByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Reservation> findByResourceCodeAndUserId(String resourceCode, Long userId) {
        return null;
    }

    @Override
    public boolean existsByResourceCodeAndUserId(String resourceCode, Long userId) {
        return false;
    }

    @Override
    public List<Reservation> findAll() {
        return new ArrayList<>(reservations);
    }

    @Override
    public List<Reservation> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Reservation> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Reservation> findAllById(Iterable<String> iterable) {
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
    public void delete(Reservation reservation) {

    }

    @Override
    public void deleteAll(Iterable<? extends Reservation> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Reservation save(Reservation s) {
        reservations.add(s);
        return s;
    }

    @Override
    public <S extends Reservation> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Reservation> findById(String s) {
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
    public <S extends Reservation> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Reservation> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Reservation getOne(String s) {
        return null;
    }

    @Override
    public <S extends Reservation> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Reservation> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Reservation> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Reservation> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Reservation> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Reservation> boolean exists(Example<S> example) {
        return false;
    }
}
