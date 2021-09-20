package com.shopping.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.shopping.service.ProductService;
import com.shopping.vo.ProductImageVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class FileAPIController {
    @Autowired ProductService prod_service;
    @PostMapping("/upload")
    public Map<String, Object> postFileUpload (@RequestPart MultipartFile file) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        Path folderLocation = Paths.get("/shopping/image");
        
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String[] splitFileName = fileName.split("\\.");
        String ext = splitFileName[splitFileName.length-1];

        if(
            !ext.equalsIgnoreCase("jpg") &&
            !ext.equalsIgnoreCase("jpeg") &&
            !ext.equalsIgnoreCase("png") &&
            !ext.equalsIgnoreCase("gif")
        ) {
            resultMap.put("status", false);
            resultMap.put("message", "jpg, jpeg, png, gif파일만 등록할 수 있습니다.");
            return resultMap;
        }

        String saveFileName = null;
        Calendar c = Calendar.getInstance();

        String uriName = ""+c.getTimeInMillis();
        saveFileName = uriName+"."+ext;

        Path target = folderLocation.resolve(saveFileName);
        try {
            Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
        }
        catch(IOException e){
            resultMap.put("status", false);
            resultMap.put("message", e.getMessage());
            return resultMap;
        }
        //이름, 사이즈, uri를 지정하여 DB에 전송하기
        String image_uri = "product_image_"+uriName;
        ProductImageVO pimgVO = new ProductImageVO();
        pimgVO.setPimg_file_name(saveFileName);
        pimgVO.setPimg_size((int)file.getSize());
        pimgVO.setPimg_uri(image_uri);

        prod_service.insertProductImages(pimgVO);

        resultMap.put("status", true);
        resultMap.put("message", "파일 업로드 완료");
        resultMap.put("image_uri",image_uri);
        return resultMap;
    }
    //저장한 파일 불러오기
    @GetMapping("/image/{uri}")
    //HttpServletRequest 가져온 파일의 유형을 알려고 할 때 이용
    public ResponseEntity<Resource> getImage(@PathVariable String uri, HttpServletRequest request) throws Exception{
        //파일 저장 위치를 알아야 한다.
        Path folderLocation = Paths.get("/shopping/image");
        //uri를 통해서 진짜 파일 이름을 가져와야 한다. 요청은 uri로 받고 실제 파일은 실제 파일으로.
        String fileName = prod_service.selectProdImagePath(uri);

        if(fileName == null) {
            return null;
        }
        // 파일의 실제 경로 생성.
        Path filePath = folderLocation.resolve(fileName).normalize();
        Resource r = new UrlResource(filePath.toUri());

        String contentType = request.getServletContext().getMimeType(r.getFile().getAbsolutePath());
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=\""+r.getFilename()+"\"")
                .body(r);
    }
        
        
}
