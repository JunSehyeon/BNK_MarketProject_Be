package kr.co.bnk_marketproject_be.service;

import kr.co.bnk_marketproject_be.dto.AdminStoreDTO;
import kr.co.bnk_marketproject_be.entity.AdminStore;
import kr.co.bnk_marketproject_be.repository.AdminStoreRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminStoreService {

    private final AdminStoreRepository adminStoreRepository;

    private final ModelMapper modelMapper;

    public List<AdminStoreDTO> findAdminStoreAll(){
        return adminStoreRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, AdminStoreDTO.class))
                .toList();
    }


}
