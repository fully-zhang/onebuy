package com.onebuy.rest.files;

import com.onebuy.util.FileUtil;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created by zhj on 2017/9/22 0022.
 */

@RestController
@RequestMapping("/files")
public class FilesRest {

    @GetMapping("/uploadExcel")
    public void uploadExcel(@RequestParam MultipartFile file, HttpServletResponse response) {

    }

    @GetMapping("/getPdf")
    public void downloadPdf(@RequestParam String name, HttpServletResponse response) throws IOException {
        FileUtil.download(response,new File("D:\\pdf\\"+name),name,null);
    }

}
