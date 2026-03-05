package com.board.springboard.controller;

import com.board.springboard.model.dto.Product;
import com.board.springboard.model.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    /*
    @RequestMapping 이 존재할경우 아래에 작선한 모든 매핑 앞에는
    /product 주소가 자동으로 붙는다
    @GetMapping("/list") 작성하더라도 주소창에서는 /product/list 형태로 들어가야지 제품 목록들을 확인할 수 있다

    @Param model jsp로 sql에서 가져온 데이터를 전달해주기위한 운반수단
    @return 클라이언트가 /product/list 주소로 접속했을 경우 보여질 jsp파일 선택하여 보여주겠다
     */
    // TODO 6. GET /product/list → 전체 목록 조회 후 View 반환
    // 조건 : model 에 "products" 키로 목록 담기 / return "product/list"
    @GetMapping("/list")
    public String 제품목록(Model model) {
        List<Product> productsData = productService.전체제품목록();
        model.addAttribute("products", productsData);
        return "redirect:/product/list"; // webapp/WEB-INF/views/product/list.jsp
    }

    // TODO 7. GET /product/add → addForm.jsp 반환
    // 조건 : Model 없이 뷰만 반환
    /*
    * Get /product/add 주소로 클라이언트가 접속하게 되면
    * 제품추가이기므로 SQL에서 가져올 데이터가 없으므로 Model model 사용하지 않는다
    *
    * @return webapp/WEB-INF/views/product/addForm.jsp 페이지를 반환처리한다
    * */
    @GetMapping("/add")
    public String 제품추가폼() {
        return "product/addForm";}

    // TODO 8. POST /product/add → 제품 추가 처리 후 redirect
    @PostMapping("/add")
    public String 제품추가처리(@ModelAttribute Product product,
                         RedirectAttributes redirectAttributes) {
        productService.제품추가(product);
        redirectAttributes.addFlashAttribute("msg", "제품이 등록되었습니다.");
        return "redirect:/product/list";
    }

    // TODO 9. GET /product/edit?id=1 → 단건 조회 후 editForm.jsp 반환
    // 조건 : @RequestParam 으로 id 받기
    @GetMapping("/edit")/*주소에서 ? 로 시작하는 경로는 Mapping 내에 작성하지 않는다*/
    public String 제품수정폼(@RequestParam int id, Model model) {
        // 수정할 제품 데이터 하나 가져오기
        Product product = productService.제품단건(id);
        model.addAttribute("product", product); // 수정할 데이터를 SQL에서 가져온 후 JSP 전달하기
        return "product/editForm";
    }

    // TODO 10. POST /product/edit → 제품 수정 처리 후 redirect
    @PostMapping("/edit") //Post/ Put / Patch 차이점을 인지하고 사용, 제품 수정하는데 문제는 없다
    public String 제품수정처리(@ModelAttribute Product product,
                         RedirectAttributes redirectAttributes) {
        productService.제품수정(product);
        redirectAttributes.addFlashAttribute("msg", "제품이 수정되었습니다.");
        return "redirect:/product/list";
    }

    // TODO 11. GET /product/delete?id=1 → 삭제 처리 후 redirect
    @GetMapping("/delete") // ? 이후는 Mapping 에서 작성하지 않는다
    public String 제품삭제처리(@RequestParam int id,
                         RedirectAttributes redirectAttributes) {
        productService.제품삭제(id);
        redirectAttributes.addFlashAttribute("msg", "제품이 삭제되었습니다.");
        //제품 리스트로 돌아가서 제품이 삭제되었다는 메세기즐ㄹ 잠깐 보기 위해 redirectAttributes로 가져온다
        return "redirect:/product/list";
    }
}
/*
* redirectAttributes.addFlashAttribute("msg", "제품이 삭제되었습니다.");
* 페이지와 연관은 없지만, 어떠한 작업을 하다 특정 페이지로 돌아갔는지
* 고객에게 메세지로 전달하기 위하여 설정하는 메세지 작업
*
*
* model.addAttribute("products", productsData);
* -> JSP파일에서 지속적으로 유지되어야 하는 데이터를 전달

 *
* */