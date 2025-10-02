package kr.co.bnk_marketproject_be.service;

import com.querydsl.core.Tuple;
import kr.co.bnk_marketproject_be.dto.*;
import kr.co.bnk_marketproject_be.dto.AdminMemberDTO;
import kr.co.bnk_marketproject_be.entity.AdminMember;
import kr.co.bnk_marketproject_be.entity.AdminMember;
import kr.co.bnk_marketproject_be.repository.AdminMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminMemberService {

    private final AdminMemberRepository adminMemberRepository;

    private final ModelMapper modelMapper;

    public PageResponseAdminMemberDTO findAdminMemberAll(PageRequestDTO pageRequestDTO){

        Pageable pageable = pageRequestDTO.getPageable("id");

        Page<Tuple> pageTuple = null;
        if(pageRequestDTO.getSearchType() != null){
            // 검색 글 검색
            pageTuple = adminMemberRepository.selectAdminMemberAllForSearch(pageRequestDTO, pageable);
        }else{
            // 일반 글 목록
            pageTuple = adminMemberRepository.selectAdminMemberAllForList(pageRequestDTO, pageable);
        }

        log.info("pageTuple={}",pageTuple);
        List<Tuple> tupleList = pageTuple.getContent();
        int total = (int)pageTuple.getTotalElements();

        List<AdminMemberDTO> dtoList = tupleList.stream()
                .map(tuple -> {
                    AdminMember adminMember = tuple.get(0, AdminMember.class);
                    String name = tuple.get(1, String.class);
                    String userId = tuple.get(2, String.class);
                    String email = tuple.get(3, String.class);
                    String phone = tuple.get(4, String.class);
                    String address = tuple.get(5,String.class);
                    String role = tuple.get(6, String.class);

                    adminMember.setName(name);
                    adminMember.setUserId(userId);
                    adminMember.setEmail(email);
                    adminMember.setPhone(phone);
                    adminMember.setAddress(address);
                    adminMember.setRole(role);


                    return modelMapper.map(adminMember, AdminMemberDTO.class);
                })
                .toList();

        return PageResponseAdminMemberDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(total)
                .build();
    }
}