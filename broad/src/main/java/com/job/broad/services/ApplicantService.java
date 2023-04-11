package com.job.broad.services;

import com.job.broad.dto.ApplicantDto;
import com.job.broad.entity.Applicant;
import com.job.broad.entity.User;
import com.job.broad.repository.ApplicantRepository;
import com.job.broad.repository.RoleRepository;
import com.job.broad.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
@Slf4j
public class ApplicantService {
    private final ApplicantRepository applicantRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.applicantRepository = applicantRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public void registerApplicant(ApplicantDto applicantDto) {

        Applicant applicant = new Applicant();
//        User users = new User();
//        Optional<User> userOptional = userRepository.findById(applicantDto.getId());
//        if (userOptional.isPresent()){
//            throw new ApiRequestException("id already exists!");
//        }
        applicant.setName(applicantDto.getName());
        applicant.setAge(applicantDto.getAge());
        applicant.setEmail(applicantDto.getEmail());
        applicant.setAddress(applicantDto.getAddress());
        applicant.setEducationdetails(applicantDto.getEducationdetails());
        applicant.setSkills(applicantDto.getSkills());
        User user=userRepository.findById(applicantDto.getUserId()).get();
        applicant.setUser(user);
        applicantRepository.save(applicant);

//        users.setUsername(applicantDto.getEmail());
//        roleRepository.findById(applicantDto.getRoleId())
//                .map(role -> {
//                    users.setRole(role);
//                    return users;
//                });
//        userRepository.save(users);
    }
}
