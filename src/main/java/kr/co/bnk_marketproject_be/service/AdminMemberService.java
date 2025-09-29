package kr.co.bnk_marketproject_be.service;

import kr.co.bnk_marketproject_be.dto.AdminMemberDTO;
import kr.co.bnk_marketproject_be.dto.AdminStoreDTO;
import kr.co.bnk_marketproject_be.entity.AdminMember;
import kr.co.bnk_marketproject_be.repository.AdminMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminMemberService {

    private final AdminMemberRepository adminMemberRepository;

    private final ModelMapper modelMapper;

    public List<AdminMemberDTO> getAllmember(){
        return adminMemberRepository.findByBoardType("memberlist")
                .stream()
                .map(entity -> modelMapper.map(entity, AdminMemberDTO.class))
                .toList();
    }
}
