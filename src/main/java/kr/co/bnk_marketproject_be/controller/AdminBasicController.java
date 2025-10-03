package kr.co.bnk_marketproject_be.controller;

import kr.co.bnk_marketproject_be.dto.AdminSiteConfigDTO;
import kr.co.bnk_marketproject_be.service.AdminSiteConfigService;
import kr.co.bnk_marketproject_be.service.AdminStorageService;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.core.env.Environment;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AdminBasicController {

    private final AdminSiteConfigService siteConfigService;
    private final Environment environment;
    private final AdminStorageService storageService;
    //기본설정
    // ===== GET =====
    @GetMapping("/admin/admin_basic")
    public String adminBasic(Model model, CsrfToken csrfToken) {
        // CSRF 토큰 터치(세션 생성용)
        csrfToken.getToken();

        AdminSiteConfigDTO config = siteConfigService.get();
        if (config == null) config = new AdminSiteConfigDTO();  // 프리필 비어도 에러는 안 나게

        model.addAttribute("config", config);
        model.addAttribute("appVersion",
                environment.getProperty("spring.application.version", "unknown"));
        return "admin/admin_basic";
    }
    // ===== POST =====
    @PostMapping("/admin/admin_basic")
    public String updateAdminBasic(
            @ModelAttribute("config") AdminSiteConfigDTO form,
            @RequestParam(required = false) MultipartFile headerLogoFile,
            @RequestParam(required = false) MultipartFile footerLogoFile,
            @RequestParam(required = false) MultipartFile faviconFile,
            @RequestParam(required = false, defaultValue = "false") boolean removeHeaderLogo,
            @RequestParam(required = false, defaultValue = "false") boolean removeFooterLogo,
            @RequestParam(required = false, defaultValue = "false") boolean removeFavicon,
                                   RedirectAttributes ra) {
        // 디버그 로그
        log.info("POST /admin/admin_basic form = {}", form);

        // 0) 현재 DB값 조회
        AdminSiteConfigDTO current = siteConfigService.get();
        if (current == null) current = new AdminSiteConfigDTO();

        // 1) 텍스트 필드 머지 (빈 값이면 기존 유지)
        String siteTitle    = blankToNull(form.getSiteTitle());
        String siteSubtitle = blankToNull(form.getSiteSubtitle());
        String version      = blankToNull(form.getVersion());

        form.setSiteTitle(    siteTitle    != null ? siteTitle    : current.getSiteTitle());
        form.setSiteSubtitle( siteSubtitle != null ? siteSubtitle : current.getSiteSubtitle());
        form.setVersion(      version      != null ? version      : current.getVersion());

        // 2) 파일 처리 (제거 > 새 업로드 > 기존 유지)
        try {
            // header
            if (removeHeaderLogo) {
                form.setHeaderLogo(null);
            } else if (headerLogoFile != null && !headerLogoFile.isEmpty()) {
                form.setHeaderLogo(storageService.saveAndReturnUrl(headerLogoFile, "header"));
            } else {
                form.setHeaderLogo( form.getHeaderLogo() != null ? form.getHeaderLogo() : current.getHeaderLogo() );
            }

            // footer
            if (removeFooterLogo) {
                form.setFooterLogo(null);
            } else if (footerLogoFile != null && !footerLogoFile.isEmpty()) {
                form.setFooterLogo(storageService.saveAndReturnUrl(footerLogoFile, "footer"));
            } else {
                form.setFooterLogo( form.getFooterLogo() != null ? form.getFooterLogo() : current.getFooterLogo() );
            }

            // favicon
            if (removeFavicon) {
                form.setFavicon(null);
            } else if (faviconFile != null && !faviconFile.isEmpty()) {
                form.setFavicon(storageService.saveAndReturnUrl(faviconFile, "favicon"));
            } else {
                form.setFavicon( form.getFavicon() != null ? form.getFavicon() : current.getFavicon() );
            }
        } catch (Exception e) {
            log.error("File upload error", e);
            ra.addFlashAttribute("msg", "파일 업로드 중 오류가 발생했습니다.");
            return "redirect:/admin/admin_basic";
        }

        // 파일 처리 끝난 직후
        log.info("==== DEBUG CHECK ====");
        log.info("form(after file) siteTitle    = {}", form.getSiteTitle());
        log.info("form(after file) siteSubtitle = {}", form.getSiteSubtitle());
        log.info("form(after file) version      = {}", form.getVersion());
        log.info("form(after file) headerLogo   = {}", form.getHeaderLogo());
        log.info("form(after file) footerLogo   = {}", form.getFooterLogo());
        log.info("form(after file) favicon      = {}", form.getFavicon());
        log.info("==== DEBUG CHECK END ====");


        log.info("form(after merge) = {}", form);

        // 3) upsert
        int updated = siteConfigService.upsert(form);
        log.info("updated rows = {}", updated);

        ra.addFlashAttribute("msg", "저장되었습니다.");
        return "redirect:/admin/admin_basic";
    }

    private String blankToNull(String s) {
        return (s == null || s.isBlank()) ? null : s;
    }




    //베너관리
    @GetMapping("/admin/admin_banner")
    public String adminBanner(){
        return "admin/admin_banner";
    }

    //약관관리
    @GetMapping("/admin/admin_policy")
    public String adminPolicy(){
        return "admin/admin_policy";
    }

    //카테고리
    @GetMapping("/admin/admin_category")
    public String adminCategory(){
        return "admin/admin_category";
    }

    //버전관리
    @GetMapping("/admin/admin_version")
    public String adminVersion(){
        return "admin/admin_version";
    }

}
