package com.GTasteriX.demo.Repository;

import com.GTasteriX.demo.Entity.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryRepo extends JpaRepository<Enquiry,Integer> {
}
