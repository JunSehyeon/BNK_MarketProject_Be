package kr.co.bnk_marketproject_be.service;

import com.querydsl.core.Tuple;
import kr.co.bnk_marketproject_be.dto.AdminStoreDTO;
import kr.co.bnk_marketproject_be.dto.PageRequestDTO;
import kr.co.bnk_marketproject_be.dto.PageResponseDTO;
import kr.co.bnk_marketproject_be.entity.AdminStore;
import kr.co.bnk_marketproject_be.repository.AdminStoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminStoreService {

    private final AdminStoreRepository adminStoreRepository;

    private final ModelMapper modelMapper;

    public PageResponseDTO findAdminStoreAll(PageRequestDTO pageRequestDTO){

        Pageable pageable = pageRequestDTO.getPageable("id");

        Page<Tuple> pageTuple = null;
        if(pageRequestDTO.getSearchType() != null){
            // 검색 글 검색
            pageTuple = adminStoreRepository.selectAdminStoreAllForSearch(pageRequestDTO, pageable);
        }else{
            // 일반 글 목록
            pageTuple = adminStoreRepository.selectAdminStoreAllForList(pageRequestDTO, pageable);
        }

        log.info("pageTuple={}",pageTuple);
        List<Tuple> tupleList = pageTuple.getContent();
        int total = (int)pageTuple.getTotalElements();

        List<AdminStoreDTO> dtoList = tupleList.stream()
                .map(tuple -> {
                    AdminStore adminStore = tuple.get(0, AdminStore.class);
                    String name = tuple.get(1, String.class);
                    String user_id = tuple.get(2, String.class);
                    String email = tuple.get(3, String.class);
                    String phone = tuple.get(4, String.class);
                    String address = tuple.get(5,String.class);
                    String role = tuple.get(6, String.class);

                    adminStore.setName(name);
                    adminStore.setUser_id(user_id);
                    adminStore.setEmail(email);
                    adminStore.setPhone(phone);
                    adminStore.setAddress(address);
                    adminStore.setRole(role);


                    return modelMapper.map(adminStore, AdminStoreDTO.class);
                })
                .toList();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(total)
                .build();
    }


}
