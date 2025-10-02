package kr.co.bnk_marketproject_be.service;

import kr.co.bnk_marketproject_be.dto.SessionDataDTO;
import kr.co.bnk_marketproject_be.dto.UserDTO;
import kr.co.bnk_marketproject_be.entity.User;
import kr.co.bnk_marketproject_be.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final SessionDataDTO sessionData;


    public void save(UserDTO userDTO) {
        // 비밀번호 암호화
        String encodedPass = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPass);

        // DTO를 Entity로 변환
        User user = modelMapper.map(userDTO, User.class);

        userRepository.save(user);
    }

    public UserDTO getUser(String userId){

        User user = userRepository.findByUserId(userId);

        return modelMapper.map(user, UserDTO.class);

    }


    /**
     * 서버사이드 회원가입 처리: 세션 인증 확인, 중복 체크, 비밀번호 암호화, DB 저장
     */
    public void register(UserDTO userDTO) {
        // 1) 서버 세션에서 이메일/휴대폰 인증 확인
        if (sessionData == null || !sessionData.isVerified() || !sessionData.isSmsVerified()) {
            throw new IllegalStateException("이메일 또는 휴대폰 인증을 완료해주세요.");
        }

        // 2) 중복 검사 - Repository 메서드 이름에 맞춰 사용하세요
        // 예: existsByUserid / existsByEmail / existsByPhone 등
        if (userRepository.existsByUserId(userDTO.getUserId())) {
            throw new IllegalStateException("이미 사용중인 아이디입니다.");
        }
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalStateException("이미 사용중인 이메일입니다.");
        }
        if (userDTO.getPhone() != null && userRepository.existsByPhone(userDTO.getPhone())) {
            throw new IllegalStateException("이미 사용중인 휴대폰 번호입니다.");
        }

        // 3) 비밀번호 암호화 및 DTO->Entity 변환 저장
        String encoded = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encoded);

        User user = modelMapper.map(userDTO, User.class);
        // 필요하면 기본 role 설정
        user.setRole("ROLE_USER");

        userRepository.save(user);

        // 4) 선택사항: 세션 인증 상태 초기화
        sessionData.setVerified(false);
        sessionData.setSmsVerified(false);
    }




    public List<UserDTO> getUserAll(){
        return null;
    }
    public void modify(UserDTO userDTO){}
    public void remove(String userId){}

    public int countUser(String type, String value){

        int count = 0;

        if(type.equals("user_id")){
            //count = userRepository.countByUser_id(value);
        }else if(type.equals("name")){
            count = userRepository.countByName(value);
        }else if(type.equals("email")){
            count = userRepository.countByEmail(value);

            if(count == 0){
                // 인증코드 이메일 전송
                emailService.sendCode(value);
            }

        }else if(type.equals("phone")){
            count = userRepository.countByPhone(value);
        }
        return count;
    }





}
