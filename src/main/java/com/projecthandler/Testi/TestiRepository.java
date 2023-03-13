package com.projecthandler.Testi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestiRepository extends JpaRepository<Testi, Long> {}
