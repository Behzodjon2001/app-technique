package com.company;

import com.company.config.CustomUserDetails;
import com.company.dto.ProfileDTO;
import com.company.entity.ProfileEntity;
import com.company.enums.ProfileRole;
import com.company.service.ProfileService;
import com.company.util.JwtUtil;
import com.company.util.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@SpringBootTest
class AppTechniqueApplicationTests {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Test
    void contextLoads() {
        ProfileDTO profile = new ProfileDTO();
        profile.setName("Adminjon");
        profile.setSurname("Adminjonov");
        profile.setEmail("admin@gmail.uz");
        profile.setPhone("+998914640908");
        profile.setPassword(MD5Util.getMd5("123"));
        profile.setRole(ProfileRole.ROLE_ADMIN);
        profileService.create(profile);
    }
    @Test
    void contextLoads2() {

        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken("admin@gmail.uz", "123"));
        CustomUserDetails user = (CustomUserDetails) authenticate.getPrincipal();
        ProfileEntity profile = user.getProfile();

        ProfileDTO dto = new ProfileDTO();
        dto.setName(profile.getName());
        dto.setSurname(profile.getSurname());
        dto.setJwt(JwtUtil.encode(profile.getId(), profile.getRole()));
    }

}
