package com.azadkaya.ticketapp.service.Impl;

import com.azadkaya.ticketapp.dto.request.UserRequestDto;
import com.azadkaya.ticketapp.dto.response.UserResponseDto;
import com.azadkaya.ticketapp.mapper.UserMapper;
import com.azadkaya.ticketapp.model.Role;
import com.azadkaya.ticketapp.model.User;
import com.azadkaya.ticketapp.repository.RoleRepository;
import com.azadkaya.ticketapp.repository.UserRepository;
import com.azadkaya.ticketapp.security.SecurityUtils;
import com.azadkaya.ticketapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserResponseDto> findAll() {
        return userMapper.toDto(userRepository.findAll());
    }

    @Override
    public UserResponseDto finByUserId(Long userId) {
        return userRepository.findById(userId)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserResponseDto createRegister(UserRequestDto dto) {
        logger.info("createRegister işlemi başlatıldı. Kullanıcı adı: {}", dto.getUsername());
        try {
            User user = userMapper.toEntity(dto);
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            List<Role> roles = roleRepository.findByNameIn(dto.getRoles());
            user.setRoles(roles);
            User savedUser = userRepository.save(user);
            logger.info("Kullanıcı başarıyla oluşturuldu. Kullanıcı ID: {}", savedUser.getId());
            return userMapper.toDto(savedUser);
        } catch (Exception e) {
            logger.error("Kullanıcı oluşturma sırasında hata: ", e);
            throw new RuntimeException("Kullanıcı oluşturulamadı.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities() {
        return SecurityUtils.getCurrentUserLogin()
                .flatMap(userRepository::findOneWithRolesByUsername);
    }

}
