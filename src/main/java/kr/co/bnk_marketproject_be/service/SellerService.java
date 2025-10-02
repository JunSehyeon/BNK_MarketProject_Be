package kr.co.bnk_marketproject_be.service;

import kr.co.bnk_marketproject_be.dto.SellerDTO;
import kr.co.bnk_marketproject_be.dto.UserDTO;
import kr.co.bnk_marketproject_be.entity.Seller;
import kr.co.bnk_marketproject_be.entity.User;
import kr.co.bnk_marketproject_be.repository.SellerRepository;
import kr.co.bnk_marketproject_be.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SellerService {

    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    //    private int id;
//
//    private int userId;
//    private String sellerId;
//    private String brand_name;
//    private String biz_registration_number;
//    private String mail_order_number;

    public void save(SellerDTO sellerDTO) {
        // 비밀번호 암호화
        /*
        String encodedPass = passwordEncoder.encode(sellerDTO.getPassword());
        sellerDTO.setPassword(encodedPass);

        // DTO를 Entity로 변환
        Seller seller = modelMapper.map(sellerDTO, Seller.class);

        sellerRepository.save(seller);
        */
    }

    public UserDTO getUser(String sellerId){

        Optional<User> optUser = sellerRepository.findById(sellerId);

        if(optUser.isPresent()){

            User user = optUser.get();
            return modelMapper.map(user, UserDTO.class);
        }
        return null;
    }

    public List<UserDTO> getUserAll(){
        return null;
    }
    public void modify(UserDTO userDTO){}
    public void remove(String userId){}

    public int countUser(String type, String value){

        int count = 0;

        /*
        if(type.equals("userId")){
            count = sellerRepository.countByUser_id(value);
        }else if(type.equals("name")){
            count = sellerRepository.countByName(value);
        }else if(type.equals("email")){
            count = sellerRepository.countByEmail(value);

            if(count == 0){
                // 인증코드 이메일 전송
                emailService.sendCode(value);
            }

        }else if(type.equals("phone")){
            count = sellerRepository.countByPhone(value);
        }
        */
        return count;
    }


}
